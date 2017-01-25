/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.plan.frontend.controllers;

import co.plan.backend.persistence.entities.Usuario;
import co.plan.backend.persistence.facades.UsuarioFacadeLocal;
import co.plan.frontend.logic.IManagedBean;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Brayan
 */
@Named(value = "usuarioManagedBean")
@RequestScoped
public class UsuarioManagedBean implements Serializable, IManagedBean<Usuario>{

    private Usuario usuario;
    
    @EJB
    private UsuarioFacadeLocal usuarioFacadeLocal;
    
    public UsuarioManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
    } 

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    public List<Usuario> listarUsuario() {
        return usuarioFacadeLocal.findAll();
    }

    public String iniciarSesion(){
        FacesContext context = FacesContext.getCurrentInstance();
        String direccion = null;
        try{
            if(usuarioFacadeLocal.autenticacion(usuario)!=null){
                context.getExternalContext().getSessionMap().put("usuario", usuario);
                direccion = "/protegido/principal.plan";
            }
        }catch(Exception e){
            context.addMessage(null, new FacesMessage("Ocurrio un error " + e));
        }
        return direccion;
    }
    
    public void registrar(){
        usuarioFacadeLocal.create(usuario);
    }

    @Override
    public Usuario getObjectByKey(Integer key) {
        return usuarioFacadeLocal.find(key);
    }
    
}
