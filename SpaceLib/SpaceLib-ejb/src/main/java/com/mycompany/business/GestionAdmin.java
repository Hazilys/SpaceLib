/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.business;

import com.mycompany.entities.Station;
import com.mycompany.entities.Utilisateur;
import com.mycompany.facades.StationFacadeLocal;
import com.mycompany.facades.UtilisateurFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author AminaDridi
 */
@Stateless
public class GestionAdmin implements GestionAdminLocal {

    @EJB
    private UtilisateurFacadeLocal utilisateurFacade;

    @EJB
    private StationFacadeLocal stationFacade;

    
    
    @Override
    public Utilisateur creerAdmin(String nom, String prenom, String nomUtilisateur, String motDePasse) {
        return this.utilisateurFacade.creerAdmin(nom, prenom, nomUtilisateur, motDePasse);
    }

    @Override
    public Station creerStation(String nom, String localisation, int nbQuai, List<Integer> nbPlace) {
        return this.stationFacade.creerStation(nom, localisation, nbQuai, nbPlace);
    }

    @Override
    public Utilisateur seConnecter(String nomUtilisateur, String mdp) {
        return this.utilisateurFacade.seConnecter(nomUtilisateur, mdp);
    }

        
}
