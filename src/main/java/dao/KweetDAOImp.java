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
    public void createKweet(int gebruikerid, String content) {
        
        List<Gebruiker> gebruiker = em.createNamedQuery("Gebruiker.getById").setParameter("id", gebruikerid).getResultList();
        em.persist(new Kweet(gebruiker.get(0), content));
    }

    @Override
    public void deleteKweet(Kweet kweet) {
        
        Kweet tempKweet = em.find(Kweet.class, kweet.getId());
        
        tempKweet.clearKweet();
        em.remove(tempKweet);
    }

    @Override
    public void updateKweet(Kweet kweet) {
        em.merge(kweet);
    }

    @Override
    public void addKweetMention(Gebruiker gebruiker, Kweet kweet) {
        kweet.addMention(gebruiker);
        em.merge(kweet);
    }

    @Override
    public void removeKweetMention(Gebruiker gebruiker, Kweet kweet) {
        kweet.removeMention(gebruiker);
        em.merge(kweet);
    }

    @Override
    public void addTag(String tag, Kweet kweet) {
        kweet.addTag(tag);
        em.merge(kweet);
    }

    @Override
    public void removeTag(String tag, Kweet kweet) {
        kweet.removeTag(tag);
        em.merge(kweet);
    }

    @Override
    public void unlikeKweet(Gebruiker gebruiker, Kweet kweet) {
        kweet.unlike(gebruiker);
        em.merge(kweet);
    }

}
