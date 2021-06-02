/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Camille
 */
@Entity
public class Mecanicien extends Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @OneToMany(mappedBy = "mecaniciens")
    private Station stationRattachement;
    
    public Station getStationRattachement() {
        return stationRattachement;
    }

    public void setStationRattachement(Station stationRattachement) {
        this.stationRattachement = stationRattachement;
    }    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsager != null ? idUsager.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mecanicien)) {
            return false;
        }
        Mecanicien other = (Mecanicien) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entities.Mecanicien[ id=" + id + " ]";
    }
    
}
