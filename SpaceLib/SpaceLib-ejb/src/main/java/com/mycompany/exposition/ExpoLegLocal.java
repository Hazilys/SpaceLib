/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exposition;

import com.mycompany.entities.Mecanicien;
import javax.ejb.Local;

/**
 *
 * @author Camille
 */
@Local
public interface ExpoLegLocal {
   
    void seConnecter(String nomUtilisateur, String mdp);
    
    void reviserNavette(Mecanicien mecanicien);
}
