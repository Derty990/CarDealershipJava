package org.project.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.project.business.dao.MechanicDAO;
import org.project.domain.Mechanic;
import org.project.infrastructure.database.repository.jpa.MechanicJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class MechanicRepository implements MechanicDAO {

    private final MechanicJpaRepository mechanicJpaRepository;
    private final MechanicMapper mechanicMapper;

    @Override
    public Optional<Mechanic> findByPesel(String pesel) {
        return mechanicJpaRepository.findByPesel(pesel)
                .map(mechanicMapper::mapFromEntity);

    }
}
