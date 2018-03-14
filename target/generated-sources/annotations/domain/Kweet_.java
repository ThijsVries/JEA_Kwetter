package domain;

import domain.Gebruiker;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-14T11:22:15")
@StaticMetamodel(Kweet.class)
public class Kweet_ { 

    public static volatile SingularAttribute<Kweet, Date> date;
    public static volatile SingularAttribute<Kweet, Long> id;
    public static volatile SingularAttribute<Kweet, String> message;
    public static volatile ListAttribute<Kweet, Gebruiker> mentioned;
    public static volatile SingularAttribute<Kweet, Gebruiker> ownedBy;
    public static volatile SingularAttribute<Kweet, List> tags;
    public static volatile ListAttribute<Kweet, Gebruiker> likes;

}