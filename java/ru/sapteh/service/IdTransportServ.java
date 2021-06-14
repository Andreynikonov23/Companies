package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.IdTransport;

import java.util.List;

public class IdTransportServ implements DAO<IdTransport, Integer> {
    private final SessionFactory factory;

    public IdTransportServ(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(IdTransport idTransport) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(idTransport);
            session.getTransaction();
        }
    }

    @Override
    public void update(IdTransport idTransport) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(idTransport);
            session.getTransaction();
        }
    }

    @Override
    public void delete(IdTransport idTransport) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(idTransport);
            session.getTransaction();
        }
    }

    @Override
    public IdTransport read(Integer id) {
        try(Session session = factory.openSession()){
            return session.get(IdTransport.class, id);
        }
    }

    @Override
    public List<IdTransport> findByAll() {
        try (Session session = factory.openSession()) {
            Query<IdTransport> query = session.createQuery("FROM IdTransport");
            return query.list();
        }
    }
}
