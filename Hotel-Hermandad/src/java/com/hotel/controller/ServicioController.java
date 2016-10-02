/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.controller;

import com.hotel.entity.Servicio;
import com.hotel.services.ServicioServices;
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
public class ServicioController implements Serializable{

    //objetos de negocio
    private Servicio servicio = new Servicio();
    //Servicios    
    private ServicioServices sa = new ServicioServices();
    //Lista
    private List<Servicio> servicios = new ArrayList();
    //variables control

    public void preparar_crear() {
        servicio = new Servicio();
    }

    public void crear() {
        sa.crear(servicio);
        listar();
    }
    
    @PostConstruct
    public void listar() {
        servicios = sa.consultarTodo(Servicio.class);
    }

    public void eliminar(){
        sa.eliminar(servicio);
        listar();
    }
    
    public void editar(){
        sa.modificar(servicio);
        listar();
    }
    
    public void unseleccion(){
        servicio = null;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }
    
    

}
