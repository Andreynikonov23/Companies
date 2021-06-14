package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.Client;
import ru.sapteh.models.Consignee;

import java.util.List;

public class ConsigneeServ implements DAO<Consignee, Integer> {
    private final SessionFactory factory;

    public ConsigneeServ(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Consignee consignee) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(consignee);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Consignee consignee) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(consignee);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Consignee consignee) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(consignee);
            session.getTransaction().commit();
        }
    }

    @Override
    public Consignee read(Integer id) {
        try(Session session = factory.openSession()) {
            return session.get(Consignee.class, id);
        }
    }

    @Override
    public List<Consignee> findByAll() {
        try(Session session = factory.openSession()) {
            Query<Consignee> query = session.createQuery("FROM Consignee");
            return query.list();
        }
    }
}
