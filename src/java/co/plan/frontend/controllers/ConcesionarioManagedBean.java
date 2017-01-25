/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.plan.frontend.controllers;

import co.plan.backend.persistence.entities.Concesionario;
import co.plan.backend.persistence.facades.ConcesionarioFacadeLocal;
import co.plan.frontend.logic.IManagedBean;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Brayan
 */
@Named(value = "concesionarioManagedBean")
@RequestScoped
public class ConcesionarioManagedBean implements Serializable, IManagedBean<Concesionario>{

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
    
    public void registrar(){
        concesionarioFacadeLocal.create(concesionario);
    }

    @Override
    public Concesionario getObjectByKey(Integer key) {
        return concesionarioFacadeLocal.find(key);
    }
    
    public List<Concesionario> listar(){
        return concesionarioFacadeLocal.findAll();
    }
    
}
