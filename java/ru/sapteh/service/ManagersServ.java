package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.Managers;

import java.util.List;

public class ManagersServ implements DAO<Managers, Integer> {
    private final SessionFactory factory;

    public ManagersServ(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Managers managers) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(managers);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Managers managers) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(managers);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Managers managers) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(managers);
            session.getTransaction().commit();
        }
    }

    @Override
    public Managers read(Integer id) {
        try(Session session = factory.openSession()) {
            return session.get(Managers.class, id);
        }
    }

    @Override
    public List<Managers> findByAll() {
        try (Session session = factory.openSession()) {
            Query<Managers> query = session.createQuery("FROM Managers");
            return query.list();
        }
    }
}
