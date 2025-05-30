package org.ejercicio.dto;


import org.ejercicio.Enums.poerty_types;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Filtro {
    private String name;
    private org.ejercicio.Enums.poerty_types propertyType;
    private LocalDateTime mintDate;
    private LocalDateTime maxtDate;
    private BigDecimal minAmount;
    private BigDecimal maxAmount;

    public Filtro(String name, poerty_types propertyType, LocalDateTime mintDate, LocalDateTime maxtDate, BigDecimal minAmount, BigDecimal maxAmount) {
        this.name = name;
        this.propertyType = propertyType;
        this.mintDate = mintDate;
        this.maxtDate = maxtDate;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
    }
    public String getNname() {
        return name;
    }

    public void setNname(String nname) {
        this.name = nname;
    }

    public poerty_types getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(poerty_types propertyType) {
        this.propertyType = propertyType;
    }

    public LocalDateTime getMintDate() {
        return mintDate;
    }

    public void setMintDate(LocalDateTime mintDate) {
        this.mintDate = mintDate;
    }

    public LocalDateTime getMaxtDate() {
        return maxtDate;
    }

    public void setMaxtDate(LocalDateTime maxtDate) {
        this.maxtDate = maxtDate;
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
