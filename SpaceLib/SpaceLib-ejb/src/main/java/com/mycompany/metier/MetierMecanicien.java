/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.metier;

import com.mycompany.entities.Mecanicien;
import com.mycompany.entities.Navette;
import com.mycompany.entities.Quai;
import com.mycompany.entities.Station;
import com.mycompany.facades.MecanicienFacadeLocal;
import com.mycompany.facades.RevisionFacadeLocal;
import com.mycompany.facades.StationFacadeLocal;
import java.util.List;
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

    public void seConnecter(String nomUtilisateur, String mdp) {
        this.mecanicienFacade.seConnecter(nomUtilisateur, mdp);
    }
    
    public void reviserNavette(Mecanicien mecanicien){
        // récupérer la station
        // récupérer la liste des navettes à réviser
        // réviser la navette
        // supprimer la navette de la liste des navettes à réviser
        Mecanicien mecano = this.mecanicienFacade.find(mecanicien);
        Station stat = mecano.getStationRattachement();
        List<Navette> listeNavettesAReviser = stat.getListeNavettesAReviser();
        if (!listeNavettesAReviser.isEmpty()){
            Navette nav = listeNavettesAReviser.get(0);
            Quai quai = nav.getQuai();
            this.revisionFacade.debuterRevisionNavette(nav, quai, stat, mecanicien);
            this.revisionFacade.cloturerRevisionNavette(nav, quai, stat, mecanicien);
            listeNavettesAReviser.remove(nav);
        }
    }
}
