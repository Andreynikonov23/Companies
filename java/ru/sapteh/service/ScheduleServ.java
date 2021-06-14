package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.Orders;
import ru.sapteh.models.Schedule;

import java.util.List;

public class ScheduleServ implements DAO<Schedule, Integer> {
    private final SessionFactory factory;

    public ScheduleServ(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Schedule schedule) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(schedule);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Schedule schedule) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(schedule);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Schedule schedule) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(schedule);
            session.getTransaction().commit();
        }
    }

    @Override
    public Schedule read(Integer id) {
        try(Session session = factory.openSession()) {
            return session.get(Schedule.class, id);
        }
    }

    @Override
    public List<Schedule> findByAll() {
        try (Session session = factory.openSession()) {
            Query<Schedule> query = session.createQuery("FROM Schedule");
            return query.list();
        }
    }
}
