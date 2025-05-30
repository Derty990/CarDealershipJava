package org.project.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.project.domain.ServicePart;
import org.project.infrastructure.database.entity.ServicePartEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServicePartEntityMapper {

    ServicePartEntity mapToEntity(ServicePart servicePart);

}
