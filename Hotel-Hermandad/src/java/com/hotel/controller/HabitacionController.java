/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.controller;

import com.hotel.entity.Habitacion;
import com.hotel.services.HabitacionServices;
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
public class HabitacionController implements Serializable{

    //objetos de negocio
    private Habitacion habitacion = new Habitacion();
    //Servicios    
    private HabitacionServices sa = new HabitacionServices();
    //Lista
    private List<Habitacion> habitacions = new ArrayList();
    private List<Habitacion> habitaciones_disponibles = new ArrayList();
    //variables control

    
    
    public void preparar_crear() {
        habitacion = new Habitacion();
    }

    public void crear() {
        habitacion.setEstado("disponible");
        sa.crear(habitacion);
        listar();
    }
    
    @PostConstruct
    public void listar() {
        habitacions = sa.consultarTodo(Habitacion.class);
        habitaciones_disponibles = sa.habitaciones_disponible();
    }

    public void eliminar(){
        sa.eliminar(habitacion);
        listar();
    }
    
    public void editar(){
        sa.modificar(habitacion);
        listar();
    }
    
    public void unseleccion(){
        habitacion = null;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public List<Habitacion> getHabitacions() {
        return habitacions;
    }

    public void setHabitacions(List<Habitacion> habitacions) {
        this.habitacions = habitacions;
    }

    public List<Habitacion> getHabitaciones_disponibles() {
        return habitaciones_disponibles;
    }

    public void setHabitaciones_disponibles(List<Habitacion> habitaciones_disponibles) {
        this.habitaciones_disponibles = habitaciones_disponibles;
    }
    
    

}
