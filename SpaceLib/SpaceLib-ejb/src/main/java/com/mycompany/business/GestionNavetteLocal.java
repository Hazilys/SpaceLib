/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.business;

import com.mycompany.entities.Navette;
import com.mycompany.entities.Station;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AminaDridi
 */
@Local
public interface GestionNavetteLocal {
    
   public Navette navetteDisponible(Long  idStationDepart, int nbPassagers); 
    
    public List<Navette> findListeNavettesDispo();
    
    public List<Navette> findListeNavetteReviser();
    
    public Navette findNavette(long id);
    
 
    
}
