package org.project.business;

import lombok.AllArgsConstructor;
import org.project.business.dao.ServiceDAO;
import org.project.domain.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@AllArgsConstructor
public class ServiceCatalogService {
    private final ServiceDAO serviceDAO;

    @Transactional
    public Service findService(String serviceCode) {

        Optional<Service> service = serviceDAO.findByServiceCode(serviceCode);
        if (service.isEmpty()) {
            throw new RuntimeException("Could not find service by service code: [%s]".formatted(serviceCode));
        }
        return service.get();

    }
}
