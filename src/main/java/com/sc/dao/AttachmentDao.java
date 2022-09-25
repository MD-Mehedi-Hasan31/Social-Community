package com.sc.dao;


import com.sc.entity.Attachment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AttachmentDao {

    @Autowired
    private SessionFactory sessionFactory;
    public Long insert(Attachment attachment) {
        Long id = -1L;
        Session session = sessionFactory.getCurrentSession();

        try {
            id = (Long) session.save(attachment);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
       // session.flush();

        return id;
    }

    public void insertBulk(List<Attachment> attachments) {
        Session session = sessionFactory.getCurrentSession();
        try {
            attachments.forEach(session::save);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.flush();
    }

    public Attachment findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            String hql = "FROM Attachment a where a.id=:id";
            Query<Attachment> attachmentQuery = session.createQuery(hql);
            attachmentQuery.setParameter("id", id);
            return attachmentQuery.getSingleResult();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return null;
    }

}
