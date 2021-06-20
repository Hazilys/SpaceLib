/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exposition;

import com.mycompany.business.GestionUtilisateursLocal;
import com.mycompany.entities.Mecanicien;
import com.mycompany.entities.Station;
import com.mycompany.entities.Utilisateur;
import com.mycompany.business.MetierMecanicienLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Camille
 */
@Stateless
public class ExpoLeg implements ExpoLegLocal {

    @EJB
    private MetierMecanicienLocal metierMecanicien;
    
    @EJB
    private GestionUtilisateursLocal gestionUtilisateurs;

    @Override
    public void seConnecter(String nomUtilisateur, String mdp) {
        this.metierMecanicien.seConnecter(nomUtilisateur, mdp);
    }

    @Override
    public void reviserNavette(Mecanicien mecanicien) {
        this.metierMecanicien.reviserNavette(mecanicien);
    }

    @Override
    public Utilisateur creerUtilisateur(String nom, String prenom, String nomUtilisateur, String motDePasse) {
        return this.metierMecanicien.creerUtilisateur(nom, prenom, nomUtilisateur, motDePasse);
    }

    @Override
    public Utilisateur creerMecanicien(String nom, String prenom, String nomUtilisateur, String motDePasse, Station station) {
        return this.metierMecanicien.creerMecanicien(nom, prenom, nomUtilisateur, motDePasse, station);
    }
    
    
    
}
