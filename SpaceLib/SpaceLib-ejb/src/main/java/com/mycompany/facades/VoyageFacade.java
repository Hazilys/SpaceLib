/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facades;

import com.mycompany.entities.ETATVOYAGE;
import com.mycompany.entities.Navette;
import com.mycompany.entities.Quai;
import com.mycompany.entities.Station;
import com.mycompany.entities.Usager;
import com.mycompany.entities.Voyage;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Camille
 */
@Stateless
public class VoyageFacade extends AbstractFacade<Voyage> implements VoyageFacadeLocal {

    @PersistenceContext(unitName = "SpaceLibPersistenceUnit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VoyageFacade() {
        super(Voyage.class);
    }
    
    @Override
    public void reserver(Usager emprunteur, int NbPassagers, Station stationDepart, Station stationArrivee, Calendar dateDepart, Calendar dateArrivee, Quai quai, Navette nav) {
              
        // Création de l'opération voyage initié (voyageI pour voyage initié)
        Voyage voyageI = new Voyage();
        voyageI.setDateCreationOperation(new GregorianCalendar());
        voyageI.setStationDepart(stationDepart);
        voyageI.setStationArrivee(stationArrivee);
        voyageI.setDateDepart(dateDepart);
        voyageI.setDateArrivee(dateArrivee);
        voyageI.setNbPassagers(NbPassagers);
        voyageI.setEmprunteur(emprunteur);
        voyageI.setNavette(nav);
        voyageI.setQuai(quai);
        voyageI.setEtatVoyage(ETATVOYAGE.INITIE);
        
        this.create(voyageI);
        
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
        
        this.create(voyageA);
        
        System.out.println("Le voyage est achevé");
    }
    
}
