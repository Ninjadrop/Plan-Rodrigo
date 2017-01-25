/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.plan.frontend.controllers;

import co.plan.backend.persistence.entities.Cliente;
import co.plan.backend.persistence.entities.Vehiculo;
import co.plan.backend.persistence.entities.Venta;
import co.plan.backend.persistence.facades.VentaFacadeLocal;
import co.plan.frontend.logic.IManagedBean;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Brayan
 */
@Named(value = "ventaManagedBean")
@RequestScoped
public class VentaManagedBean implements Serializable, IManagedBean<Venta>{

    private Venta venta;
    @EJB private VentaFacadeLocal ventaFacadeLocal;
    
    public VentaManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        venta = new Venta();
    } 

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    

    public List<Venta> listarVenta() {
        return ventaFacadeLocal.findAll();
    }
    
    
    public void registrar(){
        venta.setFecha(new Date());
        ventaFacadeLocal.create(venta);
    }
    public String registrar(Vehiculo v){
        venta.setFecha(new Date());
        venta.setIdVehiculo(v);
        ventaFacadeLocal.create(venta);
        return "/protegido/ventas.plan";
    }

    @Override
    public Venta getObjectByKey(Integer key) {
        return ventaFacadeLocal.find(key);
    }
    
}
