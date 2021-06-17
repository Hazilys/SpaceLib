/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facades;

import com.mycompany.entities.Mecanicien;
import com.mycompany.entities.Navette;
import com.mycompany.entities.Quai;
import com.mycompany.entities.Station;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Camille
 */
@Local
public interface MecanicienFacadeLocal {
    
    void seConnecter(String nomUtilisateur, String mdp);
    
    void debuterRevisionNavette(Navette navette, Quai quai, Station station);
    
    void cloturerRevisionNavette(Navette navette, Quai quai, Station station);

    void create(Mecanicien mecanicien);

    void edit(Mecanicien mecanicien);

    void remove(Mecanicien mecanicien);

    Mecanicien find(Object id);

    List<Mecanicien> findAll();

    List<Mecanicien> findRange(int[] range);

    int count();
    
}
