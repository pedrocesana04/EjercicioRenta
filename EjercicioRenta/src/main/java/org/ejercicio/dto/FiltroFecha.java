package org.ejercicio.dto;

import java.time.LocalDateTime;

public class FiltroFecha {
    private LocalDateTime minDate;
    private LocalDateTime maxDate;

    public FiltroFecha(){};
    public FiltroFecha (LocalDateTime minDate, LocalDateTime maxDate){
        this.minDate = minDate;
        this.maxDate = maxDate;
    }
    public LocalDateTime getMinDate() {
        return minDate;
    }

    public void setMinDate(LocalDateTime minDate) {
        this.minDate = minDate;
    }

    public LocalDateTime getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(LocalDateTime maxDate) {
        this.maxDate = maxDate;
    }
}
