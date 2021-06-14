package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.Cargo;
import ru.sapteh.models.CargoType;

import java.util.List;

public class CargoTypeServ implements DAO<CargoType, Integer> {
    private final SessionFactory factory;

    public CargoTypeServ(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(CargoType cargoType) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(cargoType);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(CargoType cargoType) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(cargoType);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(CargoType cargoType) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(cargoType);
            session.getTransaction().commit();
        }
    }

    @Override
    public CargoType read(Integer id) {
        try(Session session = factory.openSession()) {
            return session.get(CargoType.class, id);
        }
    }

    @Override
    public List<CargoType> findByAll() {
        try(Session session = factory.openSession()) {
            Query<CargoType> query = session.createQuery("FROM CargoType");
            return query.list();
        }
    }
}
