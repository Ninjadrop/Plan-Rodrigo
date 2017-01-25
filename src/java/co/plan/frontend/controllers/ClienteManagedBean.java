/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.plan.frontend.controllers;

import co.plan.backend.persistence.entities.Cliente;
import co.plan.backend.persistence.facades.ClienteFacadeLocal;
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
@Named(value = "clienteManagedBean")
@RequestScoped
public class ClienteManagedBean implements Serializable, IManagedBean<Cliente>{

    private Cliente cliente;
    
    @EJB
    private ClienteFacadeLocal clienteFacadeLocal;
    
    public ClienteManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        cliente = new Cliente();
    } 

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    public List<Cliente> listarCliente() {
        return clienteFacadeLocal.findAll();
    }

    public String crearCuenta(){
        String redireccioncrear = null;
        try {
            redireccioncrear = "/Registro_usuario";
        } catch (Exception e) {
            //
        }
        return redireccioncrear ;
    }
    public void registrar(){
        clienteFacadeLocal.create(cliente);
    }

    @Override
    public Cliente getObjectByKey(Integer key) {
        return clienteFacadeLocal.find(key);
    }
    
}
