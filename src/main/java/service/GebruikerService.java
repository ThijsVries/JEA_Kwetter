package service;

import dao.GebruikerDAO;
import domain.Gebruiker;
import domain.GebruikerGroup;
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
    
    
    public void followGebruiker(Gebruiker gebruiker, Gebruiker gebruikerToFollow){
        gebruiker.makeFollow(gebruikerToFollow);
        updateGebruiker(gebruiker);
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
    
    public List<Gebruiker> getGebruikerFollowers(String email){
        try{
            return gebruikerDAO.getGebruikerFollowers(email);
        } catch(PersistenceException pe){
            LOGGER.log(Level.FINE, "ERROR while performing addGebruiker method; {0}", pe.getMessage());
            return null;
        }
    }
    
    public List<Gebruiker> getAllGebruikers(){
        try{
            return gebruikerDAO.getAllGebruikers();
        } catch(PersistenceException pe){
            LOGGER.log(Level.FINE, "ERROR while performing getAllGebruikers method; {0}", pe.getMessage());
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
    
    public void updateGebruikerGroup(GebruikerGroup gebruikerGroup){
        try{
            gebruikerDAO.updateGebruikerGroup(gebruikerGroup);
        } catch(PersistenceException pe){
            LOGGER.log(Level.FINE, "ERROR while performing updateGebruikerGroup method; {0}", pe.getMessage());
        }
    }
    
    public GebruikerGroup getGebruikerGroup(String groupName){
        try{
            return gebruikerDAO.getGebruikerGroup(groupName);
        } catch(PersistenceException pe){
            LOGGER.log(Level.FINE, "ERROR while performing getGebruikerGroup method; {0}", pe.getMessage());
            return null;
        }
    }
    
    public List<GebruikerGroup> getAllGebruikerGroups(){
        try{
            return gebruikerDAO.getAllGebruikerGroups();
        } catch(PersistenceException pe){
            LOGGER.log(Level.FINE, "ERROR while performing getAllGebruikerGroups method; {0}", pe.getMessage());
            return null;
        }
    }
}
