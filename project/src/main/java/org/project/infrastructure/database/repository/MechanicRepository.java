package org.project.infrastructure.database.repository;

import org.hibernate.Session;
import org.project.business.dao.MechanicDAO;
import org.project.infrastructure.configuration.HibernateUtil;
import org.project.infrastructure.database.entity.MechanicEntity;

import java.util.Objects;
import java.util.Optional;

public class MechanicRepository implements MechanicDAO {


    @Override
    public Optional<MechanicEntity> findByPesel(String pesel) {

        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            String query = "SELECT se FROM MechanicEntity se WHERE se.pesel = :pesel";
            Optional<MechanicEntity> result = session.createQuery(query, MechanicEntity.class)
                    .setParameter("pesel", pesel)
                    .uniqueResultOptional();

            session.getTransaction().commit();
            return result;


        }

    }
}
