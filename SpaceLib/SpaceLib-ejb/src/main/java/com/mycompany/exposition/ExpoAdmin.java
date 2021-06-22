/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exposition;

import com.mycompany.business.GestionAdminLocal;
import com.mycompany.entities.NBPLACES;
import com.mycompany.entities.Station;
import com.mycompany.entities.Utilisateur;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author AminaDridi
 */
@Stateless
public class ExpoAdmin implements ExpoAdminLocal {

    @EJB
    private GestionAdminLocal gestionAdmin;
    
   
    @Override
    public Utilisateur creerAdmin(String nom, String prenom, String nomUtilisateur, String motDePasse) {
        return this.gestionAdmin.creerAdmin(nom, prenom, nomUtilisateur, motDePasse);
    }

    @Override
    public Station creerStation(String nom, String localisation, int nbQuai, List<Integer> nbPlace) {
        return this.gestionAdmin.creerStation(nom, localisation, nbQuai, nbPlace);
    }

    @Override
    public Utilisateur seConnecter(String nomUtilisateur, String mdp) {
        return this.gestionAdmin.seConnecter(nomUtilisateur, mdp);
    }

    
}
