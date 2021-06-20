/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sllrd;

import com.mycompany.interfremote.ExpoLrdRemote;
import com.mycompany.slshared.utilities.StationExport;
import com.mycompany.slshared.utilities.UsagerExport;
import com.mycompany.slshared.utilities.UtilisateurExport;
import java.util.GregorianCalendar;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Scanner;
import java.util.List;

/**
 *
 * @author Camille
 */
public class Main {
    
    public static void main(String[] args) throws NamingException{
        // 1 : lookup objet
        Context ctx = new InitialContext();
        ExpoLrdRemote borneResa = (ExpoLrdRemote) ctx.lookup("com.mycompany.interfremote.ExpoLrdRemote");
        
        StationExport stationDepart = new StationExport(new Long(123), "NomStation", "Terre");
        UsagerExport ue = null;
   
        System.out.println("Bienvenue à la borne de réservation");
        boolean session = false;
        
        do {
            System.out.println("\n---- MENU ----");
            System.out.println("1 - S'enregistrer au sein de SpaceLib");
            System.out.println("2 - Se connecter");
            System.out.println("3 - Réserver une navette et voyager");
            System.out.println("4 - Quitter");

            System.out.print("Saisissez le numéro de votre choix : ");
            Scanner clavier = new Scanner(System.in);
            String choix = clavier.nextLine();
            System.out.print("\n");
            
            switch(choix){
            case "1":
                System.out.print("\nSaisissez votre nom : ");
                String nom = clavier.nextLine();
                System.out.print("\nSaisissez votre prénom : ");
                String prenom = clavier.nextLine();
                System.out.print("\nSaisissez votre nom d'utilisateur : ");
                String nomUtil = clavier.nextLine();
                System.out.print("\nSaisissez votre mot de passe : ");
                String mdp = clavier.nextLine();
                UtilisateurExport us = borneResa.creerUtilisateur(1, nom, prenom, nomUtil, mdp);
                System.out.print("\nFélicitations, vous êtes désormais enregistré au sein de SpaceLib !");
                System.out.println("Util : "+us.getNom()+" "+us.getPrenom());
            case "2":
                System.out.print("\nSaisissez votre nom d'utilisateur : ");
                String nomUtilC = clavier.nextLine();
                System.out.print("\nSaisissez votre mot de passe : ");
                String mdpC = clavier.nextLine();
                UtilisateurExport util = borneResa.seConnecter(nomUtilC, mdpC);
                // StationExport localisation, Long idUtilisateur, String nom, String prenom, String nomUtilisateur, String motDePasse
                ue = new UsagerExport(stationDepart, util.getIdUtilisateur(), util.getNom(), util.getPrenom(), util.getNomUtilisateur(), util.getMotDePasse());
                break;
            case "3":
                if (ue==null){
                    System.out.print("\nMerci de vous authentifier d'abord");
                } else {
                    System.out.print("\nPour combien de personnes souhaitez-vous résever : ");
                    int nbPassagers = clavier.nextInt();
                    System.out.print("\nOù souhaitez-vous allez :\n");
                    List<StationExport> listeStations = borneResa.getListeStations();
                    for(StationExport se : listeStations){
                        System.out.println(se.getIdStation()+" - "+se.getNomStation());
                    }
                    System.out.print("Recopiez l'identifiant de la station choisie (attention aux erreurs de frappe !) : ");
                    Long choix2 = clavier.nextLong();
                    StationExport stationArrivee = borneResa.getStationByNom(choix2);
                    borneResa.reserver(ue, nbPassagers, stationDepart, stationArrivee, new GregorianCalendar(), new GregorianCalendar());
                }
                break;
            case "4":
                session = true;
            default:
                System.out.println("Votre saisie n'est pas correcte");
            }
            
        } while(!session);
        
        
    }
}
