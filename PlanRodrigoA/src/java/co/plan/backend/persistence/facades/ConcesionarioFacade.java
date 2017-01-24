/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.plan.backend.persistence.facades;

import co.plan.backend.persistence.entities.Concesionario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Johaneto
 */
@Stateless
public class ConcesionarioFacade extends AbstractFacade<Concesionario> implements ConcesionarioFacadeLocal {

    @PersistenceContext(unitName = "PlanRodrigoAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConcesionarioFacade() {
        super(Concesionario.class);
    }
    
    @Override
    public Concesionario iniciarSesion(Concesionario cl){
        Concesionario cliente = null;
        String consulta;
        try {
            consulta = "FROM Concesionario c WHERE c.nombre = ?1 and c.clave = ?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, cl.getNombre());
            query.setParameter(2, cl.getClave());
            query.getResultList();
            List<Concesionario> lista = query.getResultList();
            if (!lista.isEmpty()) {
                cliente = lista.get(0);
            }
            
        } catch (Exception e) {
            throw e; 
        } 
        return cliente;
    }
    
}
