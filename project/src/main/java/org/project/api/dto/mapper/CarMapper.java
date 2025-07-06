package org.project.api.dto.mapper;

import org.mapstruct.Mapper;
import org.project.api.dto.CarToBuyDTO;
import org.project.business.dao.CarToBuyDAO;
import org.project.domain.CarToBuy;

@Mapper(componentModel = "spring")
public interface CarMapper {

    CarToBuyDTO map(final CarToBuy car);
}
