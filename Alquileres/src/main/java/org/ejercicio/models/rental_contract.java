package org.ejercicio.models;
import jakarta.persistence.*;
import org.ejercicio.Enums.contract_status;
import org.ejercicio.Enums.poerty_types;
import java.time.temporal.ChronoUnit;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "rental_contract")
public class rental_contract {
    public BigDecimal getTotalRent;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private long id;

    @Column(name = "tenant_name",  length = 80)
    private String tenantName;

    @Column(name = "porperty_type")
    @Enumerated(EnumType.STRING)
    private org.ejercicio.Enums.poerty_types porpertyType;

    @Column(name = "monthly_rent", precision= 12, scale = 2)
    private BigDecimal monthlyRent;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private org.ejercicio.Enums.contract_status status;

    public long getId() {
        return id;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public poerty_types getPorpertyType() {
        return porpertyType;
    }

    public void setPorpertyType(poerty_types porpertyType) {
        this.porpertyType = porpertyType;
    }

    public BigDecimal getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(BigDecimal monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public contract_status getStatus() {
        return status;
    }

    public void setStatus(contract_status status) {
        this.status = status;
    }

    public BigDecimal getTotalRent() {
        return new BigDecimal(ChronoUnit.MONTHS.between(startDate, endDate) * monthlyRent.intValue());
    }
}
