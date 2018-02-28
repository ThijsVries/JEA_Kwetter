package dao;

import domain.Gebruiker;
import java.util.List;


public interface GebruikerDAO {
    
    boolean addGebruiker(Gebruiker gebruiker);
    
    boolean updateGebruiker(Gebruiker gebruiker);
    
    List<Gebruiker> getGebruikerFollowers(int id);
    
    Gebruiker findGebruikerById(int id);
    
}
