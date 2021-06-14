package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.Waybill;

import java.util.List;

public class WaybillServ implements DAO<Waybill, Integer> {
    private final SessionFactory factory;

    public WaybillServ(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Waybill waybill) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(waybill);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Waybill waybill) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(waybill);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Waybill waybill) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(waybill);
            session.getTransaction().commit();
        }
    }

    @Override
    public Waybill read(Integer id) {
        try(Session session = factory.openSession()) {
            return session.get(Waybill.class, id);
        }
    }

    @Override
    public List<Waybill> findByAll() {
        try (Session session = factory.openSession()) {
            Query<Waybill> query = session.createQuery("FROM Waybill");
            return query.list();
        }
    }
}
