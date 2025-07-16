package org.ejercicio.dto;
import org.ejercicio.Enums.property_types;

import java.math.BigDecimal;

public class ResultadoFecha {
    private property_types propertyType;
    private BigDecimal totalRent;

    public ResultadoFecha(property_types propertyType, BigDecimal totalRent){
        this.propertyType = propertyType;
        this.totalRent = totalRent;
    }
    public ResultadoFecha(){};

    public property_types getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(property_types propertyType) {
        this.propertyType = propertyType;
    }

    public BigDecimal getTotalRent() {
        return totalRent;
    }

    public void setTotalRent(BigDecimal totalRent) {
        this.totalRent = totalRent;
    }
}
