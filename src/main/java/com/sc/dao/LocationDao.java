package com.sc.dao;


import com.sc.entity.Location;
import com.sc.model.LocationModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Component
public class LocationDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(LocationModel locationModel) {

        Session session= sessionFactory.getCurrentSession();
        Location location= new Location();
        location.setLocationName(locationModel.getLocationName());
        try{
            session.save(location);
        }catch (Exception ex){
            session.getTransaction().rollback();
        }

        session.flush();
    }

    public Long update(Location location) {
        Long id = -1L;
        Session session = sessionFactory.getCurrentSession();

        try {
            session.saveOrUpdate(location);
            id = location.getId();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.flush();

        return id;
    }
    public Location findById(Long id) {
        String hql="FROM Location l where l.id=:locationId";
        Query<Location> locationQuery= sessionFactory.getCurrentSession().createQuery(hql);
        locationQuery.setParameter("locationId", id);
        return locationQuery.getSingleResult();
    }

    public Location getByName(String name) {
        Location location = null;
        Session session = sessionFactory.getCurrentSession();

        try {
            Query query = session.createQuery("FROM Location WHERE locationName = :name").
                    setParameter("name", name);
            location = (Location) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.flush();

        return location;
    }
    public List<Location> getAllLocation(){
        String hql="FROM Location l";
        Session session= sessionFactory.getCurrentSession();
        Query<Location> query= session.createQuery(hql);

        return query.list();
    }
}
