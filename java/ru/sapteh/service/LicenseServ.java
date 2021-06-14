package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.License;
import ru.sapteh.models.Waybill;

import java.util.List;

public class LicenseServ implements DAO<License, Integer> {
    private final SessionFactory factory;

    public LicenseServ(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(License license) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(license);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(License license) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(license);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(License license) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(license);
            session.getTransaction().commit();
        }
    }

    @Override
    public License read(Integer id) {
        try(Session session = factory.openSession()) {
            return session.get(License.class, id);
        }
    }

    @Override
    public List<License> findByAll() {
        try (Session session = factory.openSession()) {
            Query<License> query = session.createQuery("FROM License");
            return query.list();
        }
    }
}
