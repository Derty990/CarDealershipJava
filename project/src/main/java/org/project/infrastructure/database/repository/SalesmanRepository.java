package org.project.infrastructure.database.repository;

import org.hibernate.Session;
import org.project.business.dao.SalesmanDAO;
import org.project.infrastructure.configuration.HibernateUtil;
import org.project.infrastructure.database.entity.SalesmanEntity;

import java.util.Objects;
import java.util.Optional;

public class SalesmanRepository implements SalesmanDAO {


    @Override
    public Optional<SalesmanEntity> findByPesel(String pesel) {

        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            String query = "SELECT se FROM SalesmanEntity se WHERE se.pesel = :pesel";
            Optional<SalesmanEntity> result = session.createQuery(query, SalesmanEntity.class)
                    .setParameter("pesel", pesel)
                    .uniqueResultOptional();

            session.getTransaction().commit();
            return result;


        }

    }
}
