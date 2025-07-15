package org.ejercicio;

import org.ejercicio.Enums.property_types;
import org.ejercicio.dto.CrearPago;
import org.ejercicio.dto.Filtro;
import org.ejercicio.models.rental_contract;
import org.ejercicio.service.Logica;

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
        scanner.nextLine();

        CrearPago pago = new CrearPago();
        pago.setId(contractId);
        pago.setAmount(amount);

        boolean result = logica.crearPago(pago);
        if (result) {
            System.out.println("Pago creado exitosamente.");
        } else {
            System.out.println("Error al crear el pago. Verifique el ID del contrato.");
        }
        Filtro filtro = new Filtro();

        System.out.println("Ingrese el nombre del inquilino:");
        String tenantName = scanner.nextLine();
        filtro.setName(tenantName);

        System.out.println("Ingrese el tipo de propiedad (e.g., HOUSE, APARTMENT):");
        String propertyTypeInput = scanner.nextLine();
        if(!propertyTypeInput.isEmpty()) {
            property_types propertyType = property_types.valueOf(propertyTypeInput.toUpperCase());
            filtro.setPropertyType(propertyType);
        }

        System.out.println("Ingrese el monto mínimo del alquiler mensual:");
        String minMonthlyRentInput = scanner.nextLine();

        if (!minMonthlyRentInput.isEmpty()) {
            BigDecimal minMonthlyRent = new BigDecimal(minMonthlyRentInput);
            filtro.setMinAmount(minMonthlyRent);
        }


        System.out.println("Ingrese el monto máximo del alquiler mensual:");
        String maxMonthlyRentInput = scanner.nextLine();

        if (!maxMonthlyRentInput.isEmpty()) {
            BigDecimal maxMonthlyRent = new BigDecimal(maxMonthlyRentInput);
            filtro.setMinAmount(maxMonthlyRent);
        }

        System.out.println("Ingrese la fecha de inicio (YYYY-MM-DD):");
        String startDateInput = scanner.nextLine();
        if(!startDateInput.isEmpty()) {
            filtro.setMinDate(org.ejercicio.utils.LocalDateTimeUtils.crearLocalDateTimeDesdeFecha(startDateInput));
        }

        System.out.println("Ingrese la fecha de fin (YYYY-MM-DD):");
        String endDateInput = scanner.nextLine();
        if(!endDateInput.isEmpty()) {
            filtro.setMaxDate(org.ejercicio.utils.LocalDateTimeUtils.crearLocalDateTimeDesdeFecha(endDateInput));
        }

        List<rental_contract> contracts = logica.getContracts(filtro);
        for (rental_contract contract : contracts) {
            System.out.println("Contrato ID: " + contract.getId());
            System.out.println("Inquilino: " + contract.getTenantName());
            System.out.println("Tipo de propiedad: " + contract.getPropertyType());
            System.out.println("Alquiler mensual: " + contract.getMonthlyRent());
            System.out.println("Fecha de inicio: " + contract.getStartDate());
            System.out.println("Fecha de fin: " + contract.getEndDate());
            System.out.println("Estado: " + contract.getStatus());
            System.out.println("-----------------------------");
        }
    }
}