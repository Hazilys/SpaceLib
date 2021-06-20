/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.slshared.utilities;

import java.io.Serializable;

/**
 *
 * @author Camille
 */
public class UtilisateurExport implements Serializable {
    
    private Long idUtilisateur;
    private String nom;
    private String prenom;
    private String nomUtilisateur;
    private String motDePasse;
    
    
    // générer constructeur vide + constructeur avec tous les arguments
    // générer getteurs + setteurs

    public UtilisateurExport() {
    }

    public UtilisateurExport(Long idUtilisateur, String nom, String prenom, String nomUtilisateur, String motDePasse) {
        this.idUtilisateur = idUtilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.nomUtilisateur = nomUtilisateur;
        this.motDePasse = motDePasse;
    }

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    
}
