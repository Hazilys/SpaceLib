/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facades;

import com.mycompany.entities.ETATREVISION;
import com.mycompany.entities.Mecanicien;
import com.mycompany.entities.Navette;
import com.mycompany.entities.Operation;
import com.mycompany.entities.Quai;
import com.mycompany.entities.Revision;
import com.mycompany.entities.Station;
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
public class MecanicienFacade extends AbstractFacade<Mecanicien> implements MecanicienFacadeLocal {

    @PersistenceContext(unitName = "SpaceLibPersistenceUnit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MecanicienFacade() {
        super(Mecanicien.class);
    }

    @Override
    public void seConnecter(String nomUtilisateur, String mdp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void debuterRevisionNavette(Navette navette, Quai quai, Station station) {
        Revision rev = new Revision();
        rev.setDateCreationOperation(new GregorianCalendar());
        rev.setNavette(navette);
        rev.setQuai(quai);
        rev.setStation(station);
        rev.getListeNavettesAReviser().remove(navette);
        rev.setEtatRevision(ETATREVISION.DEBUT);
        // définir idUtilisateur du mécanicien
        
        System.out.println("Début de la révision de la navette !");
    }

    @Override
    public void cloturerRevisionNavette(Navette navette, Quai quai, Station station) {
        Revision rev = new Revision();
        rev.setDateCreationOperation(new GregorianCalendar());
        rev.setNavette(navette);
        rev.setQuai(quai);
        rev.setStation(station);
        rev.getListeNavettesAReviser().remove(navette);
        rev.setEtatRevision(ETATREVISION.FIN);
        // définir idUtilisateur du mécanicien
        
        System.out.println("Fin de la révision de la navette !");
    }
    
}