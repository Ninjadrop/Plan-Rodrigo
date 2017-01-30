/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.plan.backend.persistence.facades;

import co.plan.backend.persistence.entities.Vehiculo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Brayan
 */
@Stateless
public class VehiculoFacade extends AbstractFacade<Vehiculo> implements VehiculoFacadeLocal {

    @PersistenceContext(unitName = "brayanplanPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehiculoFacade() {
        super(Vehiculo.class);
    }
    

    @Override
    public List<Vehiculo> filtrarPrecio(Integer i) {
        try {
            TypedQuery<Vehiculo>filtroprecio = em.createNamedQuery("Vehiculo.precioConsulta", Vehiculo.class)
                    .setParameter("precio", i);
            return filtroprecio.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
}
