/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facades;

import com.mycompany.entities.Station;
import com.mycompany.entities.Usager;
import com.mycompany.entities.Voyage;
import java.util.Calendar;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Camille
 */
@Local
public interface UsagerFacadeLocal {
    
    void resever(Usager emprunteur, int NbPassagers, Station stationDepart, Station stationArrivee, Calendar dateDepart, Calendar dateArrivee);

    void create(Usager usager);

    void edit(Usager usager);

    void remove(Usager usager);

    Usager find(Object id);

    List<Usager> findAll();

    List<Usager> findRange(int[] range);

    int count();
    
}
