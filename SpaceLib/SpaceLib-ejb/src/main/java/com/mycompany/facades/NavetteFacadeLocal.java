/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facades;

import com.mycompany.entities.Navette;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AminaDridi
 */
@Local
public interface NavetteFacadeLocal {

    void create(Navette navette);

    void edit(Navette navette);

    void remove(Navette navette);

    Navette find(Object id);

    public List<Navette> findAll();

    public List<Navette> findRange(int[] range);

    int count();
    
    public Navette creerNavette(int nbPlace);
    
   public void incrementerNbVoyageTotal(long idNavette);
    
}
