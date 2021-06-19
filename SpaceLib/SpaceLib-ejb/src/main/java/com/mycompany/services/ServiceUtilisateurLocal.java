/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;


import com.mycompany.entities.Station;
import com.mycompany.entities.Usager;
import java.util.Calendar;
import javax.ejb.Local;

/**
 *
 * @author AminaDridi
 */
@Local
public interface ServiceUtilisateurLocal {
    public void updateVoyage (Usager usager,int choix, int Nbpersonne,Station stationArrivee, Station stationDepart, Calendar dateDepart, Calendar dateArrivee);
    
}
