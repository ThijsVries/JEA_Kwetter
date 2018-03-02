package service;

import dao.GebruikerDAO;
import domain.Gebruiker;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;

@Stateless
public class GebruikerService {
    
    //TODO Add JavaDoc
    @Inject
    GebruikerDAO gebruikerDAO;
    
    private static final Logger LOGGER = Logger.getLogger(GebruikerService.class.getName());
    
    public GebruikerService(){
        
    }
    
    public void addGebruiker(Gebruiker gebruiker){
        try{
            gebruikerDAO.addGebruiker(gebruiker);
        } catch(PersistenceException pe){
            LOGGER.log(Level.FINE, "ERROR while performing addGebruiker method; {0}", pe.getMessage());
        }
    }
    
    public void updateGebruiker(Gebruiker gebruiker){
        try{
            gebruikerDAO.updateGebruiker(gebruiker);
        } catch(PersistenceException pe){
            LOGGER.log(Level.FINE, "ERROR while performing updateGebruiker method; {0}", pe.getMessage());
        }
    }
    
    public void deleteGebruiker(Gebruiker gebruiker){
        try{
            gebruikerDAO.deleteGebruiker(gebruiker);
        } catch(PersistenceException pe){
            LOGGER.log(Level.FINE, "ERROR while performing addGebruiker method; {0}", pe.getMessage());
        }
    }
    
    public List<Gebruiker> getGebruikerByEmail(String email){
        try{
            return gebruikerDAO.getGebruikerByEmail(email);
        } catch(PersistenceException pe){
            LOGGER.log(Level.FINE, "ERROR while performing addGebruiker method; {0}", pe.getMessage());
            return null;
        }
    }
    
    public List<Gebruiker> getGebruikerFollowers(int id){
        try{
            return gebruikerDAO.getGebruikerFollowers(id);
        } catch(PersistenceException pe){
            LOGGER.log(Level.FINE, "ERROR while performing addGebruiker method; {0}", pe.getMessage());
            return null;
        }
    }
    
    public List<Gebruiker> getGebruikerByName(String firstName){
        try{
            return gebruikerDAO.getGebruikerByName(firstName);
        } catch(PersistenceException pe){
            LOGGER.log(Level.FINE, "ERROR while performing addGebruiker method; {0}", pe.getMessage());
            return null;
        }
    }
}