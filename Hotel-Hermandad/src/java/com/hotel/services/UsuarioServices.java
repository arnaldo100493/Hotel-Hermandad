/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel.services;

import com.hotel.dao.ImplDao;
import com.hotel.entity.Usuario;
import com.hotel.implement_dao.IUsuario;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.Query;


/**
 *
 * @author Jcmm
 */
public class UsuarioServices extends ImplDao<Usuario, Long> implements IUsuario, Serializable{
   
     public Usuario ingresar(String codigo, String contrasena) {
        EntityManager em = ImplDao.getEntityManagger();
        Usuario usuario = null;
        em.getTransaction().begin();
        try {
            String sentencia = "select u from Usuario u where u.usuario=?1 and u.contrasena=?2";
            //System.out.println(" Consulta: "+sentencia);
            Query query = em.createQuery(sentencia).setParameter(1, codigo).setParameter(2, contrasena);
            usuario = (Usuario) query.getSingleResult();

        } catch (Exception ex) {
            System.out.println("ERROR AL INICIAR SESSION: "+ex.getMessage());
        } finally {
            em.close();
        }
        return usuario;
    }

}
