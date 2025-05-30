package org.project.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.project.domain.ServiceMechanic;
import org.project.infrastructure.database.entity.ServiceMechanicEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServiceMechanicEntityMapper {

    ServiceMechanicEntity mapToEntity(ServiceMechanic serviceMechanic);

}
