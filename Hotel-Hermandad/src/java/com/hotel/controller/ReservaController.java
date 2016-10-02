/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.controller;

import com.hotel.entity.Habitacion;
import com.hotel.entity.Reserva;
import com.hotel.services.HabitacionServices;
import com.hotel.services.ReservaServices;
import com.hotel.utilidades.ConversionesDeFecha;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
public class ReservaController implements Serializable{

    //objetos de negocio
    private Reserva reserva = new Reserva();
    //Servicios    
    private ReservaServices sa = new ReservaServices();
    private HabitacionServices sh = new HabitacionServices();
    //Lista
    private List<Reserva> reservas = new ArrayList();
    //variables control
    private String min_date;

    public ReservaController() {
        min_date = ConversionesDeFecha.dateaString3(new Date());
    }
    
    public String getMin_date() {
        return min_date;
    }

    public void setMin_date(String min_date) {
        this.min_date = min_date;
    }
    

    public void preparar_crear() {
        reserva = new Reserva();
    }

    public void crear() {
//        for (Habitacion habitacion : reserva.getHabitaciones()) {
//            
//            habitacion.setEstado("ocupada");
//            System.out.println("Entre: "+habitacion.getEstado());
//            sh.modificar(habitacion);
//        }
        sa.crear(reserva);
        listar();
    }
    
    @PostConstruct
    public void listar() {
        reservas = sa.consultarTodo(Reserva.class);
    }

    public void eliminar(){
        sa.eliminar(reserva);
        listar();
    }
    
    public void editar(){
        sa.modificar(reserva);
        listar();
    }
    
    public void unseleccion(){
        reserva = null;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
    
    

}
