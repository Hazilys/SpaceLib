package com.mycompany.entities;

import com.mycompany.entities.ETATVOYAGE;
import com.mycompany.entities.Station;
import com.mycompany.entities.Usager;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-02T16:00:23")
@StaticMetamodel(Voyage.class)
public class Voyage_ extends Operation_ {

    public static volatile SingularAttribute<Voyage, Station> stationDepart;
    public static volatile SingularAttribute<Voyage, Usager> emprunteur;
    public static volatile SingularAttribute<Voyage, ETATVOYAGE> etatVoyage;
    public static volatile SingularAttribute<Voyage, Calendar> dateArrivee;
    public static volatile SingularAttribute<Voyage, Station> stationArrivee;
    public static volatile SingularAttribute<Voyage, Calendar> dateDepart;
    public static volatile SingularAttribute<Voyage, Integer> nbPassagers;

}