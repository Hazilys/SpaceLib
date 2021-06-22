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

/**
 *
 * @author AminaDridi
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
    
    public Navette creerNavette(int nbPlace) {
       if (nbPlace == 2 || nbPlace == 5 || nbPlace == 10 || nbPlace == 15) {

            Navette navette = new Navette();
            navette.setNbPlaces(nbPlace);
            navette.setDisponible(Boolean.TRUE);
            navette.setNbVoyagesTotal(0);
            
            //persist 
            this.create(navette);
             //this.em.flush();
            return (navette);


        
        }
        return null;
    }

    @Override
    public void incrementerNbVoyageTotal(long idNavette) {
      Navette navette = this.find(idNavette);
      navette.setNbVoyagesTotal(navette.getNbVoyagesTotal()+1);
      this.edit(navette);  
    }

  
    
    
}
