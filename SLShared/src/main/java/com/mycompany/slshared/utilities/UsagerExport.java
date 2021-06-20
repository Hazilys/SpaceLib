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
public class UsagerExport extends UtilisateurExport implements Serializable {
    
    //private List<Voyage> voyages;
    private StationExport localisation;
    
    // générer constructeur vide + constructeur avec tous les arguments
    // générer getteurs + setteurs

    public UsagerExport() {
    }

    public UsagerExport(StationExport localisation, Long idUtilisateur, String nom, String prenom, String nomUtilisateur, String motDePasse) {
        super(idUtilisateur, nom, prenom, nomUtilisateur, motDePasse);
        this.localisation = localisation;
    }

    public StationExport getLocalisation() {
        return localisation;
    }

    public void setLocalisation(StationExport localisation) {
        this.localisation = localisation;
    }
    
}
