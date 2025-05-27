package org.project.domain;

import lombok.*;

@With
@Builder
@Value
@EqualsAndHashCode(of = "addressId")
@ToString(of = {"addressId", "country", "city", "postalCode", "address"})
public class Address {

    Integer addressId;
    String country;
    String city;
    String postalCode;
    String address;
    Customer customer;

}
