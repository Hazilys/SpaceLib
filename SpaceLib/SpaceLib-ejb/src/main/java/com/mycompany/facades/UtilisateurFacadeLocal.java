/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facades;

import com.mycompany.entities.Utilisateur;
import com.mycompany.entities.Station;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Camille
 */
@Local
public interface UtilisateurFacadeLocal {
    
    Utilisateur seConnecter(String nomUtilisateur, String mdp);
    
    Utilisateur creerUsager(String nom, String prenom, String nomUtilisateur, String motDePasse);
    
    Utilisateur creerAdmin(String nom, String prenom, String nomUtilisateur, String motDePasse);
    
    Utilisateur creerMecanicien(String nom, String prenom, String nomUtilisateur, String motDePasse, Station station);

    void create(Utilisateur utilisateur);

    void edit(Utilisateur utilisateur);

    void remove(Utilisateur utilisateur);

    Utilisateur find(Object id);

    List<Utilisateur> findAll();

    List<Utilisateur> findRange(int[] range);

    int count();
    
}
