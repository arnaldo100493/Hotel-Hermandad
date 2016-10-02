/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.controller;

import com.hotel.entity.Cliente;
import com.hotel.services.ClienteServices;
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
public class ClienteController implements Serializable{

    //objetos de negocio
    private Cliente cliente = new Cliente();
    //Servicios    
    private ClienteServices sa = new ClienteServices();
    //Lista
    private List<Cliente> clientes = new ArrayList();
    //variables control

    public void preparar_crear() {
        cliente = new Cliente();
    }

    public void crear() {
        cliente.setPerfil("cliente"); 
        sa.crear(cliente);
        listar();
    }
    
    @PostConstruct
    public void listar() {
        clientes = sa.consultarTodo(Cliente.class);
    }

    public void eliminar(){
        sa.eliminar(cliente);
        listar();
    }
    
    public void editar(){
        sa.modificar(cliente);
        listar();
    }
    
    public void unseleccion(){
        cliente = null;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    

}
