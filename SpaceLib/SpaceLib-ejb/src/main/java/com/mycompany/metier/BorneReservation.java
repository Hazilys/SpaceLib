/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.metier;

import com.mycompany.entities.Navette;
import com.mycompany.entities.Quai;
import com.mycompany.entities.Station;
import com.mycompany.entities.Usager;
import com.mycompany.entities.Utilisateur;
import com.mycompany.facades.StationFacadeLocal;
import com.mycompany.facades.UtilisateurFacadeLocal;
import com.mycompany.facades.VoyageFacadeLocal;
import java.util.Calendar;
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
    private StationFacadeLocal stationFacade;

    @EJB
    private VoyageFacadeLocal voyageFacade;
    
    public Utilisateur creerCompte(String nomUtilisateur, String mdp){
        return this.utilisateurFacade.creerCompte(nomUtilisateur, mdp);
    }
    
    public Utilisateur seConnecter(String nomUtilisateur, String mdp){
        return this.utilisateurFacade.seConnecter(nomUtilisateur, mdp);
    }

    public void resever(Usager emprunteur, int NbPassagers, Station stationDepart, Station stationArrivee, Calendar dateDepart, Calendar dateArrivee, Quai quai) {
        Navette nav = this.stationFacade.navetteDisponible(stationDepart, NbPassagers);
        // navette dispo + quai arrivé dispo
        if (!Objects.isNull(nav) && this.stationFacade.quaiDisponible(stationArrivee)){
            nav.setDisponible(Boolean.FALSE);
            this.voyageFacade.resever(emprunteur, NbPassagers, stationDepart, stationArrivee, dateDepart, dateArrivee, quai, nav);
            nav.setDisponible(Boolean.TRUE);
        }        
    }
}
