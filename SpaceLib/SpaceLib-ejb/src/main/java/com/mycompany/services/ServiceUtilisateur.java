/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.mycompany.business.GestionUtilisateursLocal;
import com.mycompany.entities.Station;
import com.mycompany.entities.Usager;
import java.util.Calendar;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author AminaDridi
 */
@Stateless
public class ServiceUtilisateur implements ServiceUtilisateurLocal {
  
    @EJB
    GestionUtilisateursLocal gestionUtilisateur;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void updateVoyage(Usager usager, int choix,int Nbpersonne, Station stationArrivee, Station stationDepart, Calendar dateDepart, Calendar dateArrivee) {
 switch ( choix ){
             case 1 : gestionUtilisateur.reserver(usager, Nbpersonne, stationArrivee, stationDepart, dateDepart, dateArrivee);
             case 2 : gestionUtilisateur.intialiserVoyage(usager);
             case 3 : gestionUtilisateur.finaliserVoyage(usager);
         }
    }
}
