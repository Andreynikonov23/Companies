package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.Trailer;
import ru.sapteh.models.TrailerType;

import java.util.List;

public class TrailerTypeServ implements DAO<TrailerType, Integer> {
    private final SessionFactory factory;

    public TrailerTypeServ(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(TrailerType trailerType) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(trailerType);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(TrailerType trailerType) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(trailerType);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(TrailerType trailerType) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(trailerType);
            session.getTransaction().commit();
        }
    }

    @Override
    public TrailerType read(Integer id) {
        try(Session session = factory.openSession()) {
            return session.get(TrailerType.class, id);
        }
    }

    @Override
    public List<TrailerType> findByAll() {
        try (Session session = factory.openSession()) {
            Query<TrailerType> query = session.createQuery("FROM TrailerType");
            return query.list();
        }
    }
}
