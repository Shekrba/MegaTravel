package com.megatravel.agentback.dto;

import java.time.LocalDate;

public class ZauzetostDTO {

    private LocalDate odDatum;
    private LocalDate doDatum;

    public ZauzetostDTO() {}


    public LocalDate getOdDatum() {
        return odDatum;
    }

    public void setOdDatum(LocalDate odDatum) {
        this.odDatum = odDatum;
    }

    public LocalDate getDoDatum() {
        return doDatum;
    }

    public void setDoDatum(LocalDate doDatum) {
        this.doDatum = doDatum;
    }
}
