/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ws;

import com.mycompany.entities.Navette;
import com.mycompany.entities.Station;
import com.mycompany.entities.Utilisateur;
import com.mycompany.exposition.ExpoLegLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author AminaDridi
 */
@WebService(serviceName = "WSMeca")
public class WSMeca {

    @EJB
    private ExpoLegLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "seConnecter")
    @Oneway
    public void seConnecter(@WebParam(name = "nomUtilisateur") String nomUtilisateur, @WebParam(name = "mdp") String mdp) {
        ejbRef.seConnecter(nomUtilisateur, mdp);
    }

    @WebMethod(operationName = "revisionNavetteMecanicine")
    @Oneway
    public void revisionNavetteMecanicine(@WebParam(name = "id") String id, @WebParam(name = "idNavette") String idNavette, @WebParam(name = "idQuai") String idQuai, @WebParam(name = "choix") int choix) {
        Long idS = Long.parseLong(id);
        Long idN = Long.parseLong(idNavette);
        Long idQ = Long.parseLong(idQuai);
        ejbRef.revisionNavetteMecanicine(idS, idN, idQ, choix);
    }

    @WebMethod(operationName = "creerMecanicien")
    public Utilisateur creerMecanicien(@WebParam(name = "nom") String nom, @WebParam(name = "prenom") String prenom, @WebParam(name = "nomUtilisateur") String nomUtilisateur, @WebParam(name = "motDePasse") String motDePasse, @WebParam(name = "station") Station station) {
        return ejbRef.creerMecanicien(nom, prenom, nomUtilisateur, motDePasse, station);
    }

    @WebMethod(operationName = "getNavette")
    public List<Navette> getNavette(@WebParam(name = "idStation") String idStation) {
        Long id = Long.parseLong(idStation);
        return ejbRef.getNavette(id);
    }

    @WebMethod(operationName = "getNavetteReparation")
    public List<Navette> getNavetteReparation(@WebParam(name = "idStation") String idStation) {
        Long id = Long.parseLong(idStation);
        return ejbRef.getNavetteReparation(id);
    }
    
}
