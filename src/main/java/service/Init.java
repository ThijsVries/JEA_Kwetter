package service;

import dao.GebruikerDAO;
import dao.KweetDAO;
import domain.Gebruiker;
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
        Gebruiker testGebruiker1 = new Gebruiker("test@mail.com", "12345");
        Gebruiker testGebruiker2 = new Gebruiker("test@mail2.com", "1756745");
        Gebruiker testGebruiker3 = new Gebruiker("test@mail3.com", "12356755");
        Gebruiker testGebruiker4 = new Gebruiker("test@mail4.com", "1223423445");
        Gebruiker testGebruiker5 = new Gebruiker("test@mail5.com", "122445");
        
        gebruikerDAO.addGebruiker(testGebruiker1);
        gebruikerDAO.addGebruiker(testGebruiker2);
        gebruikerDAO.addGebruiker(testGebruiker3);
        gebruikerDAO.addGebruiker(testGebruiker4);
        
        testGebruiker5.makeFollow(testGebruiker1);
        testGebruiker5.makeFollow(testGebruiker2);
        testGebruiker4.makeFollow(testGebruiker3);
        testGebruiker2.makeFollow(testGebruiker2);
        gebruikerDAO.addGebruiker(testGebruiker5);
        
//        kweetDAO
//        kweetDAO.createKweet(new Kweet(2, "Hello world"));
//        kweetDAO.createKweet(new Kweet(3, "Swagg"));
//        List<Kweet> kweetsGebruiker1 = kweetDAO.getGebruikerKweets("test@mail.com", 20);
//        kweetsGebruiker1.get(0).like(testGebruiker5);
//        
//        List<Kweet> kweets = kweetDAO.getGebruikerKweets(testGebruiker5.getEmail(), 20);
//        
//        kweets.get(0).like(testGebruiker3);
//        kweetDAO.updateKweet(kweets.get(0));
    }
}
