/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.plan.fronted.controllers;

import co.plan.backend.persistence.entities.Concesionario;
import co.plan.backend.persistence.facades.ConcesionarioFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Brayan
 */
@Named(value = "concesionarioManagedBean")
@SessionScoped
public class ConcesionarioManagedBean implements Serializable{

    private Concesionario concesionario;
    
    @EJB
    private ConcesionarioFacadeLocal concesionarioFacadeLocal;
    
    public ConcesionarioManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        concesionario = new Concesionario();
    } 

    public Concesionario getConcesionario() {
        return concesionario;
    }

    public void setConcesionario(Concesionario concesionario) {
        this.concesionario = concesionario;
    }
    
    public String iniciarSesion(){
        Concesionario cl;
        String redireccion = null;
        try {
            cl = concesionarioFacadeLocal.iniciarSesion(concesionario);
            if (cl!=null) {
                redireccion = "/Protegido/principal";
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso","Usuario incorrecto"));

            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso","Error"));
        }
        return  redireccion ;
    }

    public String crearCuenta(){
        String redireccioncrear = null;
        try {
            redireccioncrear = "/Registro_concesionario";
        } catch (Exception e) {
            //
        }
        return redireccioncrear ;
    }
    
    public String volverInicio(){
        String volver = null;
        try {
            volver = "/pagina_de_ingreso";
        } catch (Exception e) {
            //
        }
        return volver ;
    }
    
    public void registrar(){
        concesionarioFacadeLocal.create(concesionario);
    }
    
}
