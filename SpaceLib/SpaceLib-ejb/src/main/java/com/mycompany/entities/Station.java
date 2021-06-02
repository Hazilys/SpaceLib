/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Camille
 */
@Entity
public class Station implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idStation;
    @NotNull
    private String localisation;
    @ManyToOne
    private List<Quais> listeQuais;
    @NotNull
    private HashMap<Station,Integer> distance;
    @ManyToOne
    private List<Mecanicien> mecaniciens;
    @ManyToOne
    private List<Usager> usagers;

    
    
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
