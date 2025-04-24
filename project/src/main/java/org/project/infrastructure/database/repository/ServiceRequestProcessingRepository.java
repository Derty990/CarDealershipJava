package org.project.infrastructure.database.repository;

import org.hibernate.Session;
import org.project.business.dao.ServiceRequestProcessingDAO;
import org.project.infrastructure.configuration.HibernateUtil;
import org.project.infrastructure.database.entity.CarServiceRequestEntity;
import org.project.infrastructure.database.entity.PartEntity;
import org.project.infrastructure.database.entity.ServiceMechanicEntity;
import org.project.infrastructure.database.entity.ServicePartEntity;

import java.util.Objects;


public class ServiceRequestProcessingRepository implements ServiceRequestProcessingDAO {



    @Override
    public void process(
            CarServiceRequestEntity serviceRequest,
            ServiceMechanicEntity serviceMechanicEntity
    ) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            session.persist(serviceMechanicEntity);
            if(Objects.nonNull(serviceRequest.getCompletedDateTime())){
                session.merge(serviceRequest);
            }
            session.getTransaction().commit();
        }
    }

    @Override
    public void process(
            CarServiceRequestEntity serviceRequest,
            ServiceMechanicEntity serviceMechanicEntity,
            ServicePartEntity servicePartEntity
    ) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            session.persist(serviceMechanicEntity);

//            Integer partId = servicePartEntity.getPart().getPartId();
//            PartEntity partEntity = session.find(PartEntity.class, partId);
//            servicePartEntity.setPart(partEntity);
            session.persist(servicePartEntity);

            if(Objects.nonNull(serviceRequest.getCompletedDateTime())){
                session.merge(serviceRequest);
            }

            session.getTransaction().commit();
        }
    }
}
