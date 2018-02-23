package domain;

import domain.Gebruiker;
import domain.Kweet;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-23T13:39:36")
@StaticMetamodel(Gebruiker.class)
public class Gebruiker_ { 

    public static volatile SingularAttribute<Gebruiker, String> firstName;
    public static volatile SingularAttribute<Gebruiker, String> lastName;
    public static volatile SingularAttribute<Gebruiker, String> profilePicture;
    public static volatile SingularAttribute<Gebruiker, String> password;
    public static volatile SingularAttribute<Gebruiker, String> website;
    public static volatile ListAttribute<Gebruiker, Gebruiker> following;
    public static volatile SingularAttribute<Gebruiker, String> bio;
    public static volatile ListAttribute<Gebruiker, Kweet> kweets;
    public static volatile SingularAttribute<Gebruiker, String> location;
    public static volatile SingularAttribute<Gebruiker, Long> Id;
    public static volatile SingularAttribute<Gebruiker, String> email;

}