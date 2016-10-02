/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.controller;

import com.hotel.entity.Usuario;
import com.hotel.services.UsuarioServices;
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
public class UsuarioController implements Serializable{

    //objetos de negocio
    private Usuario usuario = new Usuario();
    //Servicios    
    private UsuarioServices sa = new UsuarioServices();
    //Lista
    private List<Usuario> usuarios = new ArrayList();
    //variables control

    public void preparar_crear() {
        usuario = new Usuario();
    }

    public void crear() {
        usuario.setPerfil("usuario"); 
        sa.crear(usuario);
        listar();
    }
    
    @PostConstruct
    public void listar() {
        usuarios = sa.consultarTodo(Usuario.class);
    }

    public void eliminar(){
        sa.eliminar(usuario);
        listar();
    }
    
    public void editar(){
        sa.modificar(usuario);
        listar();
    }
    
    public void unseleccion(){
        usuario = null;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    

}
