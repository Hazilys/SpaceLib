package com.mycompany.entities;

import com.mycompany.entities.Navette;
import com.mycompany.entities.Quai;
import com.mycompany.entities.Utilisateur;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-20T12:25:32")
@StaticMetamodel(Operation.class)
public class Operation_ { 

    public static volatile SingularAttribute<Operation, Navette> navette;
    public static volatile SingularAttribute<Operation, Calendar> dateCreationOperation;
    public static volatile SingularAttribute<Operation, Utilisateur> utilisateur;
    public static volatile SingularAttribute<Operation, Long> idOperation;
    public static volatile SingularAttribute<Operation, Quai> quai;

}