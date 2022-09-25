package com.sc.dao;


import com.sc.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.internal.expression.ListIndexExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Component
public class UserDao {
    @Autowired
   private SessionFactory sessionFactory;

   public Long save(User user){
       Long id = -1L;
       Session session = sessionFactory.getCurrentSession();

       try {
           id = (Long) session.save(user);
       } catch (Exception e) {
           e.printStackTrace();
           session.getTransaction().rollback();
       }
       // session.flush();

       return id;
   }

   public List<User> findAll(){
       Session session = sessionFactory.getCurrentSession();
       String hql ="FROM User";
       Query<User> query= session.createQuery(hql);
       List<User> userList = query.list();

       return userList;
   }
}
