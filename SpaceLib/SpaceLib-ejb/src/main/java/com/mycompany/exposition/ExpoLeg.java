/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exposition;

import com.mycompany.entities.Mecanicien;
import com.mycompany.metier.MetierMecanicienLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Camille
 */
@Stateless
public class ExpoLeg implements ExpoLegLocal {

    @EJB
    private MetierMecanicienLocal metierMecanicien;

    @Override
    public void seConnecter(String nomUtilisateur, String mdp) {
        this.metierMecanicien.seConnecter(nomUtilisateur, mdp);
    }

    @Override
    public void reviserNavette(Mecanicien mecanicien) {
        this.metierMecanicien.reviserNavette(mecanicien);
    }
}
