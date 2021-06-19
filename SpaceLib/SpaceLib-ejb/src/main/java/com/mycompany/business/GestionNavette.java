/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.business;

import com.mycompany.entities.Navette;
import com.mycompany.entities.Quai;
import com.mycompany.entities.Station;
import com.mycompany.facades.NavetteFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author AminaDridi
 */
@Stateless
public class GestionNavette implements GestionNavetteLocal {
    
    @EJB
    NavetteFacadeLocal navetteFacade;
    
    @Override
    public Navette navetteDisponible(Station stationDepart, int nbPassagers) {
        for (Quai quai : stationDepart.getListeQuais()) {
            Navette nav = quai.getNavette();

            if ((nav.getDisponible()) && (nav.getNbPlaces().getValeur() >= nbPassagers)) {
                return nav;
            }

        }
        return null;
    }
     @Override
    public List<Navette> findListeNavettesDispo() {
       List<Navette> navettes = new ArrayList<Navette>();
       navettes = navetteFacade.findAll();
       for ( Navette e : navettes){
           if(!e.getDisponible()){
               navettes.remove(e);
       }
     }
        return navettes;

    }
}
