package service;

import dao.KweetDAO;
import domain.Gebruiker;
import domain.Kweet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;

@Stateless
public class KweetService {
    
    @Inject
    KweetDAO kweetDAO;
    
    private static final Logger LOGGER = Logger.getLogger(KweetService.class.getName());
    
    public KweetService(){
        
    }
    
    /**
     * Gets the kweet with the matching id parameter, if no kweet is found this method returns null.
     * @param id the id of the requested kweet.
     * @return the kweet object, if found.
     */
    public List<Kweet> getKweet(int id){
        try{
            return kweetDAO.getKweet(id);
        } catch(PersistenceException pe){
            LOGGER.log(Level.FINE, "ERROR while performing getKweet method; {0}", pe.getMessage());
            return null;
        }
    }
    
    /**
     * Gets all of the recent kweets, limited by the limit parameter.
     * @param limit The limited amount of kweets to be returned.
     * @return A list of all returned kweets.
     */
    public List<Kweet> getRecentKweets(int limit){
        try{
            return kweetDAO.getRecentKweets(limit);
        } catch(PersistenceException pe){
            LOGGER.log(Level.FINE, "ERROR while performing getRecentKweets method; {0}", pe.getMessage());
            return null;
        }
    }
    
    /**
     * Gets all of the recent kweets from a specified by Gebruiker parameter and limited to limit parameter.
     * @param gebruiker The gebruiker whoms kweets are requested.
     * @param limit The limited amount of kweets to be returned.
     * @return A list of all return kweets from this gebruiker.
     */
    public List<Kweet> getGebruikerKweets(String email, int limit){
        try{
            return kweetDAO.getGebruikerKweets(email, limit);
        } catch(PersistenceException pe){
            LOGGER.log(Level.FINE, "ERROR while performing getGebruikerkweets method; {0}", pe.getMessage());
            return null;
        }
    }
    
    public List<Kweet> getGebruikerKweetsById(int id, int limit){
        try{
            return kweetDAO.getGebruikerKweetsById(id, limit);
        } catch(PersistenceException pe){
            LOGGER.log(Level.FINE, "ERROR while performing getGebruikerkweets method; {0}", pe.getMessage());
            return null;
        }
    }
    
    /**
     * Adds a new kweet.
     * @param gebruiker The gebruiker who posts this kweet.
     * @param message The content of the kweet.
     */
    public void addKweet(Gebruiker gebruiker, String message){
        try{
            kweetDAO.createKweet(gebruiker, message);
        } catch(PersistenceException pe){
            LOGGER.log(Level.FINE, "ERROR while performing getGebruikerkweets method; {0}", pe.getMessage());
        }
    }
    
    /**
     * Updates a kweet in de JPA database.
     * @param kweet the kweet to be updated.
     */
    public void updateKweet(Kweet kweet){
        try{
            kweetDAO.updateKweet(kweet);
        } catch(PersistenceException pe){
            LOGGER.log(Level.FINE, "ERROR while performing getGebruikerkweets method; {0}", pe.getMessage());
        }
    }
    
    /**
     * Deletes a kweet in the database.
     * @param id The id of the kweet to delete.
     */
    public void deleteKweet(Kweet kweet){
        try{
            kweetDAO.deleteKweet(kweet);
        } catch(PersistenceException pe){
            LOGGER.log(Level.FINE, "ERROR while performing getGebruikerkweets method; {0}", pe.getMessage());
        }
    }
}
