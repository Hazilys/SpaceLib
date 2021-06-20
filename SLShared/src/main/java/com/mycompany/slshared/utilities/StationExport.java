/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.slshared.utilities;

import java.io.Serializable;

/**
 *
 * @author Camille
 */
public class StationExport implements Serializable{
    
    private Long idStation;
    private String nomStation;
    private String localisation;

    public StationExport() {
    }

    public StationExport(Long idStation, String nomStation, String localisation) {
        this.idStation = idStation;
        this.nomStation = nomStation;
        this.localisation = localisation;
    }

    public Long getIdStation() {
        return idStation;
    }

    public void setIdStation(Long idStation) {
        this.idStation = idStation;
    }

    public String getNomStation() {
        return nomStation;
    }

    public void setNomStation(String nomStation) {
        this.nomStation = nomStation;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
    
}
