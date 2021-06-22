/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exposition;

import com.mycompany.entities.Usager;
import java.util.Calendar;
import javax.ejb.Local;

/**
 *
 * @author AminaDridi
 */
@Local
public interface ExpoTestLocal {
    
    public void reserver(Long idUsager, int NbPassagers, Long idStationArrivee, Long idStationDepart, Calendar dateDepart, Calendar dateArrivee);
    
}
