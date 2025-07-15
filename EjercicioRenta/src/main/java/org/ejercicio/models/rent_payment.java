package org.ejercicio.models;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "rent_payment")
public class rent_payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private rental_contract contract_id;

    @Column(name = "pay_date")
    private LocalDateTime payDate;

    @Column(name = "amount", precision= 12, scale = 2)
    private BigDecimal amount;

    public long getId() {
        return id;
    }

    public LocalDateTime getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDateTime payDate) {
        this.payDate = payDate;
    }

    public rental_contract getContract_id() {
        return contract_id;
    }

    public void setContract_id(rental_contract contract_id) {
        this.contract_id = contract_id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
