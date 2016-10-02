/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel.controller;

import com.hotel.entity.Usuario;
import com.hotel.services.UsuarioServices;
import com.hotel.utilidades.Mensajes;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Samsumg
 */
@ManagedBean
@SessionScoped
public class Login implements Serializable{

    private Usuario usuario = null;
    private UsuarioServices us = new UsuarioServices();
    private String nickname = null;
    private String contrasena = null;
    private String valiidate = "Rellene campos usuario y contraseña";

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getValiidate() {
        return valiidate;
    }

    public void setValiidate(String valiidate) {
        this.valiidate = valiidate;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String verificarDatos() {
        String sessionIniciada = "index?faces-redirect=true";
        usuario = us.ingresar(nickname, contrasena);
        System.out.println("Usuario: " + usuario);
        if (usuario == null) {
            valiidate = "usuario o contraseña incorectos";
            Mensajes.agregarMensajeAdvertenica("Usuario o Contraseña incorectos");

        } else {
            switch (usuario.getPerfil()) {
                case "administrador":
                    FacesContext.getCurrentInstance().getExternalContext()
                            .getSessionMap().put("administrador", usuario);
                    valiidate = "rellene campos usuario y contraseña";
                    sessionIniciada = "template/template_admin.xhtml?faces-redirect=true";
                    break;
                case "cliente":
                    FacesContext.getCurrentInstance().getExternalContext()
                            .getSessionMap().put("cliente", usuario);
                    valiidate = "rellene campos usuario y contraseña";
                    sessionIniciada = "template/template_cliente.xhtml?faces-redirect=true";
                    break;
            }//superadmin
        }
        return sessionIniciada;
    }

    /**
     *
     * @return metodo para verificar si un administrador inicio session
     */
    public boolean isSesionAdmin() {
        boolean sesion;
        if (FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().get("administrador") != null) {
            sesion = true;
        } else {
            sesion = false;
        }
        return sesion;
    }

    public boolean isSesionCliente() {
        boolean sesion;
        if (FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().get("cliente") != null) {
            sesion = true;
        } else {
            sesion = false;
        }
        return sesion;
    }
    public void salir() {
        FacesContext.getCurrentInstance().getExternalContext()
                .invalidateSession();
    }

    public Login() {
    }

}
