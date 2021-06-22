/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

/**
 *
 * @author Camille
 */
public enum NBPLACES {
    DEUX(2), CINQ(5), DIX(10), QUINZE(15);
    
    private int valeur;
    
    private NBPLACES(int valeur){
        this.valeur = valeur;
    }
    
    public int getValeur(){
        return this.valeur;
    }
    
    public int setNbPlace(int nb) {
        return this.valeur = valeur;
    }
    
}
