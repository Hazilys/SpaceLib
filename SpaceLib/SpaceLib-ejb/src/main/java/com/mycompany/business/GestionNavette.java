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
import com.mycompany.facades.StationFacadeLocal;
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
     @EJB
    StationFacadeLocal stationFacade;
    
    @Override
    public Navette navetteDisponible(Long idStationDepart, int nbPassagers) {
        Station stationDepart = stationFacade.find(idStationDepart);
      
        for (Quai quai : stationDepart.getListeQuais()) {
            Navette nav = quai.getNavette();

            if ((nav.getDisponible()) && (nav.getNbPlaces() <= nbPassagers)) {
                
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

    @Override
    public List<Navette> findListeNavetteReviser() {
       /*  List<Navette> navettes = new ArrayList<Navette>();
       navettes = navetteFacade.findAll();
       if(navettes.isEmpty()){
       for ( Navette e : navettes){
           if(e.getNbVoyagesTotal().intValue() % 3 == 0 ){
               navettes.remove(e);
       }
              }
            return navettes;
       }*/
          return null;
}

    @Override
    public Navette findNavette(long id) {
         return navetteFacade.find(id); 
    }
}