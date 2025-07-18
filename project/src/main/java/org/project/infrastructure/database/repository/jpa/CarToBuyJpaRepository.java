package org.project.infrastructure.database.repository.jpa;

import org.project.infrastructure.database.entity.CarToBuyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarToBuyJpaRepository extends JpaRepository<CarToBuyEntity, Integer> {

    @Query("""
    SELECT CAR FROM CarToBuyEntity car
        WHERE car.carToBuyId NOT IN (SELECT invoice.car.carToBuyId FROM InvoiceEntity invoice)
    """)

    @Query("""
    SELECT car FROM CarToBuyEntity car
    LEFT JOIN FETCH car.invoice invoice
    WHERE invoice.car.carToBuyId IS NULL
""")
    List<CarToBuyEntity> findAvailableCars();

    Optional<CarToBuyEntity> findByVin(String vin);
}
