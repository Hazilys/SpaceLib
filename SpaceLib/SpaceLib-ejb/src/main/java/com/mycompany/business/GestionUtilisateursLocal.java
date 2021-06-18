/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.business;

import com.mycompany.entities.Station;
import com.mycompany.entities.Usager;
import com.mycompany.entities.Utilisateur;
import javax.ejb.Local;

/**
 *
 * @author AminaDridi
 */
@Local
public interface GestionUtilisateursLocal {
    
    public Utilisateur creerUtilisateur(int typeUtilisateur,String nom,String prenom,String nomUtilisateur, String motDePasse);
    
    public Usager inscriptionUsager(String nom,String prenom,String nomUtilisateur, String motDePasse, Station localisation);
    
    public void supprimerUtilisateur(int idUtilisateur);
    
  
    
    
    
}