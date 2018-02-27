package dao;

import domain.Gebruiker;
import domain.Kweet;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class KweetDAOImpCollection implements KweetDAO{
    
    @PersistenceContext
    EntityManager em;

    @Override
    public Kweet getKweet(int id) {
        return em.find(Kweet.class, id);
    }

    @Override
    public List<Kweet> getAllKweets() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean createKweet(Gebruiker gebruiker, String message) {
        em.persist(new Kweet(gebruiker, message));
        return true;
    }

    @Override
    public boolean deleteKweet(int id) {
        em.remove(id);
        return true;
    }

    @Override
    public boolean updateKweet(int id) {
        em.merge(id);
        return true;
    }
    
    

}
