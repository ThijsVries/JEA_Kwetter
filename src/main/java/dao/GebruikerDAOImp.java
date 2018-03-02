package dao;

import domain.Gebruiker;
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
        em.merge(gebruiker);
    }

    @Override
    public List<Gebruiker> getGebruikerFollowers(int id) {
        Gebruiker gebruiker = em.find(Gebruiker.class, id);
        return gebruiker.getFollowing();
    }

    @Override
    public void deleteGebruiker(Gebruiker gebruiker) {
        em.remove(gebruiker);
    }

    @Override
    public List<Gebruiker> findGebruikerByEmail(String email) {
        return em.createNamedQuery("Gebruiker.getByMail").setParameter("email", email).getResultList();
    }

    @Override
    public List<Gebruiker> findGebruikerByName(String firstName) {
        return em.createNamedQuery("Gebruiker.getByName").setParameter("firstName", firstName).getResultList();
    }


}
