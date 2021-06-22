/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.business;

import com.mycompany.entities.Quai;
import com.mycompany.entities.Station;
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
public class GestionStation implements GestionStationLocal {

    @EJB
    private StationFacadeLocal stationFacade;

    @Override
    public List<Quai> listQuaiDisponible(Station station) {

         List <Quai> listQuai = new ArrayList<Quai>();
         for (Quai quaiElement : station.getListeQuais()){
           if (!quaiElement.getOccupe()) {
               listQuai.add(quaiElement);
           }
           
        }
        return listQuai;    }

    @Override
    public Quai quaiDisponible(Long idStation) {
        Station station = stationFacade.find(idStation);
         for (Quai quaiElement : station.getListeQuais()){
           if (!quaiElement.getOccupe()) {
              return quaiElement;
           }      
        }
        return null;
    }

    @Override
    public List<Station> listeStation() {
        return this.stationFacade.findAll();
    }

    @Override
    public Station getStationByNom(Long idStation) {
        return this.stationFacade.find(idStation);
    }
    
    
}
