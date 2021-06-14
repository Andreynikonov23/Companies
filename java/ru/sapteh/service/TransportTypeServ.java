package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.Transport;
import ru.sapteh.models.TransportType;

import java.util.List;

public class TransportTypeServ implements DAO<TransportType, Integer> {
    private final SessionFactory factory;

    public TransportTypeServ(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(TransportType transportType) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(transportType);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(TransportType transportType) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(transportType);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(TransportType transportType) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(transportType);
            session.getTransaction().commit();
        }
    }

    @Override
    public TransportType read(Integer id) {
        try(Session session = factory.openSession()) {
            return session.get(TransportType.class, id);
        }
    }

    @Override
    public List<TransportType> findByAll() {
        try (Session session = factory.openSession()) {
            Query<TransportType> query = session.createQuery("FROM TransportType");
            return query.list();
        }
    }
}
