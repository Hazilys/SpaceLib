/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facades;

import com.mycompany.entities.Utilisateur;
import com.mycompany.entities.Quai;
import com.mycompany.entities.Station;
import com.mycompany.entities.Navette;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Camille
 */
@Local
public interface UtilisateurFacadeLocal {
    
    void seConnecter(String nomUtilisateur, String mdp);

    void create(Utilisateur utilisateur);

    void edit(Utilisateur utilisateur);

    void remove(Utilisateur utilisateur);

    Utilisateur find(Object id);

    List<Utilisateur> findAll();

    List<Utilisateur> findRange(int[] range);

    int count();
    
}