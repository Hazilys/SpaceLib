package com.mycompany.entities;

import com.mycompany.entities.Navette;
import com.mycompany.entities.Operation;
import com.mycompany.entities.Revision;
import com.mycompany.entities.Station;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-20T12:25:32")
@StaticMetamodel(Quai.class)
public class Quai_ { 

    public static volatile SingularAttribute<Quai, Boolean> occupe;
    public static volatile SingularAttribute<Quai, Navette> navette;
    public static volatile SingularAttribute<Quai, Long> idQuai;
    public static volatile SingularAttribute<Quai, Station> station;
    public static volatile ListAttribute<Quai, Revision> revisions;
    public static volatile ListAttribute<Quai, Operation> listeOperations;

}