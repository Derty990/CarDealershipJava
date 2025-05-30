package org.project.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.project.business.dao.ServiceRequestProcessingDAO;
import org.project.domain.CarServiceRequest;
import org.project.domain.ServiceMechanic;
import org.project.domain.ServicePart;
import org.project.infrastructure.database.entity.CarServiceRequestEntity;
import org.project.infrastructure.database.entity.PartEntity;
import org.project.infrastructure.database.entity.ServiceMechanicEntity;
import org.project.infrastructure.database.entity.ServicePartEntity;
import org.project.infrastructure.database.repository.jpa.CarServiceRequestJpaRepository;
import org.project.infrastructure.database.repository.jpa.PartJpaRepository;
import org.project.infrastructure.database.repository.jpa.ServiceMechanicJpaRepository;
import org.project.infrastructure.database.repository.jpa.ServicePartJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
@AllArgsConstructor
public class ServiceRequestProcessingRepository implements ServiceRequestProcessingDAO {

    private final ServiceMechanicJpaRepository serviceMechanicJpaRepository;
    private final CarServiceRequestJpaRepository carServiceRequestJpaRepository;
    private final PartJpaRepository partJpaRepository;
    private final ServicePartJpaRepository servicePartJpaRepository;
    private final ServiceMechanicEntityMapper serviceMechanicEntityMapper;
    private final ServicePartEntityMapper servicePartEntityMapper;

    @Override
    public void process(
            CarServiceRequest serviceRequest,
            ServiceMechanic serviceMechanic
    ) {
        ServiceMechanicEntity serviceMechanicEntity = serviceMechanicEntityMapper.mapToEntity(serviceMechanic);
        serviceMechanicJpaRepository.saveAndFlush(serviceMechanicEntity);
        if (Objects.nonNull(serviceRequest.getCompletedDateTime())) {
            CarServiceRequestEntity carServiceRequestEntity = carServiceRequestJpaRepository
                    .findById(serviceRequest.getCarServiceRequestId())
                    .orElseThrow();
            carServiceRequestEntity.setCompletedDateTime(serviceRequest.getCompletedDateTime());
            carServiceRequestJpaRepository.saveAndFlush(carServiceRequestEntity);
        }
    }

    @Override
    public void process(
            CarServiceRequest serviceRequest,
            ServiceMechanic serviceMechanic,
            ServicePart servicePart
    ) {
        PartEntity partEntity = partJpaRepository.findById(servicePart.getPart().getPartId()).orElseThrow();
        ServicePartEntity servicePartEntity = servicePartEntityMapper.mapToEntity(servicePart);
        servicePartEntity.setPart(partEntity);
        servicePartJpaRepository.saveAndFlush(servicePartEntity);
        process(serviceRequest, serviceMechanic);

    }
}
