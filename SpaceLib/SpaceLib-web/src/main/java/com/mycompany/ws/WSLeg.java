/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ws;

import com.mycompany.entities.Mecanicien;
import com.mycompany.exposition.ExpoLegLocal;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Camille
 */
@WebService(serviceName = "WSLeg")
public class WSLeg {

    @EJB
    private ExpoLegLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "seConnecter")
    @Oneway
    public void seConnecter(@WebParam(name = "nomUtilisateur") String nomUtilisateur, @WebParam(name = "mdp") String mdp) {
        ejbRef.seConnecter(nomUtilisateur, mdp);
    }

    @WebMethod(operationName = "reviserNavette")
    @Oneway
    public void reviserNavette(@WebParam(name = "mecanicien") Mecanicien mecanicien) {
        ejbRef.reviserNavette(mecanicien);
    }
    
}
