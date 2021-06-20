/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.business;

import com.mycompany.metier.*;
import com.mycompany.entities.NBPLACES;
import com.mycompany.entities.Navette;
import com.mycompany.entities.Quai;
import com.mycompany.entities.Station;
import com.mycompany.entities.Usager;
import com.mycompany.entities.Utilisateur;
import com.mycompany.facades.NavetteFacadeLocal;
import com.mycompany.facades.RevisionFacadeLocal;
import com.mycompany.facades.StationFacadeLocal;
import com.mycompany.facades.UsagerFacadeLocal;
import com.mycompany.facades.UtilisateurFacadeLocal;
import com.mycompany.facades.VoyageFacadeLocal;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Camille
 */
@Stateless
public class BorneReservation implements BorneReservationLocal {

    @EJB
    private UtilisateurFacadeLocal utilisateurFacade;

    @EJB
    private UsagerFacadeLocal usagerFacade;

    @EJB
    private NavetteFacadeLocal navetteFacade;

    @EJB
    private RevisionFacadeLocal revisionFacade;

    @EJB
    private StationFacadeLocal stationFacade;

    @EJB
    private VoyageFacadeLocal voyageFacade;
    
    public Utilisateur creerUtilisateur(String nom, String prenom, String nomUtilisateur, String motDePasse){
        return this.utilisateurFacade.creerUtilisateur(nom, prenom, nomUtilisateur, motDePasse);
    }
    
    public Utilisateur creerMecanicien(String nom, String prenom, String nomUtilisateur, String motDePasse, Station station){
        return this.utilisateurFacade.creerMecanicien(nom, prenom, nomUtilisateur, motDePasse, station);
    }
    
    
    public Utilisateur seConnecter(String nomUtilisateur, String mdp){
        return this.utilisateurFacade.seConnecter(nomUtilisateur, mdp);
    }

    public void resever(Usager emprunteur, int NbPassagers, Station stationDepart, Station stationArrivee, Calendar dateDepart, Calendar dateArrivee, Quai quai) {
        Station stationD = this.stationFacade.find(stationDepart);
        Station stationA = this.stationFacade.find(stationArrivee);
        
        Usager usager = this.usagerFacade.find(emprunteur);
        
        Navette nav = this.stationFacade.navetteDisponible(stationD, NbPassagers);
        Navette nav2 = this.navetteFacade.find(nav);
        
        // vérifier que navette dispo + quai arrivé dispo
        if (!Objects.isNull(nav2) && this.stationFacade.quaiDisponible(stationA)){
            // modification de la disponibilité de la navette + voyage + nb de voyages de la navette+1 + modification de l'emplacement de l'emprunteur
            nav2.setDisponible(Boolean.FALSE);
            this.voyageFacade.reserver(emprunteur, NbPassagers, stationD, stationA, dateDepart, dateArrivee, quai, nav2);
            nav2.setNbVoyagesTotal(nav2.getNbVoyagesTotal()+1);
            usager.setLocalisation(stationA);
            nav2.setDisponible(Boolean.TRUE);
            
            // si la navette a effectué 3 voyages
            // on crée la révision nécessaire et on update la liste des navettes à réviser de la station
            if (nav2.getNbVoyagesTotal()==3){
                this.revisionFacade.creatRevisionForNavette(nav2, stationA);
                List<Navette> listeNavettesAReviser = stationA.getListeNavettesAReviser();
                listeNavettesAReviser.add(nav2);
                stationA.setListeNavettesAReviser(listeNavettesAReviser);
            }
        }        
    }
}
