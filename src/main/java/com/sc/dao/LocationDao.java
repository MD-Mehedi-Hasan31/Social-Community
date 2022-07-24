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


    public Location findById(Long id) {
        String hql="FROM Location l where l.id=:locationId";
        Query<Location> locationQuery= sessionFactory.getCurrentSession().createQuery(hql);
        locationQuery.setParameter("locationId", id);
        return locationQuery.getSingleResult();
    }

    public List<Location> getLocations(){
        String hql="FROM Location l";
        Session session= sessionFactory.getCurrentSession();
        Query<Location> query= session.createQuery(hql);

        return query.list();
    }
}
