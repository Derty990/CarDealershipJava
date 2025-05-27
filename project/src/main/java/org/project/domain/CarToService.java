package org.project.domain;


import lombok.*;

import java.util.Set;

@With
@Value
@Builder
@EqualsAndHashCode(of = "carToServiceId")
@ToString(of = {"carToServiceId", "vin", "brand", "model", "year"})
public class CarToService {

    Integer carToServiceId;
    String vin;
    String brand;
    String model;
    Integer year;
    Set<CarServiceRequest> carServiceRequests;

}
