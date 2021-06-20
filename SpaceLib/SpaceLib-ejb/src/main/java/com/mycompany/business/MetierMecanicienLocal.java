/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.business;

import com.mycompany.entities.Mecanicien;
import com.mycompany.entities.Navette;
import com.mycompany.entities.Station;
import com.mycompany.entities.Utilisateur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Camille
 */
@Local
public interface MetierMecanicienLocal {
    
    void seConnecter(String nomUtilisateur, String mdp);
    
    void reviserNavette(Mecanicien mecanicien);
    public List<Navette> afficherListeNavetteAReviser(Mecanicien mecanicien);
    
    public Utilisateur creerUtilisateur(String nom,String prenom,String nomUtilisateur, String motDePasse);
    
    public Utilisateur creerMecanicien(String nom, String prenom, String nomUtilisateur, String motDePasse, Station station);
    
    
}
