/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facades;

import com.mycompany.entities.NBPLACES;
import com.mycompany.entities.Navette;
import com.mycompany.entities.Quai;
import com.mycompany.entities.Station;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Camille
 */
@Local
public interface StationFacadeLocal {
    
    Navette navetteDisponible(Station station, int nbPassagers);
    
    boolean quaiDisponible(Station station);

    void create(Station station);
    
    Station creerStation(String localisation, int nbQuai, List<NBPLACES> nbPlace);

    void edit(Station station);

    void remove(Station station);

    Station find(Object id);

    List<Station> findAll();

    List<Station> findRange(int[] range);

    int count();
    
}
