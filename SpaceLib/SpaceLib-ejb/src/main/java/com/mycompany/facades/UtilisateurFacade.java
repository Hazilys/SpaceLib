/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facades;

import com.mycompany.entities.Mecanicien;
import com.mycompany.entities.Station;
import com.mycompany.entities.Usager;
import com.mycompany.entities.Utilisateur;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    
    @Override
    public Utilisateur creerCompte(String nomUtilisateur, String mdp) {
        // TODO
        return null;
    }

    @Override
    public Utilisateur seConnecter(String nomUtilisateur, String mdp) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Utilisateur> cq = cb.createQuery(Utilisateur.class);
        Root<Utilisateur> root = cq.from(Utilisateur.class);
        cq.where(
                cb.and(
                        cb.equal(root.get("nomUtilisateur").as(String.class),nomUtilisateur),
                        cb.equal(root.get("mdp").as(String.class), mdp)) // chiffrement mot de passe à faire si on a du temps                )
        );
        return getEntityManager().createQuery(cq).getSingleResult();
    }
    
    @Override
    public Utilisateur creerUtilisateur(String nom, String prenom, String nomUtilisateur, String motDePasse) {
        Utilisateur u = new Utilisateur();
        u = new Usager();
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
    
}
