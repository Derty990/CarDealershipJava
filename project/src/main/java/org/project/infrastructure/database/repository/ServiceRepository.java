package org.project.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.project.business.dao.ServiceDAO;
import org.project.domain.Service;
import org.project.infrastructure.database.repository.jpa.ServiceJpaRepository;
import org.project.infrastructure.database.repository.mapper.ServiceEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class ServiceRepository implements ServiceDAO {

    private final ServiceJpaRepository serviceJpaRepository;
    private final ServiceEntityMapper serviceEntityMapper;

    @Override
    public Optional<Service> findByServiceCode(String serviceCode) {
        return serviceJpaRepository.findByServiceCode(serviceCode)
                .map(serviceEntityMapper::mapFromEntity);
    }
}
