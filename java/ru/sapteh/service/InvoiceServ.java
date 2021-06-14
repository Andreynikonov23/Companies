package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.Drivers;
import ru.sapteh.models.Invoice;

import java.util.List;

public class InvoiceServ implements DAO<Invoice, Integer> {
    private final SessionFactory factory;

    public InvoiceServ(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Invoice invoice) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(invoice);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Invoice invoice) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(invoice);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Invoice invoice) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(invoice);
            session.getTransaction().commit();
        }
    }

    @Override
    public Invoice read(Integer id) {
        try(Session session = factory.openSession()) {
            return session.get(Invoice.class, id);
        }
    }

    @Override
    public List<Invoice> findByAll() {
        try(Session session = factory.openSession()) {
            Query<Invoice> query = session.createQuery("FROM Invoice");
            return query.list();
        }
    }
}
