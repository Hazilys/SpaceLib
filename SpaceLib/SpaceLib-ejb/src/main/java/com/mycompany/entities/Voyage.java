/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Camille
 */
@Entity
public class Voyage extends Operation implements Serializable {

    private static final long serialVersionUID = 1L;
   
    private Station stationDepart;
    
    private Station stationArrivee;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dateDepart;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dateArrivee;
    @NotNull
    private Integer nbPassagers;
    @ManyToOne
    private Usager emprunteur;
    @NotNull
    private ETATVOYAGE etatVoyage;

    public Voyage() {
    }

    public Station getStationDepart() {
        return stationDepart;
    }

    public void setStationDepart(Station stationDepart) {
        this.stationDepart = stationDepart;
    }

    public Station getStationArrivee() {
        return stationArrivee;
    }

    public void setStationArrivee(Station stationArrivee) {
        this.stationArrivee = stationArrivee;
    }

    public Calendar getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Calendar dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Calendar getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(Calendar dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public Integer getNbPassagers() {
        return nbPassagers;
    }

    public void setNbPassagers(Integer nbPassagers) {
        this.nbPassagers = nbPassagers;
    }

    public Usager getEmprunteur() {
        return emprunteur;
    }

    public void setEmprunteur(Usager emprunteur) {
        this.emprunteur = emprunteur;
    }

    public ETATVOYAGE getEtatVoyage() {
        return etatVoyage;
    }

    public void setEtatVoyage(ETATVOYAGE etatVoyage) {
        this.etatVoyage = etatVoyage;
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
        if (!(object instanceof Voyage)) {
            return false;
        }
        Voyage other = (Voyage) object;
        if ((super.getIdOperation() == null && other.getIdOperation() != null) || (super.getIdOperation() != null && !super.getIdOperation().equals(other.getIdOperation()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entities.Voyage[ id=" + super.getIdOperation() + " ]";
    }
    
}
