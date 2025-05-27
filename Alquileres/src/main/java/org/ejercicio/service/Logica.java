package org.ejercicio.service;

import org.ejercicio.dto.CrearPago;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Join;
import org.hibernate.*;
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
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<rental_contract> query = cb.createQuery(rental_contract.class);
            Root<rental_contract> root = query.from(rental_contract.class);
            query.select(root)
                    .where(cb.equal(root.get("contract_id"), pago.getId()));
            contractResult = session.createQuery(query).uniqueResult();
        }
        if (contractResult == null) {
            return false;
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

        if (amountResult.compareTo(contractResult.getMonthlyRent() * contratResult.get) >= 0) {
            return false;
        }
    }
}
