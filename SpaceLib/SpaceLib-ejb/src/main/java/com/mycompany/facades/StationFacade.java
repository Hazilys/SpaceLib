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
    public Navette navetteDisponible(Station station, int nbPassagers) {
        for (Quai quai : station.getListeQuais()){
            Navette nav = quai.getNavette();
            if (!Objects.isNull(nav)){
                if (nav.getNbPlaces().getValeur() >= nbPassagers && nav.getDisponible()){
                    return nav;
                }
            }
        }
        return null;
    }
    // ajout du parametre quai
    // pourquoi? j'ai suppr car aucun intérêt, on cherche juste à savoir s'il y a un quai de dispo sur la station d'arrivée
    @Override
    public boolean quaiDisponible(Station station) {
        for (Quai quaiElement : station.getListeQuais()){
            Navette nav = quaiElement.getNavette();
            if (Objects.isNull(nav)){
                return true;
            }
        }
        return false;
    }
    
}
