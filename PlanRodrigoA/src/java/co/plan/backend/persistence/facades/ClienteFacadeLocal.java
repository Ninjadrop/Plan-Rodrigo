/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.plan.backend.persistence.facades;

import co.plan.backend.persistence.entities.Cliente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Johaneto
 */
@Local
public interface ClienteFacadeLocal {

    void create(Cliente cliente);

    void edit(Cliente cliente);

    void remove(Cliente cliente);

    Cliente find(Object id);

    List<Cliente> findAll();

    List<Cliente> findRange(int[] range);

    int count();
    
    Cliente iniciarSesion(Cliente cl);
    
}
