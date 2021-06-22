/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.business;

import com.mycompany.entities.Mecanicien;
import com.mycompany.entities.Navette;
import com.mycompany.entities.Quai;
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

    public void revisionNavetteMecanicine(Long id, Long idNavette , Long  idQuai, int choix);
   
    public void creatRevisionForNavette(Navette navette, Station station);
    
    public Utilisateur creerMecanicien(String nom, String prenom, String nomUtilisateur, String motDePasse, Station station);
    
    public List<Navette> getNavette(Long idStation);
    
    public List<Navette> getListNavetAr();
    
    public List<Navette> getNavetteReparation(Long idStation);
}
