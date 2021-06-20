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
import com.mycompany.facades.MecanicienFacadeLocal;
import com.mycompany.facades.RevisionFacadeLocal;
import com.mycompany.facades.StationFacadeLocal;
import com.mycompany.facades.UtilisateurFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Camille
 */
@Stateless
public class MetierMecanicien implements MetierMecanicienLocal {

    @EJB
    private StationFacadeLocal stationFacade;

    @EJB
    private RevisionFacadeLocal revisionFacade;

    @EJB
    private MecanicienFacadeLocal mecanicienFacade;
    
    @EJB
    private UtilisateurFacadeLocal utilisateurFacade;

    public void seConnecter(String nomUtilisateur, String mdp) {
        this.mecanicienFacade.seConnecter(nomUtilisateur, mdp);
    }
    
    public void reviserNavette(Mecanicien mecanicien){
        // récupérer la station
        // récupérer la liste des navettes à réviser
        // réviser la navette
        // supprimer la navette de la liste des navettes à réviser
       
        Station stat = mecanicien.getStationRattachement();
        
        List<Navette> listeNavettesAReviser = stat.getListeNavettesAReviser();
        if (!listeNavettesAReviser.isEmpty()){
            Navette nav = listeNavettesAReviser.get(0);
       
            Quai quai = nav.getQuai();
            this.revisionFacade.debuterRevisionNavette(nav, quai, stat, mecanicien);
            this.revisionFacade.cloturerRevisionNavette(nav, quai, stat, mecanicien);
            listeNavettesAReviser.remove(nav);
        }
        
    }
    
    
    
     public void revisionNavetteMecanicine ( Mecanicien mecano, Navette nav,int choix ){
         switch (choix){
             case 1:  this.revisionFacade.debuterRevisionNavette(nav, nav.getQuai(), nav.getStation(), mecano);
             case 2 : this.revisionFacade.cloturerRevisionNavette(nav, nav.getQuai(), nav.getStation(), mecano);
         }
        
            
         
     }

    @Override
    public List<Navette> afficherListeNavetteAReviser(Mecanicien mecanicien) {
       return mecanicien.getStationRattachement().getListeNavettesAReviser();
    }

    @Override
    public Utilisateur creerUtilisateur(String nom, String prenom, String nomUtilisateur, String motDePasse) {
        return this.utilisateurFacade.creerUtilisateur(nom, prenom, nomUtilisateur, motDePasse);
    }

    @Override
    public Utilisateur creerMecanicien(String nom, String prenom, String nomUtilisateur, String motDePasse, Station station) {
        return this.utilisateurFacade.creerMecanicien(nom, prenom, nomUtilisateur, motDePasse, station);
    }
    
    
}
