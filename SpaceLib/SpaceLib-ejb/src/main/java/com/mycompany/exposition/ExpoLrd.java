/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exposition;
/*
import com.mycompany.business.GestionStationLocal;
 import com.mycompany.business.GestionUtilisateursLocal;
import com.mycompany.entities.Station;
import com.mycompany.entities.Usager;
import com.mycompany.entities.Utilisateur;
import com.mycompany.facades.StationFacadeLocal;
import com.mycompany.facades.UsagerFacadeLocal;
import com.mycompany.interfremote.ExpoLrdRemote;
import com.mycompany.slshared.utilities.StationExport;
import com.mycompany.slshared.utilities.UsagerExport;
import com.mycompany.slshared.utilities.UtilisateurExport;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Camille
 */

/*
@Stateless
public class ExpoLrd implements ExpoLrdRemote {

    
    @EJB
    private GestionStationLocal gestionStation;

    @EJB
    private UsagerFacadeLocal usagerFacade;

    @EJB
    private StationFacadeLocal stationFacade;

    @EJB
    private GestionUtilisateursLocal gestionUtilisateurs;

    
    
    @Override
    public UtilisateurExport creerUtilisateur(int typeUtilisateur, String nom, String prenom, String nomUtilisateur, String motDePasse){
        Utilisateur util = this.gestionUtilisateurs.creerUtilisateur(typeUtilisateur, nom, prenom, nomUtilisateur, motDePasse);
        return new UtilisateurExport(util.getIdUtilisateur(), util.getNom(), util.getPrenom(), util.getNomUtilisateur(), util.getMotDePasse());
    }
    
    @Override
    public UsagerExport inscriptionUsager(String nom, String prenom, String nomUtilisateur, String motDePasse, StationExport localisation){
        Station st1 = null;
        List<Station> listeStations = this.stationFacade.findAll();
        for (Station st : listeStations){
            if (st.getIdStation()==localisation.getIdStation()){
                st1 = st;
            }
        }
        Usager util = this.gestionUtilisateurs.inscriptionUsager(nom, prenom, nomUtilisateur, motDePasse, st1);
        
        Station st2 = util.getLocalisation();
        StationExport ste = new StationExport(st2.getIdStation(), st2.getNomStation(), st2.getLocalisation());
        
        return new UsagerExport(ste, util.getIdUtilisateur(), util.getNom(), util.getPrenom(), util.getNomUtilisateur(), util.getMotDePasse());
    }
    
    @Override
    public void reserver(UsagerExport usager, int NbPassagers, StationExport stationArrivee, StationExport stationDepart, Calendar dateDepart, Calendar dateArrivee) {
        Station st1 = null;
        List<Station> listeStations1 = this.stationFacade.findAll();
        for (Station st : listeStations1){
            if (Objects.equals(st.getIdStation(), stationArrivee.getIdStation())){
                st1 = st;
            }
        }
        Station st2 = null;
        List<Station> listeStations2 = this.stationFacade.findAll();
        for (Station st : listeStations2){
            if (Objects.equals(st.getIdStation(), stationDepart.getIdStation())){
                st2 = st;
            }
        }
        
        Usager us1 = null;
        List<Usager> listeUsagers = this.usagerFacade.findAll();
        for (Usager us : listeUsagers){
            if (Objects.equals(us.getIdUtilisateur(), usager.getIdUtilisateur())){
                us1 = us;
            }
        }
        
        this.gestionUtilisateurs.reserver(us1, NbPassagers, st1, st2, dateDepart, dateArrivee);
    }
    
    @Override
    public void intialiserVoyage(UsagerExport usager){
        Usager us1 = null;
        List<Usager> listeUsagers = this.usagerFacade.findAll();
        for (Usager us : listeUsagers){
            if (Objects.equals(us.getIdUtilisateur(), usager.getIdUtilisateur())){
                us1 = us;
            }
        }
        
        this.gestionUtilisateurs.intialiserVoyage(us1);
    }
    
    @Override
    public void finaliserVoyage(UsagerExport usager){
        Usager us1 = null;
        List<Usager> listeUsagers = this.usagerFacade.findAll();
        for (Usager us : listeUsagers){
            if (Objects.equals(us.getIdUtilisateur(), usager.getIdUtilisateur())){
                us1 = us;
            }
        }
        
        this.gestionUtilisateurs.finaliserVoyage(us1);
    }
    
    @Override
    public List<StationExport> getListeStations(){
        List<Station> listeStations = this.gestionStation.listeStation();
        List<StationExport> listeStationsExport = new ArrayList<>();
        for (Station st : listeStations){
            listeStationsExport.add(new StationExport(st.getIdStation(), st.getNomStation(), st.getLocalisation()));
        }
        return listeStationsExport;
    }
    
    public StationExport getStationByNom(Long idStation){
        Station st = this.gestionStation.getStationByNom(idStation);
        return new StationExport(st.getIdStation(), st.getNomStation(), st.getLocalisation());
    }
    
    public UtilisateurExport seConnecter(String nomUtilisateur, String mdp){
        Utilisateur util = this.gestionUtilisateurs.seConnecter(nomUtilisateur, mdp);
        return new UtilisateurExport(util.getIdUtilisateur(), util.getNom(), util.getPrenom(), util.getNomUtilisateur(), util.getMotDePasse());
    }
}
  */  



