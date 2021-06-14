package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.Mechanics;
import ru.sapteh.models.Orders;

import java.util.List;

public class OrdersServ implements DAO<Orders, Integer> {
    private final SessionFactory factory;

    public OrdersServ(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Orders orders) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(orders);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Orders orders) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(orders);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Orders orders) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(orders);
            session.getTransaction().commit();
        }
    }

    @Override
    public Orders read(Integer id) {
        try(Session session = factory.openSession()) {
            return session.get(Orders.class, id);
        }
    }

    @Override
    public List<Orders> findByAll() {
        try (Session session = factory.openSession()) {
            Query<Orders> query = session.createQuery("FROM Orders");
            return query.list();
        }
    }
}
