/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ws;

import com.mycompany.entities.NBPLACES;
import com.mycompany.entities.Station;
import com.mycompany.entities.Utilisateur;
import com.mycompany.exposition.ExpoAdminLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author AminaDridi
 */
@WebService(serviceName = "WSAdmin")
public class WSAdmin {
    
    

    @EJB
    private ExpoAdminLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "creerAdmin")
    public Utilisateur creerAdmin(@WebParam(name = "nom") String nom, @WebParam(name = "prenom") String prenom, @WebParam(name = "nomUtilisateur") String nomUtilisateur, @WebParam(name = "motDePasse") String motDePasse) {
        return ejbRef.creerAdmin(nom, prenom, nomUtilisateur, motDePasse);
    }

    @WebMethod(operationName = "creerStation")
    public Station creerStation(@WebParam(name = "nom") String nom,@WebParam(name = "localisation") String localisation, @WebParam(name = "nbQuai") int nbQuai, @WebParam(name = "nbPlace") String nbPlace) {
        List<Integer> nbPlaces = new ArrayList<Integer>();
        String[] nbPlacesListe = nbPlace.split(";");
        for (String nb : nbPlacesListe) {
            int n = Integer.parseInt(nb);
            nbPlaces.add(n);
        }
        return ejbRef.creerStation(nom,localisation, nbQuai, nbPlaces);
    }

    @WebMethod(operationName = "seConnecter")
    public Utilisateur seConnecter(@WebParam(name = "nomUtilisateur") String nomUtilisateur, @WebParam(name = "mdp") String mdp) {
        return ejbRef.seConnecter(nomUtilisateur, mdp);
    }
    
}
