/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Camille
 */
@Entity
public class Revision extends Operation implements Serializable {

    private static final long serialVersionUID = 1L;
    @ManyToMany
    private final List<Navette> listeNavettesAReviser;
    @NotNull
    private ETATREVISION etatRevision;
    @ManyToOne
    private Mecanicien mecanicien;
    @ManyToOne
    private Station station;
    @ManyToOne
    private Quai quai;

    public Revision(List<Navette> listeNavettesAReviser) {
        this.listeNavettesAReviser = listeNavettesAReviser;
    }

    public ETATREVISION getEtatRevision() {
        return etatRevision;
    }

    public void setEtatRevision(ETATREVISION etatRevision) {
        this.etatRevision = etatRevision;
    }

    public Mecanicien getMecanicien() {
        return mecanicien;
    }

    public void setMecanicien(Mecanicien mecanicien) {
        this.mecanicien = mecanicien;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Quai getQuai() {
        return quai;
    }

    public void setQuai(Quai quai) {
        this.quai = quai;
    }   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (super.getIdOperation() != null ? super.getIdOperation().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Revision)) {
            return false;
        }
        Revision other = (Revision) object;
        if ((super.getIdOperation() == null && other.getIdOperation() != null) || (super.getIdOperation() != null && !super.getIdOperation().equals(other.getIdOperation()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entities.Revision[ id=" + super.getIdOperation() + " ]";
    }
    
}
