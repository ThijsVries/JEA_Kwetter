package domain;

import domain.Gebruiker;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-27T17:00:59")
@StaticMetamodel(GebruikerGroup.class)
public class GebruikerGroup_ { 

    public static volatile SingularAttribute<GebruikerGroup, String> groupName;
    public static volatile ListAttribute<GebruikerGroup, Gebruiker> gebruikers;

}