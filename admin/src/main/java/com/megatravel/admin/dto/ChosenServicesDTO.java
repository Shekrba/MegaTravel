package com.megatravel.admin.dto;

import java.util.List;

public class ChosenServicesDTO {

    private List<Long> services;

    public ChosenServicesDTO(){}

    public List<Long> getServices() {
        return services;
    }

    public void setServices(List<Long> services) {
        this.services = services;
    }
}
