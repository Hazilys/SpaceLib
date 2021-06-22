/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.business;

import com.mycompany.entities.Quai;
import com.mycompany.entities.Station;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AminaDridi
 */
@Local
public interface GestionStationLocal {
    
    public  List <Quai> listQuaiDisponible(Station station);
     public Quai quaiDisponible(Long idStation);
     public List<Station> listeStation();
     public Station getStationByNom(Long idStation);
     
    
}
