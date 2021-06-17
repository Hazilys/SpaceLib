/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facades;

import com.mycompany.entities.Voyage;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Camille
 */
@Local
public interface VoyageFacadeLocal {

    void create(Voyage voyage);

    void edit(Voyage voyage);

    void remove(Voyage voyage);

    Voyage find(Object id);

    List<Voyage> findAll();

    List<Voyage> findRange(int[] range);

    int count();
    
}