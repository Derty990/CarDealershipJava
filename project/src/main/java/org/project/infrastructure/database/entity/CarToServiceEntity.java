package org.project.infrastructure.database.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "carToServiceId")
@ToString(of = {"carToServiceId", "vin", "brand", "model", "year"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "car_to_service")
public class CarToServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_to_service_id")
    private Integer carToServiceId;

    @Column(name = "vin", unique = true)
    private String vin;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private Integer year;

    @Column(name = "color")
    private String color;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
    private Set<CarServiceRequestEntity> carServiceRequests;

}
