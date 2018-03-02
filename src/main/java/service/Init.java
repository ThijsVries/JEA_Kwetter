package service;

import dao.GebruikerDAO;
import domain.Gebruiker;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Startup
@Singleton
public class Init {
    
    @Inject
    GebruikerDAO gebruikerDAO;
    
    @PostConstruct
    public void init(){
        Gebruiker testGebruiker1 = new Gebruiker("test@mail.com", "12345");
        Gebruiker testGebruiker2 = new Gebruiker("test@mail2.com", "1756745");
        Gebruiker testGebruiker3 = new Gebruiker("test@mail3.com", "12356755");
        Gebruiker testGebruiker4 = new Gebruiker("test@mail4.com", "1223423445");
        Gebruiker testGebruiker5 = new Gebruiker("test@mail5.com", "122445");
        
        gebruikerDAO.addGebruiker(testGebruiker1);
        gebruikerDAO.addGebruiker(testGebruiker4);
        gebruikerDAO.addGebruiker(testGebruiker5);
    }
}
