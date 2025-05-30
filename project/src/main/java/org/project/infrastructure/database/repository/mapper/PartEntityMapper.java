package org.project.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.project.domain.Part;
import org.project.infrastructure.database.entity.PartEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PartEntityMapper {

    @Mapping(target = "serviceParts", ignore = true)
    Part mapFromEntity(PartEntity entity);

}
