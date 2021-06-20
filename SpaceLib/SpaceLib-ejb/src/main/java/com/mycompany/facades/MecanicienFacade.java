/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facades;

import com.mycompany.entities.ETATREVISION;
import com.mycompany.entities.Mecanicien;
import com.mycompany.entities.Navette;
import com.mycompany.entities.Operation;
import com.mycompany.entities.Quai;
import com.mycompany.entities.Revision;
import com.mycompany.entities.Station;
import com.mycompany.entities.Utilisateur;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Camille
 */
@Stateless
public class MecanicienFacade extends AbstractFacade<Mecanicien> implements MecanicienFacadeLocal {

    @PersistenceContext(unitName = "SpaceLibPersistenceUnit")
    private EntityManager em;
     @EJB
       UtilisateurFacadeLocal utiliateurFaced; 

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MecanicienFacade() {
        super(Mecanicien.class);
    }

    @Override
    public void seConnecter(String nomUtilisateur, String mdp) {

    
    }
    
}
