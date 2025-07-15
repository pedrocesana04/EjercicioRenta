package org.ejercicio.dto;


import org.ejercicio.Enums.property_types;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Filtro {
    private String name;
    private property_types propertyType;
    private LocalDateTime minDate;
    private LocalDateTime maxDate;
    private BigDecimal minAmount;
    private BigDecimal maxAmount;

    public Filtro(String name, property_types propertyType, LocalDateTime mintDate, LocalDateTime maxtDate, BigDecimal minAmount, BigDecimal maxAmount) {
        this.name = name;
        this.propertyType = propertyType;
        this.minDate = mintDate;
        this.maxDate = maxtDate;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
    }
    public Filtro(){};
    public String getNname() {
        return name;
    }

    public void setName(String nname) {
        this.name = nname;
    }

    public property_types getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(property_types propertyType) {
        this.propertyType = propertyType;
    }

    public LocalDateTime getMinDate() {
        return minDate;
    }

    public void setMinDate(LocalDateTime mintDate) {
        this.minDate = mintDate;
    }

    public LocalDateTime getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(LocalDateTime maxtDate) {
        this.maxDate = maxtDate;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }
}
