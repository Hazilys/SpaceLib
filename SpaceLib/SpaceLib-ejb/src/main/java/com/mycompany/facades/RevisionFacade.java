/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.facades;

import com.mycompany.entities.ETATREVISION;
import com.mycompany.entities.Navette;
import com.mycompany.entities.Revision;
import com.mycompany.entities.Station;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Camille
 */

@Stateless
public class RevisionFacade extends AbstractFacade<Revision> implements RevisionFacadeLocal {

    @PersistenceContext(unitName = "SpaceLibPersistenceUnit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RevisionFacade() {
        super(Revision.class);
    }
    
      @Override
    public void creatRevisionForNavette(Navette navette, Station station) {
        
        Revision revision = new Revision();
        revision.setEtatRevision(ETATREVISION.NECESSAIRE);
        revision.setNavette(navette);
        revision.setQuai(navette.getQuai());
        revision.setDateCreationOperation(Calendar.getInstance(Locale.FRANCE));
        revision.setStation(station);
        //List<Revision> revisions = navette.getRevisions();
        //navette.setRevisions(revisions.add(revision));
        this.create(revision);
        
    }
}
