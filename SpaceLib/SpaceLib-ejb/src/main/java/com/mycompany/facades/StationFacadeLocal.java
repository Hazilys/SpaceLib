/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facades;

import com.mycompany.entities.Navette;
import com.mycompany.entities.Station;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AminaDridi
 */
@Local
public interface StationFacadeLocal {

    void create(Station station);

    void edit(Station station);

    void remove(Station station);

    Station find(Object id);

    List<Station> findAll();

    List<Station> findRange(int[] range);

    int count();
    
     Navette navetteDisponible(Station station, int nbPassagers);
    
    boolean quaiDisponible(Station station);
    
    public List<Navette> getNavette(Long idStation);

    
    Station creerStation(String nom, String localisation, int nbQuai, List<Integer> nbPlace);
    
    public List<Navette> getNavetteReparation(Long idStation);

    
}
