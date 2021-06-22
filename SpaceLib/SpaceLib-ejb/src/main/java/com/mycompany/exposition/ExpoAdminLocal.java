/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exposition;

import com.mycompany.entities.NBPLACES;
import com.mycompany.entities.Station;
import com.mycompany.entities.Utilisateur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AminaDridi
 */
@Local
public interface ExpoAdminLocal {
    
    public Utilisateur creerAdmin(String nom,String prenom,String nomUtilisateur, String motDePasse);
    
    Station creerStation(String nom, String localisation, int nbQuai, List<Integer> nbPlace);
    
    Utilisateur seConnecter(String nomUtilisateur, String mdp);
    
}
