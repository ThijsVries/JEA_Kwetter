package dao;

import domain.Gebruiker;
import domain.Kweet;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class GebruikerDAOImp implements GebruikerDAO{

    @PersistenceContext
    EntityManager em;
    
    @Override
    public void addGebruiker(Gebruiker gebruiker) {
        em.persist(gebruiker);
    }

    @Override
    public void updateGebruiker(Gebruiker gebruiker) {
        
//        Gebruiker managedGebruiker = em.find(Gebruiker.class, gebruiker.getId());
//        
//        if(gebruiker.getFirstName()!= null)
//        managedGebruiker.setFirstName(gebruiker.getFirstName());
//        
//        if(gebruiker.getLastName()!= null)
//        managedGebruiker.setLastName(gebruiker.getLastName());
//        
//        if(gebruiker.getBio()!= null)
//        managedGebruiker.setBio(gebruiker.getBio());
//        
//        if(gebruiker.getEmail()!= null)
//        managedGebruiker.setEmail(gebruiker.getEmail());
//        
//        if(gebruiker.getLocation()!= null)
//        managedGebruiker.setLocation(gebruiker.getLocation());
//        
//        if(gebruiker.getProfilePicture()!= null)
//        managedGebruiker.setProfilePicture(gebruiker.getProfilePicture());
//        
//        if(gebruiker.getWebsite()!= null)
//        managedGebruiker.setWebsite(gebruiker.getWebsite());

          em.merge(gebruiker);
    }

    @Override
    public List<Gebruiker> getGebruikerFollowers(String email) {
        List<Gebruiker> gebruikers = em.createNamedQuery("Gebruiker.getByMail").setParameter("email", email).getResultList();
        return gebruikers.get(0).getFollowing();
    }

    @Override
    public void deleteGebruiker(Gebruiker gebruiker) {
        Gebruiker managedGebruiker = em.find(Gebruiker.class, gebruiker.getId());
        
        List<Kweet> gebruikerKweets = em.createNamedQuery("Kweet.getGebruikerKweets").setParameter("email", gebruiker.getEmail()).getResultList();
        
        for (Kweet kweet : gebruikerKweets) {
            em.remove(kweet);
        }
        
        em.remove(managedGebruiker);
    }

    @Override
    public List<Gebruiker> getGebruikerByEmail(String email) {
        return em.createNamedQuery("Gebruiker.getByMail").setParameter("email", email).getResultList();
    }

    @Override
    public List<Gebruiker> getGebruikerByName(String firstName) {
        return em.createNamedQuery("Gebruiker.getByName").setParameter("firstName", firstName).getResultList();
    }


}
