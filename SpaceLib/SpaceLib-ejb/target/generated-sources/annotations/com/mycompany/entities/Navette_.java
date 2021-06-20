package com.mycompany.entities;

import com.mycompany.entities.NBPLACES;
import com.mycompany.entities.Operation;
import com.mycompany.entities.Quai;
import com.mycompany.entities.Revision;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-20T10:43:27")
@StaticMetamodel(Navette.class)
public class Navette_ { 

    public static volatile SingularAttribute<Navette, Integer> nbVoyagesTotal;
    public static volatile SingularAttribute<Navette, NBPLACES> nbPlaces;
    public static volatile SingularAttribute<Navette, Long> idNavette;
    public static volatile SingularAttribute<Navette, Quai> quai;
    public static volatile ListAttribute<Navette, Revision> revisions;
    public static volatile ListAttribute<Navette, Operation> listeOperations;
    public static volatile SingularAttribute<Navette, Boolean> disponible;

}