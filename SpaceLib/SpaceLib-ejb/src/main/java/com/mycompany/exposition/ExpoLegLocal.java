/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exposition;

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
public interface ExpoLegLocal {
   
    void seConnecter(String nomUtilisateur, String mdp);
    
    void revisionNavetteMecanicine(Long id, Long idNavette , Long  idQuai, int choix);
    
    Utilisateur creerMecanicien(String nom, String prenom, String nomUtilisateur, String motDePasse, Station station);
    
    public List<Navette> getNavette(Long idStation);
    
    public List<Navette> getNavetteReparation(Long idStation);
    
    
}
