package org.ejercicio;

import org.ejercicio.models.rental_contract;
import org.ejercicio.service.Logica;
import org.ejercicio.dto.CrearPago;
import org.ejercicio.dto.Filtro;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static final Logica logica = Logica.getInstance();
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Ingrese el ID del contrato:");
        long contractId = scanner.nextLong();
        System.out.println("Ingrese el monto del pago:");
        BigDecimal amount = scanner.nextBigDecimal();

        CrearPago pago = new CrearPago();
        pago.setId(contractId);
        pago.setAmount(amount);

        boolean result = logica.CearPago(pago);
        if (result) {
            System.out.println("Pago creado exitosamente.");
        } else {
            System.out.println("Error al crear el pago. Verifique el ID del contrato.");
        }

        System.out.println("Ingrese el nombre del inquilino:");
        String tenantName = scanner.next();
        System.out.println("Ingrese el tipo de propiedad (e.g., HOUSE, APARTMENT):");
        String propertyTypeInput = scanner.next();
        org.ejercicio.Enums.poerty_types propertyType = org.ejercicio.Enums.poerty_types.valueOf(propertyTypeInput.toUpperCase());
        System.out.println("Ingrese el monto mínimo del alquiler mensual:");
        BigDecimal minMonthlyRent = scanner.nextBigDecimal();
        System.out.println("Ingrese el monto máximo del alquiler mensual:");
        BigDecimal maxMonthlyRent = scanner.nextBigDecimal();
        System.out.println("Ingrese la fecha de inicio (YYYY-MM-DD):");
        String startDateInput = scanner.next();
        System.out.println("Ingrese la fecha de fin (YYYY-MM-DD):");
        String endDateInput = scanner.next();
        Filtro filtro = new Filtro(
            tenantName,
            propertyType,
            org.ejercicio.utils.LocalDateTimeUtils.crearLocalDateTimeDesdeFecha(startDateInput),
            org.ejercicio.utils.LocalDateTimeUtils.crearLocalDateTimeDesdeFecha(endDateInput),
            minMonthlyRent,
            maxMonthlyRent
        );
        List<org.ejercicio.models.rental_contract> contracts = logica.getContracts(filtro);
        for (rental_contract contract : contracts) {
            System.out.println("Contrato ID: " + contract.getId());
            System.out.println("Inquilino: " + contract.getTenantName());
            System.out.println("Tipo de propiedad: " + contract.getPorpertyType());
            System.out.println("Alquiler mensual: " + contract.getMonthlyRent());
            System.out.println("Fecha de inicio: " + contract.getStartDate());
            System.out.println("Fecha de fin: " + contract.getEndDate());
            System.out.println("Estado: " + contract.getStatus());
            System.out.println("-----------------------------");
        }
    }
}