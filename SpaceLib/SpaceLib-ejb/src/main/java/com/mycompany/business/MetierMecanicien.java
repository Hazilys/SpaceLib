/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.business;

import com.mycompany.entities.Mecanicien;
import com.mycompany.entities.Navette;
import com.mycompany.entities.Quai;
import com.mycompany.entities.Revision;
import com.mycompany.entities.Station;
import com.mycompany.entities.Utilisateur;
import com.mycompany.facades.MecanicienFacadeLocal;
import com.mycompany.facades.NavetteFacadeLocal;
import com.mycompany.facades.QuaiFacadeLocal;
import com.mycompany.facades.RevisionFacadeLocal;
import com.mycompany.facades.StationFacadeLocal;
import com.mycompany.facades.UtilisateurFacadeLocal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Camille
 */
@Stateless
public class MetierMecanicien implements MetierMecanicienLocal {

    @EJB
    private StationFacadeLocal stationFacade;

    @EJB
    private RevisionFacadeLocal revisionFacade;

    @EJB
    private MecanicienFacadeLocal mecanicienFacade;

    @EJB
    private UtilisateurFacadeLocal utilisateurFacade;
    
    @EJB
    private NavetteFacadeLocal navetteFacade;
    
    @EJB
    private QuaiFacadeLocal quaiFacade;
    

    @EJB
    private GestionNavetteLocal gestionNavette;
    

    public void seConnecter(String nomUtilisateur, String mdp) {
        this.mecanicienFacade.seConnecter(nomUtilisateur, mdp);
    }

    /*
    public void reviserNavette(Mecanicien mecanicien, int choix) {
        // récupérer la station
        // récupérer la liste des navettes à réviser
        // réviser la navette
        // supprimer la navette de la liste des navettes à réviser
/*
        Station stat = mecanicien.getStationRattachement();

        Collection<Revision> listeNavettesAReviser = stat.getRevisions();
        if (!listeNavettesAReviser.isEmpty()) {
           Revision nav = listeNavettesAReviser.get(0);

            Quai quai = nav.getQuai();
            this.revisionFacade.debuterRevisionNavette(nav, quai, stat, mecanicien);
            this.revisionFacade.cloturerRevisionNavette(nav, quai, stat, mecanicien);
            listeNavettesAReviser.remove(nav);
        }

        Station station = mecanicien.getStationRattachement();
        Collection<Quai> listeQuais = station.getListeQuais();
        Long id = station.getIdStation();
        Long idMecanicien = 0l;
        idMecanicien = mecanicienFacade.find(idMecanicien).getIdUtilisateur();
        
        for ( Quai quai : listeQuais) {
            
            List<Navette> listeNavettesRepQuai = this.stationFacade.getNavetteReparation(id);
            
            for ( Navette navette : listeNavettesRepQuai) {
                
                //this.revisionNavetteMecanicine(idMecanicien, navette, quai,choix);
            }
        }

    }*/

    public void creatRevisionForNavette(Navette navette, Station station) {
        this.revisionFacade.creatRevisionForNavette(navette, station);
    }

    // for each quai, vide ou pas, recuprer navette, nombre de voyage
    public void revisionNavetteMecanicine(Long id, Long idNavette , Long  idQuai, int choix) {
        Mecanicien mecano = mecanicienFacade.find(id);
        System.out.println(Objects.isNull(mecanicienFacade.find(id)));
        Navette navette = navetteFacade.find(idNavette);
        System.out.println(Objects.isNull(navette));
        Quai quai = quaiFacade.find(idQuai);
        System.out.println(Objects.isNull(quai));
        switch (choix) {
            case 1:  this.revisionFacade.debuterRevisionNavette(navette, navette.getQuai(), quai.getStation(), mecano);
             case 2 : this.revisionFacade.cloturerRevisionNavette(navette, navette.getQuai(), quai.getStation(), mecano);

        }

    }
    
    public List<Navette> getNavette(Long idStation) {
        return this.stationFacade.getNavette(idStation);
    }


    @Override
    public Utilisateur creerMecanicien(String nom, String prenom, String nomUtilisateur, String motDePasse, Station station) {
        return this.utilisateurFacade.creerMecanicien(nom, prenom, nomUtilisateur, motDePasse, station);
    }




    @Override
    public List<Navette> getNavetteReparation(Long idStation) {
        return this.stationFacade.getNavetteReparation(idStation);
    }

    @Override
    public List<Navette> getListNavetAr() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
