/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facades;

import com.mycompany.entities.Navette;
import com.mycompany.entities.Quai;
import com.mycompany.entities.Station;
import java.util.Objects;
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
    
    //ajout d'une navette dans les parametres et changement du type de retour booleen
    //navette affectation en dehors de la fonction ??
    @Override
    public boolean navetteDisponible(Station station, int nbPassagers,Navette navette) {
        for (Quai quai : station.getListeQuais()){
            Navette nav = quai.getNavette();
            if (Objects.isNull(nav)){
                if (nav.getNbPlaces().getValeur() >= nbPassagers){
                    navette = nav;
                    return true;
                }
            }
        }
        return false;
    }
    // ajout du parametre quai
    @Override
    public boolean quaiDisponible(Station station,Quai quai ) {
        for (Quai quaiElement : station.getListeQuais()){
            Navette nav = quaiElement.getNavette();
            if (Objects.isNull(nav)){
                return true;
            }
        }
        return false;
    }
    
}
