/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.business;

import com.mycompany.entities.ETATVOYAGE;
import com.mycompany.entities.Mecanicien;
import com.mycompany.entities.Navette;
import com.mycompany.entities.Quai;
import com.mycompany.entities.Station;
import com.mycompany.entities.Usager;
import com.mycompany.entities.Utilisateur;
import com.mycompany.entities.Voyage;
import com.mycompany.facades.MecanicienFacadeLocal;
import com.mycompany.facades.NavetteFacade;
import com.mycompany.facades.NavetteFacadeLocal;
import com.mycompany.facades.StationFacadeLocal;
import com.mycompany.facades.UsagerFacadeLocal;
import com.mycompany.facades.UtilisateurFacadeLocal;
import com.mycompany.facades.VoyageFacade;
import com.mycompany.facades.VoyageFacadeLocal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author AminaDridi
 */
@Stateless
public class GestionUtilisateurs implements GestionUtilisateursLocal {

    @EJB
    private NavetteFacadeLocal navetteFacade;

    @EJB
    private VoyageFacadeLocal voyageFacade;

    @EJB
    private GestionNavetteLocal gestionNavette;

    @EJB
    private GestionStationLocal gestionStation;

    @EJB
    private MecanicienFacadeLocal mecanicienFacade;

    @EJB
    private UtilisateurFacadeLocal utilisateurFacade;

    @EJB
    private UsagerFacadeLocal usagerFacade;
    
    @EJB
    private StationFacadeLocal Station ; 
    
    
    
     

    @Override
    public Utilisateur creerUsager(String nom, String prenom, String nomUtilisateur, String motDePasse) {
        return this.utilisateurFacade.creerUsager(nom, prenom, nomUtilisateur, motDePasse);
    }
    
    @Override
    public Utilisateur creerMecanicien(String nom, String prenom, String nomUtilisateur, String motDePasse, Station station) {
        return this.utilisateurFacade.creerMecanicien(nom, prenom, nomUtilisateur, motDePasse, station);
    }
    
    @Override
    public void supprimerUtilisateur(int idUtilisateur) {
        Utilisateur u = this.utilisateurFacade.find(idUtilisateur);
        this.utilisateurFacade.remove(u);
    }

    @Override
    public Usager inscriptionUsager(String nom, String prenom, String nomUtilisateur, String motDePasse, Station localisation) {
        Usager usager = new Usager();
        usager.setLocalisation(localisation);
        usager.setMotDePasse(motDePasse);
        usager.setPrenom(prenom);
        usager.setNom(nom);
        usager.setNomUtilisateur(nomUtilisateur);
        this.usagerFacade.create(usager);
        return usager;
    }

    @Override
    public void reserver(Long idUsager, int NbPassagers, Long idStationArrivee, Long idStationDepart, Calendar dateDepart, Calendar dateArrivee) {
        Usager usager = usagerFacade.find(idUsager);
        Station stationDepart = Station.find(idStationDepart);
        Station stationArrivee = Station.find(idStationArrivee);
        Quai quai = gestionStation.quaiDisponible(idStationArrivee); 
        
        System.out.println(Objects.isNull(quai)+"  test "+Objects.isNull(gestionNavette.navetteDisponible(idStationDepart, NbPassagers)));
        // si y a une navette de disponible  et si y a un quai de disponible sur la station d'arrivée 
        if (Objects.isNull(quai) || Objects.isNull(gestionNavette.navetteDisponible(idStationDepart, NbPassagers))) {
            System.out.println("Il n'est pas possible de faire une réservation");
        } else {
          
            Navette navette = gestionNavette.navetteDisponible(idStationDepart, NbPassagers);
            navette.setDisponible(Boolean.FALSE);
            // Création de l'opération voyage initié (voyageI pour voyage initié)
            Voyage voyageI = new Voyage();
            voyageI.setDateCreationOperation(new GregorianCalendar());
            voyageI.setStationDepart(stationDepart);
            voyageI.setStationArrivee(stationArrivee);
            voyageI.setDateDepart(dateDepart);
            voyageI.setDateArrivee(dateArrivee);
            voyageI.setNbPassagers(NbPassagers);
            voyageI.setEmprunteur(usager);
            voyageI.setNavette(navette);
            voyageI.setQuai(quai);
            voyageI.setEtatVoyage(ETATVOYAGE.RESERVATION);
            voyageFacade.create(voyageI);
            
            navette.setDisponible(Boolean.FALSE);
            navetteFacade.edit(navette);
          usager.getVoyages().add(voyageI);
          usagerFacade.edit(usager);
            System.out.println("Le voyage est réservé ");
        }

    }

    @Override
    public void intialiserVoyage(Usager usager) {
       Voyage voyage;
       voyage =  usager.getVoyages().get(usager.getVoyages().size());
       if (voyage.getEtatVoyage().equals(voyage.getEtatVoyage().RESERVATION)) {
           usager.getVoyages().get(usager.getVoyages().size()).setEtatVoyage(ETATVOYAGE.INITIE);
       }
       usagerFacade.edit(usager);
    }

    @Override
    public void finaliserVoyage(Usager usager) {
           Voyage voyage;
       voyage =  usager.getVoyages().get(usager.getVoyages().size());
       if (voyage.getEtatVoyage().equals(voyage.getEtatVoyage().INITIE)) {
           usager.getVoyages().get(usager.getVoyages().size()).setEtatVoyage(ETATVOYAGE.ACHEVE);
       }
       usagerFacade.edit(usager);
    }
    
    @Override
    public Utilisateur seConnecter(String nomUtilisateur, String mdp){
        return this.utilisateurFacade.seConnecter(nomUtilisateur, mdp);
    }
}
