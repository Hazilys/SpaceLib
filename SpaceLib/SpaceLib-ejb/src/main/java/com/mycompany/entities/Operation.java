/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Camille
 */
@Entity
public class Operation implements Serializable {

    

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idOperations;
    @NotNull
    private Calendar dateCreationOperation;
    @ManyToOne
    private Utilisateur utilisateur;
    @ManyToOne
    private Navette idNavette;

      
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOperations != null ? idOperations.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idOperations fields are not set
        if (!(object instanceof Operation)) {
            return false;
        }
        Operation other = (Operation) object;
        if ((this.idOperations == null && other.idOperations != null) || (this.idOperations != null && !this.idOperations.equals(other.idOperations))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entities.Operations[ id=" + idOperations + " ]";
    }
    
}
