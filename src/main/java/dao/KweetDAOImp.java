package dao;

import domain.Gebruiker;
import domain.Kweet;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class KweetDAOImp implements KweetDAO{

    @PersistenceContext
    EntityManager em;
    
    @Override
    public Kweet getKweet(int id) {
        return (Kweet) em.find(Kweet.class, id);
    }

    @Override
    public List<Kweet> getAllKweets() {
        return em.createNamedQuery("kweet.getAll").getResultList();
    }

    @Override
    public void setKweetMentions(List<Gebruiker> mentions, Kweet kweet) {
        kweet.setMentioned(mentions);
        em.persist(kweet);
    }

    @Override
    public boolean likeKweet(Gebruiker gebruiker, Kweet kweet) {
        kweet.like(gebruiker);
        em.merge(kweet);
        return true;
    }
    
    //TODO fix named query to get likes.
    @Override
    public List<Gebruiker> getLikes(Kweet kweet) {
        return null;
    }

    @Override
    public List<Gebruiker> getMentions(Kweet kweet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Kweet> getGebruikerKweets(Gebruiker gebruiker) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean createKweet(Gebruiker gebruiker, String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteKweet(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateKweet(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
