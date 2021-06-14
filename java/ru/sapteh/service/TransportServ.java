package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.Trailer;
import ru.sapteh.models.Transport;

import java.util.List;

public class TransportServ implements DAO<Transport, Integer> {
    private final SessionFactory factory;

    public TransportServ(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Transport transport) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(transport);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Transport transport) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(transport);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Transport transport) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(transport);
            session.getTransaction().commit();
        }
    }

    @Override
    public Transport read(Integer id) {
        try(Session session = factory.openSession()) {
            return session.get(Transport.class, id);
        }
    }

    @Override
    public List<Transport> findByAll() {
        try (Session session = factory.openSession()) {
            Query<Transport> query = session.createQuery("FROM Transport");
            return query.list();
        }
    }
}
