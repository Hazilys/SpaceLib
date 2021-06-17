package com.mycompany.entities;

import com.mycompany.entities.Revision;
import com.mycompany.entities.Station;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-17T16:46:18")
@StaticMetamodel(Mecanicien.class)
public class Mecanicien_ extends Utilisateur_ {

    public static volatile ListAttribute<Mecanicien, Revision> revisions;
    public static volatile SingularAttribute<Mecanicien, Station> stationRattachement;

}