package org.project.business.dao;

import org.project.infrastructure.database.entity.CarServiceRequestEntity;
import org.project.infrastructure.database.entity.ServiceMechanicEntity;
import org.project.infrastructure.database.entity.ServicePartEntity;

public interface ServiceRequestProcessingDAO {
    void process(CarServiceRequestEntity serviceRequest, ServiceMechanicEntity serviceMechanicEntity);

    void process(CarServiceRequestEntity serviceRequest, ServiceMechanicEntity serviceMechanicEntity, ServicePartEntity servicePartEntity);
}
