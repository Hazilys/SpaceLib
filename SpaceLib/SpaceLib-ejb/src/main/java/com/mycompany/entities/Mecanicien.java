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
public class Mecanicien extends Utilisateur implements Serializable {

    @OneToMany(mappedBy = "mecanicien")
    private List<Revision> revisions;

    private static final long serialVersionUID = 1L;
    @ManyToOne
    private Station stationRattachement;

    public Mecanicien() {
    }

    public List<Revision> getRevisions() {
        return revisions;
    }

    public void setRevisions(List<Revision> revisions) {
        this.revisions = revisions;
    }

    public Station getStationRattachement() {
        return stationRattachement;
    }

    public void setStationRattachement(Station stationRattachement) {
        this.stationRattachement = stationRattachement;
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
        if (!(object instanceof Mecanicien)) {
            return false;
        }
        Mecanicien other = (Mecanicien) object;
        if ((super.getIdUtilisateur() == null && other.getIdUtilisateur() != null) || (super.getIdUtilisateur() != null && !super.getIdUtilisateur().equals(other.getIdUtilisateur()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entities.Mecanicien[ id=" + super.getIdUtilisateur() + " ]";
    }
    
}
