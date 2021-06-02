package com.mycompany.entities;

import com.mycompany.entities.ETATREVISION;
import com.mycompany.entities.Mecanicien;
import com.mycompany.entities.Navette;
import com.mycompany.entities.Station;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-02T16:00:23")
@StaticMetamodel(Revision.class)
public class Revision_ extends Operation_ {

    public static volatile SingularAttribute<Revision, ETATREVISION> etatRevision;
    public static volatile SingularAttribute<Revision, Mecanicien> mecanicien;
    public static volatile SingularAttribute<Revision, Station> station;
    public static volatile ListAttribute<Revision, Navette> listeNavettesAReviser;

}