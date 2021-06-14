package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.Mechanics;

import java.util.List;

public class MechanicsServ implements DAO<Mechanics, Integer> {
    private final SessionFactory factory;

    public MechanicsServ(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Mechanics mechanics) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(mechanics);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Mechanics mechanics) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(mechanics);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Mechanics mechanics) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(mechanics);
            session.getTransaction().commit();
        }
    }

    @Override
    public Mechanics read(Integer id) {
        try(Session session = factory.openSession()) {
            return session.get(Mechanics.class, id);
        }
    }

    @Override
    public List<Mechanics> findByAll() {
        try (Session session = factory.openSession()) {
            Query<Mechanics> query = session.createQuery("FROM Mechanics");
            return query.list();
        }
    }
}

