package dao;

import domain.Gebruiker;
import java.util.List;


public interface GebruikerDAO {
    
    //TODO make bools void and catch exceptions in the service layer
    void addGebruiker(Gebruiker gebruiker);
    
    void updateGebruiker(Gebruiker gebruiker);
    
    void deleteGebruiker(Gebruiker gebruiker);
    
    List<Gebruiker> getGebruikerFollowers(int id);
    
    List<Gebruiker> getGebruikerByEmail(String email);
    
    List<Gebruiker> getGebruikerByName(String firstName);
    
}
