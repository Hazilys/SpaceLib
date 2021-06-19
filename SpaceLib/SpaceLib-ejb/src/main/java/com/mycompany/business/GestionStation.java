/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.business;

import com.mycompany.entities.Quai;
import com.mycompany.entities.Station;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author AminaDridi
 */
@Stateless
public class GestionStation implements GestionStationLocal {

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
    public Quai quaiDisponible(Station station) {
         for (Quai quaiElement : station.getListeQuais()){
           if (!quaiElement.getOccupe()) {
              return quaiElement;
           }      
        }
        return null;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
