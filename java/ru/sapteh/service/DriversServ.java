package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.Client;
import ru.sapteh.models.Drivers;

import java.util.List;

public class DriversServ implements DAO<Drivers, Integer> {
    private final SessionFactory factory;

    public DriversServ(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Drivers drivers) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(drivers);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Drivers drivers) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(drivers);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Drivers drivers) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(drivers);
            session.getTransaction().commit();
        }
    }

    @Override
    public Drivers read(Integer id) {
        try(Session session = factory.openSession()) {
            return session.get(Drivers.class, id);
        }
    }

    @Override
    public List<Drivers> findByAll() {
        try(Session session = factory.openSession()) {
            Query<Drivers> query = session.createQuery("FROM Drivers");
            return query.list();
        }
    }
}
