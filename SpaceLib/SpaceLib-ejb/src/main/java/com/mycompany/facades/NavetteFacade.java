/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facades;


import com.mycompany.entities.Navette;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Camille
 */
@Stateless
public class NavetteFacade extends AbstractFacade<Navette> implements NavetteFacadeLocal {

    

    @PersistenceContext(unitName = "SpaceLibPersistenceUnit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NavetteFacade() {
        super(Navette.class);
    }
/*
    @Override
    public void incrementerNbVoyageTotal(long idNavette) {
         Navette navette = this.find(idNavette);
         int nbVoyageTotalInt = navette.getNbVoyagesTotal();
         if (nbVoyageTotalInt > 3 ){ 
             navette.setNbVoyagesTotal(0);
         }
        navette.setNbVoyagesTotal(nbVoyageTotalInt+1);
        this.edit(navette);  
    }

  */

    @Override
    public List<Navette> findNavetteDispo() {
       List<Navette> navettes = new ArrayList<Navette>();
       navettes = this.findAll();
       for ( Navette e : navettes){
           if(!e.getDisponible()){
               navettes.remove(e);
       }
     }
        return navettes;

    }
}