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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Camille
 */
@Entity
public class Quai implements Serializable {

    @OneToMany(mappedBy = "quai")
    private List<Revision> revisions;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idQuai;
    @NotNull
    private Boolean occupe;
    @ManyToOne
    private Station station;
    @OneToOne(mappedBy = "quai")
    private Navette navette;
    @OneToMany(mappedBy = "quai")
    private List<Operation> listeOperations;

    public Quai() {
    }

    public List<Revision> getRevisions() {
        return revisions;
    }

    public void setRevisions(List<Revision> revisions) {
        this.revisions = revisions;
    }

    public Long getIdQuai() {
        return idQuai;
    }

    public void setIdQuai(Long idQuai) {
        this.idQuai = idQuai;
    }

    public Boolean getOccupe() {
        return occupe;
    }

    public void setOccupe(Boolean occupe) {
        this.occupe = occupe;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Navette getNavette() {
        return navette;
    }

    public void setNavette(Navette navette) {
        this.navette = navette;
    }

    public List<Operation> getListeOperations() {
        return listeOperations;
    }

    public void setListeOperations(List<Operation> listeOperations) {
        this.listeOperations = listeOperations;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQuai != null ? idQuai.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idQuai fields are not set
        if (!(object instanceof Quai)) {
            return false;
        }
        Quai other = (Quai) object;
        if ((this.idQuai == null && other.idQuai != null) || (this.idQuai != null && !this.idQuai.equals(other.idQuai))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entities.Quais[ id=" + idQuai + " ]";
    }
    
}
