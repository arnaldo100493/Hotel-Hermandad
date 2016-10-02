/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel.services;

import com.hotel.dao.ImplDao;
import com.hotel.entity.Habitacion;
import com.hotel.implement_dao.IHabitacion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


/**
 *
 * @author Jcmm
 */
public class HabitacionServices extends ImplDao<Habitacion, Long> implements IHabitacion{
   
        public List<Habitacion> habitaciones_disponible() {
        EntityManager em = ImplDao.getEntityManagger();
        List<Habitacion> reservas;
        em.getTransaction().begin();
        //System.out.println(clase);
        Query q = em.createQuery("select t from Habitacion t where t.estado = ?1")
                .setParameter(1, "disponible");
        reservas = q.getResultList();
        em.close();
        return reservas;
    }
}
