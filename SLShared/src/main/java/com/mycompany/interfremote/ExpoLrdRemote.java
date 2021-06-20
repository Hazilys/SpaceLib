/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfremote;

import com.mycompany.slshared.utilities.StationExport;
import com.mycompany.slshared.utilities.UsagerExport;
import com.mycompany.slshared.utilities.UtilisateurExport;
import java.util.Calendar;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Camille
 */
@Remote
public interface ExpoLrdRemote {
    
    UtilisateurExport creerUtilisateur(int typeUtilisateur, String nom, String prenom, String nomUtilisateur, String motDePasse);
    
    UsagerExport inscriptionUsager(String nom, String prenom, String nomUtilisateur, String motDePasse, StationExport localisation);
    
    void reserver(UsagerExport usager, int NbPassagers, StationExport stationArrivee, StationExport stationDepart, Calendar dateDepart, Calendar dateArrivee);
    
    void intialiserVoyage(UsagerExport usager);
    
    void finaliserVoyage(UsagerExport usager);
    
    List<StationExport> getListeStations();
    
    StationExport getStationByNom(Long idStation);
    
    UtilisateurExport seConnecter(String nomUtilisateur, String mdp);
    
}
