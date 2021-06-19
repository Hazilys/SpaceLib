/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Camille
 */
@Entity
public class Usager extends Utilisateur implements Serializable {
private static final long serialVersionUID = 1L;
    @OneToMany(mappedBy = "emprunteur")
    private List<Voyage> voyages;

    
    @ManyToOne
    private Station localisation;

    public Usager() {
    }

    public List<Voyage> getVoyages() {
        return voyages;
    }

    public void setVoyages(List<Voyage> voyages) {
        this.voyages = voyages;
    }

    public Station getLocalisation() {
        return localisation;
    }

    public void setLocalisation(Station localisation) {
        this.localisation = localisation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (super.getIdUtilisateur() != null ? super.getIdUtilisateur().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usager)) {
            return false;
        }
        Usager other = (Usager) object;
        if ((super.getIdUtilisateur() == null && other.getIdUtilisateur() != null) || (super.getIdUtilisateur() != null && !super.getIdUtilisateur().equals(other.getIdUtilisateur()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entities.Usager[ id=" + super.getIdUtilisateur() + " ]";
    }
    
}
