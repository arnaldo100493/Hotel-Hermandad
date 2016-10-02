/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel.utilities;

import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

/**
 *
 * @author FABAME
 */
public class Mapeador {
    
    private static Mapeador mapeador;
    private EntityManagerFactory fabricaManager;
    private EntityManager manager;//gestor de entidades
    
    public static Mapeador getInstance() throws PersistenceException, SQLException {//singleton, que evita que se creen mas mapeadores
        if(mapeador == null) {
            mapeador = new Mapeador();
        }
        return mapeador;
    }
    
    private Mapeador() throws PersistenceException, SQLException{
        
        fabricaManager = Persistence.createEntityManagerFactory("COOPEUDPU");//en el xml
        manager = fabricaManager.createEntityManager();
    }
    
    public void persistirObjeto(Object objeto) {
        manager.getTransaction().begin();
        try{
            manager.persist(objeto);
            manager.getTransaction().commit();
        } catch (PersistenceException e) {
            JOptionPane.showMessageDialog(null, "Error al persistir " + objeto.getClass(), "Advertencia", JOptionPane.WARNING_MESSAGE);
            manager.getTransaction().rollback();
        }
    }
    
    public Object buscarObjeto(Class clase, Object llave) {
        try {
            return this.manager.find(clase, llave);
        } catch (PersistenceException e) {
            return null;
        }
    }
    
    public void eliminarObjeto(Object objeto){
        manager.getTransaction().begin();
        try{
            manager.remove(objeto);
            manager.getTransaction().commit();
        } catch (PersistenceException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar " + objeto.getClass(), "Advertencia", JOptionPane.WARNING_MESSAGE);
            manager.getTransaction().rollback();
        }
    }
}  
   
