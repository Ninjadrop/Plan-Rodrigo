/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.plan.fronted.controllers;

import co.plan.backend.persistence.entities.Cliente;
import co.plan.backend.persistence.facades.ClienteFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Brayan
 */
@Named(value = "clienteManagedBean")
@SessionScoped
public class ClienteManagedBean implements Serializable{

    private Cliente cliente;
    
    @EJB
    private ClienteFacadeLocal clienteFacadeLocal;
    
    public ClienteManagedBean() {
    }
    
    @SessionScoped
    public void init(){
        cliente = new Cliente();
    } 

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public String iniciarSesion(){
        Cliente cl;
        String redireccion = null;
        try {
            cl = clienteFacadeLocal.iniciarSesion(cliente);
            if (cl!=null) {
                redireccion = "/protegido/principal?faces-redirect=true";
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso","Usuario incorrecto"));

            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso","Error"));
        }
        return  redireccion ;
    }
    
}
