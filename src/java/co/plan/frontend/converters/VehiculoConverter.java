/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.plan.frontend.converters;

import co.plan.backend.persistence.entities.Vehiculo;
import co.plan.frontend.logic.AbstractConverter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Brayan   
 */
@FacesConverter(forClass=Vehiculo.class)
public class VehiculoConverter extends AbstractConverter {
    
    public VehiculoConverter(){
        this.namedManagedBean = "vehiculoManagedBean";
    }
}
