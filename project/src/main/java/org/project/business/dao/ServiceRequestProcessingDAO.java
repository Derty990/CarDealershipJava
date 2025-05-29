package org.project.business.dao;

import org.project.domain.CarServiceRequest;
import org.project.domain.ServiceMechanic;
import org.project.domain.ServicePart;

public interface ServiceRequestProcessingDAO {
    void process(CarServiceRequest serviceRequest, ServiceMechanic serviceMechanic);

    void process(CarServiceRequest serviceRequest, ServiceMechanic serviceMechanic, ServicePart servicePart);
}
