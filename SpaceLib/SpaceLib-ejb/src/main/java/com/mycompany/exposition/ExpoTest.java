/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exposition;

import com.mycompany.business.GestionUtilisateursLocal;
import com.mycompany.entities.Usager;
import java.util.Calendar;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author AminaDridi
 */
@Stateless
public class ExpoTest implements ExpoTestLocal {

    @EJB
    GestionUtilisateursLocal gestionUtilisateurs;
    
    
    @Override
    public void reserver(Long idUsager, int NbPassagers, Long idStationArrivee, Long idStationDepart, Calendar dateDepart, Calendar dateArrivee) {
        this.gestionUtilisateurs.reserver(idUsager,NbPassagers, idStationArrivee, idStationDepart, dateDepart, dateArrivee);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
