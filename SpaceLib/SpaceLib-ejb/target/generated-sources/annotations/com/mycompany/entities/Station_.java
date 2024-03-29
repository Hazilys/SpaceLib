package com.mycompany.entities;

import com.mycompany.entities.Mecanicien;
import com.mycompany.entities.Navette;
import com.mycompany.entities.Quai;
import com.mycompany.entities.Revision;
import com.mycompany.entities.Usager;
import com.mycompany.entities.Voyage;
import java.util.HashMap;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-20T18:06:28")
@StaticMetamodel(Station.class)
public class Station_ { 

    public static volatile SingularAttribute<Station, Long> idStation;
    public static volatile SingularAttribute<Station, HashMap> distance;
    public static volatile ListAttribute<Station, Voyage> voyages;
    public static volatile ListAttribute<Station, Mecanicien> listeMecaniciens;
    public static volatile SingularAttribute<Station, String> nomStation;
    public static volatile SingularAttribute<Station, String> localisation;
    public static volatile ListAttribute<Station, Usager> listeUsagers;
    public static volatile ListAttribute<Station, Revision> revisions;
    public static volatile ListAttribute<Station, Quai> listeQuais;
    public static volatile ListAttribute<Station, Navette> listeNavettesAReviser;

}