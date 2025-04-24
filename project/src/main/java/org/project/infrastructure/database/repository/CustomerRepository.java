package org.project.infrastructure.database.repository;

import org.hibernate.Session;
import org.project.business.dao.CustomerDAO;
import org.project.infrastructure.configuration.HibernateUtil;
import org.project.infrastructure.database.entity.CustomerEntity;

import java.util.Objects;
import java.util.Optional;

public class CustomerRepository implements CustomerDAO {

    @Override
    public Optional<CustomerEntity> findByEmail(String email) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            String query = "SELECT ce FROM CustomerEntity ce WHERE ce.email = :email";
            Optional<CustomerEntity> result = session.createQuery(query, CustomerEntity.class)
                    .setParameter("email", email)
                    .uniqueResultOptional();

            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public void issueInvoice(CustomerEntity customer) {

        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            if (Objects.isNull(customer.getCustomerId())) {
                session.persist(customer);
            }

            customer.getInvoices().stream()
                    .filter(invoice -> Objects.isNull(invoice.getInvoiceId()))
                    .forEach(invoice -> {
                        invoice.setCustomer(customer);
                        session.persist(invoice);
                    });

            session.getTransaction().commit();

        }
    }

    @Override
    public void saveServiceRequest(CustomerEntity customer) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            customer.getCarServiceRequests().stream()
                    .filter(request -> Objects.isNull(request.getCarServiceRequestId()))
                    .forEach(session::persist);
            session.getTransaction().commit();

        }
    }

    @Override
    public CustomerEntity saveCustomer(CustomerEntity entity) {

        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            session.persist(entity);
            session.getTransaction().commit();
            return entity;
        }
    }
}
