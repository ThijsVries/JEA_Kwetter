package service;

import dao.GebruikerDAO;
import dao.KweetDAO;
import domain.Gebruiker;
import domain.GebruikerGroup;
import domain.Kweet;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Startup
@Singleton
public class Init {
    
    @Inject
    GebruikerDAO gebruikerDAO;
    
    @Inject
    KweetDAO kweetDAO;
    
    @PostConstruct
    public void init(){
        
        GebruikerGroup gebruikerGroupAdmin = new GebruikerGroup("Admin");
        GebruikerGroup gebruikerGroupUser = new GebruikerGroup("User");
        GebruikerGroup gebruikerGroupMod = new GebruikerGroup("Moderator");
        
        Gebruiker testGebruiker1 = new Gebruiker("Jan", "Pietersen", "jantje@mail.com", "Z:/janjteheeftswag.png", "123456789", "Ik ben Jantjuuuuh", "www.reddit.com", "Eindhoven");
        Gebruiker testGebruiker2 = new Gebruiker("Mary-Jane", "Sensi", "damail@mail.jm", "Z:/plants.png", "420erryday", "Sup people", "www.reddit.com/r/trees", "Everywhere?");
        Gebruiker testGebruiker3 = new Gebruiker("Ka hing", "Wong", "kahing@mail.com", "Z:/china_flag.png", "13371337", "mr. Wong", "fhict.nl", "Den Bosch");
        Gebruiker testGebruiker4 = new Gebruiker("Nicole", "Pietersen", "nico@mail.com", "Z:/janjteheeftswag.png", "123456789", "Ik ben Jantjuuuuh", "www.reddit.com", "Eindhoven");
        Gebruiker testGebruiker6 = new Gebruiker("Thijs", "Vries", "thijs@mail.com", "Z:/admin", "admin", "admin", "www.reddit.com", "Den Bosch");
        Gebruiker testGebruiker5 = new Gebruiker("Karel", "Peter", "karel@mail.com", "Z:/admin", "karel", "karel", "www.reddit.com", "Den Bosch");
        
        
        testGebruiker6.addGebruikerGroup(gebruikerGroupAdmin);
        testGebruiker5.addGebruikerGroup(gebruikerGroupAdmin);
        testGebruiker1.addGebruikerGroup(gebruikerGroupAdmin);
        
        gebruikerDAO.addGebruikerGroup(gebruikerGroupAdmin);
        gebruikerDAO.addGebruikerGroup(gebruikerGroupMod);
        gebruikerDAO.addGebruikerGroup(gebruikerGroupUser);
        
        testGebruiker1.makeFollow(testGebruiker5);
        testGebruiker1.makeFollow(testGebruiker6);
        
        gebruikerDAO.addGebruiker(testGebruiker1);
        gebruikerDAO.addGebruiker(testGebruiker2);
        gebruikerDAO.addGebruiker(testGebruiker3);
        gebruikerDAO.addGebruiker(testGebruiker4);
        gebruikerDAO.addGebruiker(testGebruiker6);
        
        
        testGebruiker5.makeFollow(testGebruiker1);
        testGebruiker5.makeFollow(testGebruiker2);
        testGebruiker4.makeFollow(testGebruiker3);
        testGebruiker2.makeFollow(testGebruiker1);

        gebruikerDAO.addGebruiker(testGebruiker5);
        
        Gebruiker managedGebruiker = gebruikerDAO.getGebruikerByEmail("damail@mail.jm").get(0);
        kweetDAO.createKweet((int)managedGebruiker.getId(), "Dit is een test kweet");
        
        Gebruiker managedGebruiker2 = gebruikerDAO.getGebruikerByEmail("kahing@mail.com").get(0);
        kweetDAO.createKweet((int)managedGebruiker2.getId(), "Dit is ook een test kweet");
        kweetDAO.createKweet((int)managedGebruiker2.getId(), "Dit is ook een test kweet 2.0");
        
        Gebruiker managedGebruiker3 = gebruikerDAO.getGebruikerByEmail("jantje@mail.com").get(0);
        kweetDAO.createKweet((int)managedGebruiker3.getId(), "Hallo wereld");
        kweetDAO.createKweet((int)managedGebruiker3.getId(), "Hello world");
    }
}
