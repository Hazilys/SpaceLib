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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Camille
 */

@Entity
public class Navette implements Serializable {

    

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private NBPLACES nbPlaces;
    @NotNull
    private Integer nbVoyagesTotal;
    @NotNull
    private Boolean disponible;
    @OneToOne
    private Quais quai;
    @OneToMany(mappedBy = "idNavette")
    private List<Operation> listeOperations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NBPLACES getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(NBPLACES nbPlaces) {
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
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Navette)) {
            return false;
        }
        Navette other = (Navette) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entities.Navette[ id=" + id + " ]";
    }
    
}
