/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.plan.backend.persistence.facades;

import co.plan.backend.persistence.entities.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Brayan
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "brayanplanPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public Usuario getUsuarioByUsername(Usuario u) {
        Usuario user = null;
        try{
            user = em.createNamedQuery("Usuario.findByUsuario", Usuario.class)
                    .setParameter("usuario", u.getUsuario()).getSingleResult();
        }catch(Exception e){
        }
        return user;
    }

    @Override
    public Usuario autenticacion(Usuario u) {
        Usuario user = null;
        try{
            user = getUsuarioByUsername(u);
            if(!user.getClave().equals(u.getClave())) user = null;
        }catch(Exception e){}
        return user;
    }
    
}