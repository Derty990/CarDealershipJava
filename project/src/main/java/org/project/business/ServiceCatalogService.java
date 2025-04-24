package org.project.business;

import lombok.AllArgsConstructor;
import org.project.business.dao.ServiceDAO;
import org.project.infrastructure.database.entity.ServiceEntity;

import java.util.Optional;

@AllArgsConstructor
public class ServiceCatalogService {
    private final ServiceDAO serviceDAO;

    public ServiceEntity findService(String serviceCode) {

        Optional<ServiceEntity> service = serviceDAO.findByServiceCode(serviceCode);
        if (service.isEmpty()) {
            throw new RuntimeException("Could not find service by service code: [%s]".formatted(serviceCode));
        }
        return service.get();

    }
}
