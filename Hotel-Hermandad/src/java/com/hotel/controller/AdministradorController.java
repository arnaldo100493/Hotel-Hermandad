/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.controller;

import com.hotel.entity.Administrador;
import com.hotel.services.AdministradorServices;
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
public class AdministradorController implements Serializable{

    //objetos de negocio
    private Administrador administrador = new Administrador();
    //Servicios    
    private AdministradorServices sa = new AdministradorServices();
    //Lista
    private List<Administrador> administradors = new ArrayList();
    //variables control

    public void preparar_crear() {
        administrador = new Administrador();
    }

    public void crear() {
        administrador.setPerfil("administrador"); 
        sa.crear(administrador);
        listar();
    }
    
    @PostConstruct
    public void listar() {
        administradors = sa.consultarTodo(Administrador.class);
    }

    public void eliminar(){
        sa.eliminar(administrador);
        listar();
    }
    
    public void editar(){
        sa.modificar(administrador);
        listar();
    }
    
    public void unseleccion(){
        administrador = null;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public List<Administrador> getAdministradors() {
        return administradors;
    }

    public void setAdministradors(List<Administrador> administradors) {
        this.administradors = administradors;
    }
    
    

}
