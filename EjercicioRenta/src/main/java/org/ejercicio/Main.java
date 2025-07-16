package org.ejercicio;

import org.ejercicio.Enums.property_types;
import org.ejercicio.dto.CrearPago;
import org.ejercicio.dto.FiltroFecha;
import org.ejercicio.dto.FiltroNombre;
import org.ejercicio.dto.ResultadoFecha;
import org.ejercicio.models.rental_contract;
import org.ejercicio.service.Logica;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static final Logica logica = Logica.getInstance();
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        /*System.out.println("Ingrese el ID del contrato:");
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
        FiltroNombre filtroNombre = new FiltroNombre();

        System.out.println("Ingrese el nombre del inquilino:");
        String tenantName = scanner.nextLine();
        filtroNombre.setName(tenantName);

        System.out.println("Ingrese el tipo de propiedad (e.g., HOUSE, APARTMENT):");
        String propertyTypeInput = scanner.nextLine();
        if(!propertyTypeInput.isEmpty()) {
            property_types propertyType = property_types.valueOf(propertyTypeInput.toUpperCase());
            filtroNombre.setPropertyType(propertyType);
        }

        System.out.println("Ingrese el monto mínimo del alquiler mensual:");
        String minMonthlyRentInput = scanner.nextLine();

        if (!minMonthlyRentInput.isEmpty()) {
            BigDecimal minMonthlyRent = new BigDecimal(minMonthlyRentInput);
            filtroNombre.setMinAmount(minMonthlyRent);
        }


        System.out.println("Ingrese el monto máximo del alquiler mensual:");
        String maxMonthlyRentInput = scanner.nextLine();

        if (!maxMonthlyRentInput.isEmpty()) {
            BigDecimal maxMonthlyRent = new BigDecimal(maxMonthlyRentInput);
            filtroNombre.setMinAmount(maxMonthlyRent);
        }

        System.out.println("Ingrese la fecha de inicio (YYYY-MM-DD):");
        String startDateInput = scanner.nextLine();
        if(!startDateInput.isEmpty()) {
            filtroNombre.setMinDate(org.ejercicio.utils.LocalDateTimeUtils.crearLocalDateTimeDesdeFecha(startDateInput));
        }

        System.out.println("Ingrese la fecha de fin (YYYY-MM-DD):");
        String endDateInput = scanner.nextLine();
        if(!endDateInput.isEmpty()) {
            filtroNombre.setMaxDate(org.ejercicio.utils.LocalDateTimeUtils.crearLocalDateTimeDesdeFecha(endDateInput));
        }

        List<rental_contract> contracts = logica.getContractsName(filtroNombre);
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
        */

        System.out.println("Ingrese la fecha desde la que deseas filtrar (YYYY-MM-DD): ");
        String minDate = scanner.nextLine();
        System.out.println("Ingrese la fecha hasta la que deseas filtrar (YYYY-MM-DD): ");
        String maxDate = scanner.nextLine();

        FiltroFecha filtroFecha = new FiltroFecha(org.ejercicio.utils.LocalDateTimeUtils.crearLocalDateTimeDesdeFecha(minDate), org.ejercicio.utils.LocalDateTimeUtils.crearLocalDateTimeDesdeFecha(maxDate));
        List<ResultadoFecha> resultadosFechas = logica.getContrtactsStartDate(filtroFecha);

        for (ResultadoFecha resultado : resultadosFechas){
            System.out.println("Tipo de propiedad: " + resultado.getPropertyType());
            System.out.println("Alquiler total: " + resultado.getTotalRent());
            System.out.println("-----------------------------");
        }


    }
}