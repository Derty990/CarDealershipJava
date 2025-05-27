package org.project.domain;

import lombok.Builder;
import lombok.Value;
import lombok.With;

@With
@Builder
@Value
public class CarPurchaseRequestInputData {

    String customerName;
    String customerSurname;
    String customerPhone;
    String customerEmail;
    String customerAddressCountry;
    String customerAddressCity;
    String customerAddressPostalCode;
    String customerAddressStreet;
    String carVin;
    String salesmanPesel;

}
