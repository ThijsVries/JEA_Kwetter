package dao;

import domain.Gebruiker;
import domain.Kweet;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class KweetDAOImp implements KweetDAO{

    @PersistenceContext
    EntityManager em;
    
    @Override
    public List<Kweet> getKweet(int id) {
        return em.createNamedQuery("Kweet.getKweetById").setParameter("id", id).getResultList();
    }

    @Override
    public List<Kweet> getRecentKweets(int limit) {
        return em.createNamedQuery("Kweet.getRecentkweets").setMaxResults(limit).getResultList();
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
    public List<Kweet> getGebruikerKweets(String email, int limit) {
        return em.createNamedQuery("Kweet.getGebruikerKweets").setParameter("email", email).setMaxResults(limit).getResultList();
    }

    @Override
    public void createKweet(Gebruiker gebruiker, String message) {
        em.persist(new Kweet(gebruiker, message, new Date()));
    }

    @Override
    public void deleteKweet(Kweet kweet) {
        em.remove(kweet);
    }

    @Override
    public void updateKweet(Kweet kweet) {
        em.merge(kweet);
    }

    @Override
    public List<Kweet> getGebruikerKweetsById(int id, int limit) {
        return em.createNamedQuery("Kweet.getGebruikerKweetsById").setParameter("id", id).setMaxResults(limit).getResultList();
    }

}
