/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Camille
 */



@Entity
@XmlAccessorType( XmlAccessType.FIELD)
public class Navette implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idNavette;
    private int nbPlaces;
    private Integer nbVoyagesTotal;
    private Boolean disponible;
    @OneToOne
    private Quai quai;
    @OneToMany(mappedBy = "navette")
    @XmlTransient
    private Collection<Operation> listeOperations;
    /*
   @ManyToOne
    private Station station;*/
    
    // ajouter attributs list<voyage> ??

    public Navette() {
    }
    
    public Long getIdNavette() {
        return idNavette;
    }

    public void setIdNavette(Long idNavette) {
        this.idNavette = idNavette;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public Integer getNbVoyagesTotal() {
        return nbVoyagesTotal;
    }

    public void setNbVoyagesTotal(Integer nbVoyagesTotal) {
        this.nbVoyagesTotal = nbVoyagesTotal;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Quai getQuai() {
        return quai;
    }

    public void setQuai(Quai quai) {
        this.quai = quai;
    }

    public Collection<Operation> getListeOperations() {
        return listeOperations;
    }

    public void setListeOperations(List<Operation> listeOperations) {
        this.listeOperations = listeOperations;
    }
/*
    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }
*/
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNavette != null ? idNavette.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idNavette fields are not set
        if (!(object instanceof Navette)) {
            return false;
        }
        Navette other = (Navette) object;
        if ((this.idNavette == null && other.idNavette != null) || (this.idNavette != null && !this.idNavette.equals(other.idNavette))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entities.Navette[ id=" + idNavette + " ]";
    }
    
}
