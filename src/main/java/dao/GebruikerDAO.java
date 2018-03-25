package dao;

import domain.Gebruiker;
import domain.GebruikerGroup;
import java.util.List;


public interface GebruikerDAO {
    
    //TODO make bools void and catch exceptions in the service layer
    void addGebruiker(Gebruiker gebruiker);
    
    void updateGebruiker(Gebruiker gebruiker);
    
    void deleteGebruiker(Gebruiker gebruiker);
    
    List<Gebruiker> getAllGebruikers();
    
    List<Gebruiker> getGebruikerFollowers(String email);
    
    List<Gebruiker> getGebruikerByEmail(String email);
    
    List<Gebruiker> getGebruikerByName(String firstName);
    
    void addGebruikerGroup(GebruikerGroup gebruikerGroup);
    
    void updateGebruikerGroup(GebruikerGroup gebruikerGroup);
    
    GebruikerGroup getGebruikerGroup(String groupName);
    
    List<GebruikerGroup> getAllGebruikerGroups();
    
}
