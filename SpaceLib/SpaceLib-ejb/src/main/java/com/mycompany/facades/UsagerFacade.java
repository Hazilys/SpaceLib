/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facades;

import com.mycompany.entities.ETATVOYAGE;
import com.mycompany.entities.Station;
import com.mycompany.entities.Usager;
import com.mycompany.entities.Voyage;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Camille
 */
@Stateless
public class UsagerFacade extends AbstractFacade<Usager> implements UsagerFacadeLocal {

    @PersistenceContext(unitName = "SpaceLibPersistenceUnit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsagerFacade() {
        super(Usager.class);
    }

    @Override
    public void resever(Usager emprunteur, int NbPassagers, Station stationDepart, Station stationArrivee, Calendar dateDepart, Calendar dateArrivee) {
        // si y a une navette de disponible
        // si y a un quai de disponible sur la station d'arrivée
        // alors on crée un objet Voyage + syso embarquement/arrivée
        
        // TODO !!!!
        // ajouter la navette au voyage 
        
        // Création de l'opération voyage initié (voyageI pour voyage initié)
        Voyage voyageI = new Voyage();
        voyageI.setDateCreationOperation(new GregorianCalendar());
        voyageI.setStationDepart(stationDepart);
        voyageI.setStationArrivee(stationArrivee);
        voyageI.setDateDepart(dateDepart);
        voyageI.setDateArrivee(dateArrivee);
        voyageI.setNbPassagers(NbPassagers);
        voyageI.setEmprunteur(emprunteur);
        voyageI.setEtatVoyage(ETATVOYAGE.INITIE);
        System.out.println("Le voyage est initié");
        
        // Création de l'opération voyage achevé (voyage A pour voyage achevé)
        Voyage voyageA = new Voyage();
        voyageA.setDateCreationOperation(new GregorianCalendar());
        voyageA.setStationDepart(stationDepart);
        voyageA.setStationArrivee(stationArrivee);
        voyageA.setDateDepart(dateDepart);
        voyageA.setDateArrivee(dateArrivee);
        voyageA.setNbPassagers(NbPassagers);
        voyageA.setEmprunteur(emprunteur);
        voyageA.setEtatVoyage(ETATVOYAGE.ACHEVE);
        System.out.println("Le voyage est achevé");
    }
    
}
