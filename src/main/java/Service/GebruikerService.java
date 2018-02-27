package Service;

import dao.GebruikerDAO;
import dao.KweetDAO;
import domain.Gebruiker;
import domain.Kweet;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Startup
@Singleton
public class GebruikerService {

    @Inject
    GebruikerDAO gebruikerDAO;
    
    @PostConstruct
    public void insertGebruikers(){
        Gebruiker testGebruiker = new Gebruiker("test@mail.com", "1337");
        Gebruiker testGebruiker2 = new Gebruiker("test2@mail.com", "073");
        Gebruiker testGebruiker3 = new Gebruiker("test33@mail.com", "234235");
        
        gebruikerDAO.addGebruiker(testGebruiker);
        gebruikerDAO.addGebruiker(testGebruiker2);
        gebruikerDAO.addGebruiker(testGebruiker3);
    }
}
