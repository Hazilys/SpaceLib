/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author AminaDridi
 */
@Entity
public class Revision extends Operation implements Serializable {

    private static final long serialVersionUID = 1L;
    @ManyToMany
    private List<Navette> listeNavettesAReviser;
    @NotNull
    private ETATREVISION etatRevision;
    @ManyToOne
    private Mecanicien mecanicien;
    @ManyToOne
    private Station station;
    @ManyToOne
    private Quai quai;

    public List<Navette> getListeNavettesAReviser() {
        return listeNavettesAReviser;
    }

    public void setListeNavettesAReviser(List<Navette> listeNavettesAReviser) {
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
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.listeNavettesAReviser);
        hash = 37 * hash + Objects.hashCode(this.etatRevision);
        hash = 37 * hash + Objects.hashCode(this.mecanicien);
        hash = 37 * hash + Objects.hashCode(this.station);
        hash = 37 * hash + Objects.hashCode(this.quai);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Revision other = (Revision) obj;
        if (!Objects.equals(this.listeNavettesAReviser, other.listeNavettesAReviser)) {
            return false;
        }
        if (this.etatRevision != other.etatRevision) {
            return false;
        }
        if (!Objects.equals(this.mecanicien, other.mecanicien)) {
            return false;
        }
        if (!Objects.equals(this.station, other.station)) {
            return false;
        }
        if (!Objects.equals(this.quai, other.quai)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Revision{" + "listeNavettesAReviser=" + listeNavettesAReviser + ", etatRevision=" + etatRevision + ", mecanicien=" + mecanicien + ", station=" + station + ", quai=" + quai + '}';
    }
    
    
    
}
