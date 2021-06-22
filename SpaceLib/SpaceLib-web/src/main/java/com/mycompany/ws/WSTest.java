/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ws;

import com.mycompany.exposition.ExpoTestLocal;
import java.util.Calendar;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author AminaDridi
 */
@WebService(serviceName = "WSTest")
public class WSTest {

    @EJB
    private ExpoTestLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "reserver")
    @Oneway
    public void reserver(@WebParam(name = "idUsager") String idUsager, @WebParam(name = "NbPassagers") int NbPassagers, @WebParam(name = "idStationArrivee") String idStationArrivee, @WebParam(name = "idStationDepart") String idStationDepart, @WebParam(name = "dateDepart") Calendar dateDepart, @WebParam(name = "dateArrivee") Calendar dateArrivee) {
        Long idU = Long.parseLong(idUsager);
        Long iSA = Long.parseLong(idStationArrivee);
        Long iSD = Long.parseLong(idStationDepart);
        ejbRef.reserver(idU, NbPassagers, iSA, iSD, dateDepart, dateArrivee);
    }
    
}
