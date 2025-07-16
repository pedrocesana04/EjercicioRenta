package org.ejercicio.dto;

import java.math.BigDecimal;

public class ResultadoNoCompletados {
    private long id;
    private BigDecimal totalRent;
    private BigDecimal rentPaid;

    public ResultadoNoCompletados (){};
    public ResultadoNoCompletados (long id, BigDecimal totalRent, BigDecimal rentPaid){
        this.id = id;
        this.totalRent = totalRent;
        this.rentPaid = rentPaid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getTotalRent() {
        return totalRent;
    }

    public void setTotalRent(BigDecimal totalRent) {
        this.totalRent = totalRent;
    }

    public BigDecimal getRentPaid() {
        return rentPaid;
    }

    public void setRentPaid(BigDecimal rentPaid) {
        this.rentPaid = rentPaid;
    }
}
