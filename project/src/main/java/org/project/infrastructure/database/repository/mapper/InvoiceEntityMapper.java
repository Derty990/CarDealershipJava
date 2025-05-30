package org.project.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.project.domain.Invoice;
import org.project.infrastructure.database.entity.InvoiceEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InvoiceEntityMapper {

    InvoiceEntity mapToEntity(Invoice entity);

}
