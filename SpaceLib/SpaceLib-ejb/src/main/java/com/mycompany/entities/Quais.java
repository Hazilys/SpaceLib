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
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Camille
 */
@Entity
public class Quais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idQuai;
    @NotNull
    private Boolean occupe;
    @OneToOne(mappedBy = "quai")
    private Navette navette;
    @OneToMany(mappedBy = "listeQuais")
    private Station station;

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

    public Navette getNavette() {
        return navette;
    }

    public void setNavette(Navette navette) {
        this.navette = navette;
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
        if (!(object instanceof Quais)) {
            return false;
        }
        Quais other = (Quais) object;
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
