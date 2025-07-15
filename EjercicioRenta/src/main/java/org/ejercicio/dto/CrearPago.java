package org.ejercicio.dto;

import java.math.BigDecimal;

public class CrearPago {
    private long Id;
    private BigDecimal Amount;

    public BigDecimal getAmount() {
        return Amount;
    }

    public void setAmount(BigDecimal amount) {
        Amount = amount;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }
}
