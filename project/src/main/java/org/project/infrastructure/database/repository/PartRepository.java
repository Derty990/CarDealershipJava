package org.project.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.project.business.dao.PartDAO;
import org.project.domain.Part;
import org.project.infrastructure.database.repository.jpa.PartJpaRepository;
import org.project.infrastructure.database.repository.mapper.PartEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class PartRepository implements PartDAO {


    private final PartJpaRepository partJpaRepository;
    private final PartEntityMapper partEntityMapper;


    @Override
    public Optional<Part> findBySerialNumber(String serialNumber) {
        return partJpaRepository.findBySerialNumber(serialNumber)
                .map(partEntityMapper::mapFromEntity);
    }
}
