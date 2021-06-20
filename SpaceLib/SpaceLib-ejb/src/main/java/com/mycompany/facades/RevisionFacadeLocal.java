/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.facades;

import com.mycompany.entities.Mecanicien;
import com.mycompany.entities.Navette;
import com.mycompany.entities.Quai;
import com.mycompany.entities.Revision;
import com.mycompany.entities.Station;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Camille
 */

@Local
public interface RevisionFacadeLocal {
    
    public void creatRevisionForNavette(Navette navette, Station station);
    
    void debuterRevisionNavette(Navette navette, Quai quai, Station station, Mecanicien mecanicien);
    
    void cloturerRevisionNavette(Navette navette, Quai quai, Station station, Mecanicien mecanicien);
    
    List<Navette> getListeNavettesAReviser();

    void create(Revision revision);

    void edit(Revision revision);

    void remove(Revision revision);

    Revision find(Object id);

    List<Revision> findAll();

    List<Revision> findRange(int[] range);

    int count();
    
    
}
