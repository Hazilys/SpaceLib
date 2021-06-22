/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facades;

import com.mycompany.entities.Navette;
import com.mycompany.entities.Quai;
import com.mycompany.entities.Station;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AminaDridi
 */
@Stateless
public class StationFacade extends AbstractFacade<Station> implements StationFacadeLocal {

    @PersistenceContext(unitName = "SpaceLibPersistenceUnit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StationFacade() {
        super(Station.class);
    }
    
    @EJB
    QuaiFacadeLocal quaiFacade;
    
    @EJB
    NavetteFacadeLocal navetteFacade;
    
    //ajout d'une navette dans les parametres et changement du type de retour booleen
    //navette affectation en dehors de la fonction ??
    @Override
    public Navette navetteDisponible(Station station, int nbPassagers) {
        for (Quai quai : station.getListeQuais()){
            Navette nav = quai.getNavette();
            if (!Objects.isNull(nav)){
                if (nav.getNbPlaces() >= nbPassagers && nav.getDisponible()){
                    return nav;
                }
            }
        }
        return null;
    }
    // ajout du parametre quai
    // pourquoi? j'ai suppr car aucun intérêt, on cherche juste à savoir s'il y a un quai de dispo sur la station d'arrivée
    @Override
    public boolean quaiDisponible(Station station) {
        for (Quai quaiElement : station.getListeQuais()){
            Navette nav = quaiElement.getNavette();
            if (Objects.isNull(nav)){
                return true;
            }
        }
        return false;
    }

    @Override
    
    public Station creerStation(String nom, String localisation, int nbQuai, List<Integer> nbPlace) {
       
       /* if (nbPlace.size() <= nbQuai / 2) {
            Station station = new Station();
            station.setLocalisation(localisation);
            
            //add new quai
            ArrayList<Quai> quais = new ArrayList<Quai>();
            for (int i = 0; i <= nbQuai; i++) {
                if (i < nbPlace.size()) {
                    for (int nbPlaceNavette : nbPlace) {
                        Navette nav = this.navetteFacade.creerNavette(nbPlaceNavette);
                       
                       // Quai quai = this.quaiFacade.creerQuai(station);
                       //  ArrayList<Quai> qu = new ArrayList<Quai>();
                        //qu.add(quai);
                     //   quai.setNavette(nav);
                       // quais.add(quai);
                        i++;
                    }
                } else {
                   // Quai quai = this.quaiFacade.creerQuai(station);
                   // quais.add(quai);
                }
            }
            // add list quai to the station
           // station.setListeQuais(quais);
            //persist
            create(station);
            return station;
            
        }
        return station;
        }/*else{
        throw new NbPlaceNavetteException("les places doivent être compris 2,5,10,15");
        
        */
        
        Station station = new Station();
        station.setNomStation(nom);
        station.setLocalisation(localisation);
       
        List<Quai> listeQuais = new ArrayList<Quai>();
      
        for (int i=0; i<nbQuai ; i++) {
              for (int n : nbPlace) {  
           Navette navette = navetteFacade.creerNavette(n);

            Quai quai = quaiFacade.creerQuai(station);
            quai.setOccupe(Boolean.FALSE);
            listeQuais.add(quai);
            navette.setQuai(quai);
           

            }
              
              
        } 
        
        station.setListeQuais(listeQuais);
        this.create(station);
        return station;
        
        
        
    }
    
        public List<Navette> getNavette(Long idStation) {
        Station station = this.find(idStation);
        List<Navette> navettes = new ArrayList<Navette>();

        if (station != null) {
            //Browse the quai list
            for (Quai quai : station.getListeQuais()) {
                
                //if the quai is  used
                if (quai.getNavette() != null) {
                    // add the navette into a new ArrayList

                   
                    navettes.add(quai.getNavette());
                }
            }
            return navettes;
             
        }
        return null;
    }
        
        public List<Navette> getNavetteReparation(Long idStation) {
        Station station = this.find(idStation);
        if (station != null) {
            System.out.println("if");
            ArrayList<Navette> navettesReparation = new ArrayList<Navette>();
            //if the ArrayList is not null
            if (this.getNavette(idStation) != null) {
                System.out.println("IF GT");
                for (Navette navette : this.getNavette(idStation)) {
                    System.out.println("ID STATION");
                    //count the number of voyage, if the number is a multiple of 3 and the number is not  0 then
                    if (navette.getNbVoyagesTotal() % 3 == 0 && navette.getNbVoyagesTotal() != 0) {
                        //add it to navettesReparation
                        navettesReparation.add(navette);
                        System.out.println("ADD");
                    }
                }
            }
                System.out.println("RETURN");
            return navettesReparation;
        }
        return null;
    }
            
        
     
}
    
    

