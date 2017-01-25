/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.plan.frontend.converters;

import co.plan.backend.persistence.entities.Cliente;
import co.plan.frontend.logic.AbstractConverter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Brayan   
 */
@FacesConverter(forClass=Cliente.class)
public class ClienteConverter extends AbstractConverter {
    
    public ClienteConverter(){
        this.namedManagedBean = "clienteManagedBean";
    }
}
