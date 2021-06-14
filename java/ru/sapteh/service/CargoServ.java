package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.Cargo;

import java.util.List;

public class CargoServ implements DAO<Cargo, Integer> {
    private final SessionFactory factory;

    public CargoServ(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Cargo cargo) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(cargo);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Cargo cargo) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(cargo);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Cargo cargo) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(cargo);
            session.getTransaction().commit();
        }
    }

    @Override
    public Cargo read(Integer id) {
        try(Session session = factory.openSession()) {
            return session.get(Cargo.class, id);
        }
    }

    @Override
    public List<Cargo> findByAll() {
        try(Session session = factory.openSession()) {
            Query<Cargo> query = session.createQuery("FROM Cargo");
            return query.list();
        }
    }
}
