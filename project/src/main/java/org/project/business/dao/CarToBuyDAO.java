package org.project.business.dao;

import org.project.domain.CarServiceRequest;

import java.util.Set;

public interface CarToBuyDAO {
    Set<CarServiceRequest> findActiveServiceRequestsByCarVin(String carVin);
}
