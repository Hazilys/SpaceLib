/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.business;

import com.mycompany.entities.Station;
import com.mycompany.entities.Usager;
import com.mycompany.entities.Utilisateur;
import java.util.Calendar;
import javax.ejb.Local;

/**
 *
 * @author AminaDridi
 */
@Local
public interface GestionUtilisateursLocal {
    
    public Utilisateur creerUtilisateur(String nom,String prenom,String nomUtilisateur, String motDePasse);
    
    public Utilisateur creerMecanicien(String nom,String prenom,String nomUtilisateur, String motDePasse, Station station);
    
    public Usager inscriptionUsager(String nom,String prenom,String nomUtilisateur, String motDePasse, Station localisation);
    
    public void supprimerUtilisateur(int idUtilisateur);
    
    public void reserver(Usager usager, int NbPassagers, Station stationArrivee,Station stationDepart,Calendar dateDepart, Calendar dateArrivee);
    
    public void intialiserVoyage(Usager usager);
    
    public void finaliserVoyage ( Usager usager );
    
    public Utilisateur seConnecter(String nomUtilisateur, String mdp);
    
   
    
    
    
}
