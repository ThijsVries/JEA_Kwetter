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
    public boolean addGebruiker(Gebruiker gebruiker) {
        em.persist(gebruiker);
        return true;
    }

    @Override
    public boolean updateGebruiker(Gebruiker gebruiker) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Gebruiker> getGebruikerFollowers(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Gebruiker findGebruikerById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
