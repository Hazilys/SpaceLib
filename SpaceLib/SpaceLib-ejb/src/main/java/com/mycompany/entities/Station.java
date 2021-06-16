/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
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
public class Station implements Serializable {

    @OneToMany(mappedBy = "stationDepart")
    private List<Voyage> voyages;

    @OneToMany(mappedBy = "station")
    private List<Revision> revisions;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idStation;
    @NotNull
    private String localisation;
    @NotNull
    private HashMap<Station,Integer> distance;
    @OneToMany(mappedBy = "station")
    private List<Quai> listeQuais;
    @OneToMany(mappedBy = "stationRattachement")
    private List<Mecanicien> listeMecaniciens;
    @OneToMany(mappedBy = "localisation")
    private List<Usager> listeUsagers;

    public Station() {
    }

    public List<Voyage> getVoyages() {
        return voyages;
    }

    public void setVoyages(List<Voyage> voyages) {
        this.voyages = voyages;
    }

    
    public List<Revision> getRevisions() {
        return revisions;
    }

    public void setRevisions(List<Revision> revisions) {
        this.revisions = revisions;
    }

    public Long getIdStation() {
        return idStation;
    }

    public void setIdStation(Long idStation) {
        this.idStation = idStation;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public HashMap<Station, Integer> getDistance() {
        return distance;
    }

    public void setDistance(HashMap<Station, Integer> distance) {
        this.distance = distance;
    }

    public List<Quai> getListeQuais() {
        return listeQuais;
    }

    public void setListeQuais(List<Quai> listeQuais) {
        this.listeQuais = listeQuais;
    }

    public List<Mecanicien> getListeMecaniciens() {
        return listeMecaniciens;
    }

    public void setListeMecaniciens(List<Mecanicien> listeMecaniciens) {
        this.listeMecaniciens = listeMecaniciens;
    }

    public List<Usager> getListeUsagers() {
        return listeUsagers;
    }

    public void setListeUsagers(List<Usager> listeUsagers) {
        this.listeUsagers = listeUsagers;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStation != null ? idStation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idStation fields are not set
        if (!(object instanceof Station)) {
            return false;
        }
        Station other = (Station) object;
        if ((this.idStation == null && other.idStation != null) || (this.idStation != null && !this.idStation.equals(other.idStation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entities.Station[ id=" + idStation + " ]";
    }
    
}
