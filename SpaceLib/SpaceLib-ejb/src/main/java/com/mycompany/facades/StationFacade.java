/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facades;

import com.mycompany.entities.Navette;
import com.mycompany.entities.Quai;
import com.mycompany.entities.Station;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Camille
 */
@Stateless
public class StationFacade extends AbstractFacade<Station> implements StationFacadeLocal {

    @PersistenceContext(unitName = "SpaceLibPersistenceUnit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StationFacade() {
        super(Station.class);
    }

    @Override
    public Navette navetteDisponible(Station station, int nbPassagers) {
        for (Quai quai : station.getListeQuais()){
            Navette nav = quai.getNavette();
            if (nav!=null){
                if (nav.getNbPlaces().getValeur() >= nbPassagers){
                    return nav;
                }
            }
        }
        return null;
    }

    @Override
    public boolean quaiDisponible(Station station) {
        for (Quai quai : station.getListeQuais()){
            Navette nav = quai.getNavette();
            if (nav==null){
                return true;
            }
        }
        return false;
    }
    
}
