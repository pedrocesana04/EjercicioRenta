package org.ejercicio.service;

import org.ejercicio.dto.CrearPago;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Join;
import org.ejercicio.dto.Filtro;
import org.hibernate.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;
import java.util.stream.Collectors;
import org.ejercicio.models.rental_contract;
import org.ejercicio.models.rent_payment;
import org.ejercicio.utils.HibernateUtil;

public class Logica {
    private static Logica instance;

    private Logica() {
    }

    public static Logica getInstance() {
        if (instance == null) {
            instance = new Logica();
        }
        return instance;
    }

    public boolean CearPago(CrearPago pago) {
        BigDecimal amountResult = BigDecimal.ZERO;
        rental_contract contractResult;
        try (Session session = HibernateUtil.getSession()) {
            contractResult = session.get(rental_contract.class, pago.getId());
        }
        if (contractResult == null) {
            return false;
        }

        try(Session session= HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            rent_payment newPayment = new rent_payment();
            newPayment.setContract_id(contractResult);
            newPayment.setPayDate(LocalDateTime.now());
            newPayment.setAmount(pago.getAmount());
            session.save(newPayment);
            transaction.commit();
        }

        List<BigDecimal> results;
        try (Session session = HibernateUtil.getSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<BigDecimal> query = cb.createQuery(BigDecimal.class);
            Root<rent_payment> root = query.from(rent_payment.class);
            Join<rent_payment, rental_contract> join = root.join("contract_id");
            query.select(cb.sum(root.get("amount")))
                    .where(cb.equal(join.get("id"), pago.getId()));
            results = session.createQuery(query).getResultList();
        }
        for (BigDecimal result : results) {
            amountResult = amountResult.add(result);
        }
        System.out.println("Total amount paid: " + amountResult);
        System.out.println("Total amount rent: " + contractResult.getTotalRent());
        if (amountResult.compareTo(contractResult.getTotalRent()) >= 0) {
            contractResult.setStatus(org.ejercicio.Enums.contract_status.COMPLETED);
        }else{
            if(contractResult.getEndDate().isBefore(LocalDateTime.now())) {
                contractResult.setStatus(org.ejercicio.Enums.contract_status.OVERDUE);
            }
            else{
                return true;
            }
        }
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(contractResult);
            transaction.commit();
        }
        return true;
    }

    public List<rental_contract> getContracts(Filtro filtro){
        List<rental_contract> results = new ArrayList<>();
        try (Session session = HibernateUtil.getSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<rental_contract> query = cb.createQuery(rental_contract.class);
            Root<rental_contract> root = query.from(rental_contract.class);
            List<Predicate> predicates = new ArrayList<>();

            if (filtro.getNname() != null && !filtro.getNname().isEmpty()) {
                predicates.add(cb.like(root.get("tenant_name"), "%" + filtro.getNname() + "%"));
            }
            else{
                throw new IllegalArgumentException("Tenant name cannot be null or empty");
            }
            if (filtro.getPropertyType() != null) {
                predicates.add(cb.equal(root.get("property_type"), filtro.getPropertyType()));
            }
            if (filtro.getMintDate() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("end_date"), filtro.getMintDate()));
            }
            if (filtro.getMaxtDate() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("end_date"), filtro.getMaxtDate()));
            }
            if (filtro.getMinAmount() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("monthly_rent"), filtro.getMinAmount()));
            }
            if (filtro.getMaxAmount() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("monthly_rent"), filtro.getMaxAmount()));
            }

            query.select(root).where(cb.and(predicates.toArray(new Predicate[0])));
            query.orderBy(cb.desc(root.get("start_date")));
            results = session.createQuery(query).getResultList();
        }
        return results;
    }
}
