package com.mycompany.entities;

import com.mycompany.entities.Station;
import com.mycompany.entities.Voyage;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-20T12:25:32")
@StaticMetamodel(Usager.class)
public class Usager_ extends Utilisateur_ {

    public static volatile ListAttribute<Usager, Voyage> voyages;
    public static volatile SingularAttribute<Usager, Station> localisation;

}