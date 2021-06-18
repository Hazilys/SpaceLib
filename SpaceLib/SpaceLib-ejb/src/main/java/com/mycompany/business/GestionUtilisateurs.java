/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.business;

import com.mycompany.entities.Mecanicien;
import com.mycompany.entities.Station;
import com.mycompany.entities.Usager;
import com.mycompany.entities.Utilisateur;
import com.mycompany.facades.MecanicienFacadeLocal;
import com.mycompany.facades.UsagerFacadeLocal;
import com.mycompany.facades.UtilisateurFacadeLocal;
import java.util.Calendar;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author AminaDridi
 */
@Stateless
public class GestionUtilisateurs implements GestionUtilisateursLocal {
    
    @EJB
    UtilisateurFacadeLocal utilisateurFacade;
    @EJB
   MecanicienFacadeLocal mecanicienFacade;
    @EJB
    UsagerFacadeLocal usagerFacade;
    
    

    @Override
    public Utilisateur creerUtilisateur(int typeUtilisateur,String nom,String prenom,String nomUtilisateur, String motDePasse) {
        Utilisateur u = null;
        u.setNom(nom);
        u.setPrenom(prenom);
        u.setNomUtilisateur(nomUtilisateur);
        u.setMotDePasse(motDePasse);
         switch(typeUtilisateur) {
                case 1: u = new Usager();                
                case 2: u = new Mecanicien();
        }
         return u;
    }
       

  

    @Override
    public void supprimerUtilisateur(int idUtilisateur) {
        Utilisateur u = this.utilisateurFacade.find(idUtilisateur);
        this.utilisateurFacade.remove(u);
    }

    @Override
    public Usager inscriptionUsager(String nom, String prenom, String nomUtilisateur, String motDePasse, Station localisation) {
        Usager usager = new Usager(); 
        usager.setLocalisation(localisation);
        usager.setMotDePasse(motDePasse);
        usager.setPrenom(prenom);
        usager.setNom(nom);
        usager.setNomUtilisateur(nomUtilisateur);
        usagerFacade.create(usager);
        return usager;
    }

   

    @Override
    public void reserver(Usager usager, int NbPassagers, Station stationArrivee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
