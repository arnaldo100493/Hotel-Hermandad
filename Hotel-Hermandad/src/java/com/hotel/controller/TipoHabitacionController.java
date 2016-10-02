/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.controller;

import com.hotel.entity.TipoHabitacion;
import com.hotel.services.TipoHabitacionServices;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Carlos Alberto Gonzalez Monterrosa
 */
@ManagedBean
@SessionScoped
public class TipoHabitacionController implements Serializable{

    //objetos de negocio
    private TipoHabitacion tipo_habitacion = new TipoHabitacion();
    //Servicios    
    private TipoHabitacionServices sa = new TipoHabitacionServices();
    //Lista
    private List<TipoHabitacion> tipo_habitacions = new ArrayList();
    //variables control

    public void preparar_crear() {
        tipo_habitacion = new TipoHabitacion();
    }

    public void crear() { 
        sa.crear(tipo_habitacion);
        listar();
    }
    
    @PostConstruct
    public void listar() {
        tipo_habitacions = sa.consultarTodo(TipoHabitacion.class);
    }

    public void eliminar(){
        sa.eliminar(tipo_habitacion);
        listar();
    }
    
    public void editar(){
        sa.modificar(tipo_habitacion);
        listar();
    }
    
    public void unseleccion(){
        tipo_habitacion = null;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipo_habitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipo_habitacion) {
        this.tipo_habitacion = tipo_habitacion;
    }

    public List<TipoHabitacion> getTipoHabitacions() {
        return tipo_habitacions;
    }

    public void setTipoHabitacions(List<TipoHabitacion> tipo_habitacions) {
        this.tipo_habitacions = tipo_habitacions;
    }
    
    

}
