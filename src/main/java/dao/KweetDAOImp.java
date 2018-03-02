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
    public void likeKweet(Gebruiker gebruiker, Kweet kweet) {
        kweet.like(gebruiker);
        em.merge(kweet);
    }
    
    @Override
    public List<Gebruiker> getLikes(Kweet kweet) {
        List<Kweet> kweets = em.createNamedQuery("Kweet.getKweetById").setParameter("id", kweet.getId()).getResultList();
        return kweets.get(0).getLikes();
    }

    @Override
    public List<Gebruiker> getMentions(Kweet kweet) {
        List<Kweet> kweets = em.createNamedQuery("Kweet.getKweetById").setParameter("id", kweet.getId()).getResultList();
        return kweets.get(0).getMentioned();
    }

    @Override
    public List<Kweet> getGebruikerKweets(Gebruiker gebruiker) {
        return em.createNamedQuery("Kweet.getGebruikerKweets").setParameter("email", gebruiker.getEmail()).getResultList();
    }

    @Override
    public void createKweet(Gebruiker gebruiker, String message) {
        em.persist(new Kweet(gebruiker, message));
    }

    @Override
    public void deleteKweet(int id) {
        em.remove(id);
    }

    @Override
    public void updateKweet(Kweet kweet) {
        em.merge(kweet);
    }

}
