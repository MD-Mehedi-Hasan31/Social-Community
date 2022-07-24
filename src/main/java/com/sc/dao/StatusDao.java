package com.sc.dao;

import com.sc.entity.Status;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StatusDao {

    private SessionFactory sessionFactory;

    public Long insert(Status status) {
        Long id = -1L;
        Session session = sessionFactory.getCurrentSession();

        try {
            id = (Long) session.save(status);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.flush();

        return id;
    }

    public Status getById(Long id) {
        return sessionFactory.getCurrentSession().get(Status.class, id);
    }

    public Long update(Status status) {
        Long id = -1L;
        Session session = sessionFactory.getCurrentSession();

        try {
            session.saveOrUpdate(status);
            id = status.getId();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.flush();

        return id;
    }

    public Long delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Status status = session.load(Status.class, id.toString());

        session.delete(status);
        session.flush();

        return id;
    }

    public List<Status> getAll(){
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Status", Status.class);
        List<Status> statusList = query.list();

        return statusList;
    }

}
