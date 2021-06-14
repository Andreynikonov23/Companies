package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.Orders;
import ru.sapteh.models.Trailer;

import java.util.List;

public class TrailerServ implements DAO<Trailer, Integer> {
    private final SessionFactory factory;

    public TrailerServ(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Trailer trailer) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(trailer);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Trailer trailer) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(trailer);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Trailer trailer) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(trailer);
            session.getTransaction().commit();
        }
    }

    @Override
    public Trailer read(Integer id) {
        try(Session session = factory.openSession()) {
            return session.get(Trailer.class, id);
        }
    }

    @Override
    public List<Trailer> findByAll() {
        try (Session session = factory.openSession()) {
            Query<Trailer> query = session.createQuery("FROM Trailer");
            return query.list();
        }
    }
}
