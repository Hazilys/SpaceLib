/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facades;

import com.mycompany.entities.Admin;
import com.mycompany.entities.Mecanicien;
import com.mycompany.entities.Station;
import com.mycompany.entities.Usager;
import com.mycompany.entities.Utilisateur;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Camille
 */
@Stateless
public class UtilisateurFacade extends AbstractFacade<Utilisateur> implements UtilisateurFacadeLocal {

    @PersistenceContext(unitName = "SpaceLibPersistenceUnit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UtilisateurFacade() {
        super(Utilisateur.class);
    }
    
    private void editUtilisateur(String nom, String prenom, String nomUtilisateur, String motDePasse) {
        
    }
    
    @Override
    public Utilisateur creerUsager(String nom, String prenom, String nomUtilisateur, String motDePasse) {
        Utilisateur u = new Usager();
        u.setNom(nom);
        u.setPrenom(prenom);
        u.setNomUtilisateur(nomUtilisateur);
        u.setMotDePasse(motDePasse);
        this.create(u);
        return u;
    }
    
    @Override
    public Utilisateur creerMecanicien(String nom, String prenom, String nomUtilisateur, String motDePasse, Station station) {
        Utilisateur u = new Mecanicien();
        u = new Mecanicien();
        u.setNom(nom);
        u.setPrenom(prenom);
        u.setNomUtilisateur(nomUtilisateur);
        u.setMotDePasse(motDePasse);
        this.create(u);
        return u;
    }

    @Override
    public Utilisateur seConnecter(String nomUtilisateur, String motDePasse) {
    Utilisateur utilisateur = null;
		Query query = em.createQuery("select u from Utilisateur u where u.nomUtilisateur=:nomUtilisateur and u.motDePasse=:motDePasse");
		query.setParameter("nomUtilisateur", nomUtilisateur).setParameter("motDePasse", motDePasse);
		try {
			utilisateur = (Utilisateur) query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Erreur de connection ");
		}
		return utilisateur;
    }

    @Override
    public Utilisateur creerAdmin(String nom, String prenom, String nomUtilisateur, String motDePasse) {
        Utilisateur u = new Admin();
        u.setNom(nom);
        u.setPrenom(prenom);
        u.setNomUtilisateur(nomUtilisateur);
        u.setMotDePasse(motDePasse);
        this.create(u);
        return u;
    }

    
}
