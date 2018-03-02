/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Gebruiker;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.DatabaseCleaner;

/**
 *
 * @author Tvrie
 */
public class GebruikerDAOImpTest {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("kwetter_testPU");
    private EntityManager em;
    private EntityTransaction tx;

    public GebruikerDAOImpTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws NamingException {
        try {
            new DatabaseCleaner(emf.createEntityManager()).clean();
        } catch (SQLException ex) {
            Logger.getLogger(GebruikerDAOImpTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAddGebruiker() {
        Gebruiker gebruiker = new Gebruiker("test@testmail.com", "12345");
        Gebruiker gebruiker2 = new Gebruiker("test@mail", "1234");

        tx.begin();
        em.persist(gebruiker);
        em.persist(gebruiker2);
        tx.commit();
        
        assertTrue(em.createNamedQuery("Gebruiker.getAllGebruikers").getResultList().size() == 2);
    }

    @Test
    public void testUpdateGebruiker() {
        Gebruiker gebruiker = new Gebruiker("test@mail.com", "123456");

        tx.begin();
        em.persist(gebruiker);
        tx.commit();

        String newMail = "test2@mail.com";
        tx.begin();
        gebruiker.setEmail(newMail);
        em.merge(gebruiker);
        tx.commit();

        List<Gebruiker> instance = em.createNamedQuery("Gebruiker.getByMail").setParameter("email", newMail).getResultList();
        assertEquals(newMail, instance.get(0).getEmail());
    }
    
    @Test
    public void testRemoveGebruiker(){
        String email = "test@mail.com";
        Gebruiker gebruiker = new Gebruiker(email, "1234234");
        
        tx.begin();
        em.persist(gebruiker);
        tx.commit();
        
        tx.begin();
        em.remove(gebruiker);
        tx.commit();
        
        assertTrue(em.createNamedQuery("Gebruiker.getByMail").setParameter("email", email).getResultList().size() == 0);
    }

    @Test
    public void testGetGebruikerFollowers() {
        Gebruiker gebruiker1 = new Gebruiker("test@mail.com", "12345");
        Gebruiker gebruiker2 = new Gebruiker("test2@mail.com", "34324");
        Gebruiker gebruiker3 = new Gebruiker("test3@mail.com", "234234");

        gebruiker1.makeFollow(gebruiker2);
        gebruiker1.makeFollow(gebruiker3);

        tx.begin();
        em.persist(gebruiker1);
        tx.commit();

        List<Gebruiker> instance = em.createNamedQuery("Gebruiker.getByMail").setParameter("email", "test@mail.com").getResultList();
        assertEquals(gebruiker2, instance.get(0).getFollowing().get(0));
    }

    @Test
    public void testGetGebruikerByEmail() {
        String email = "test@mail.com";
        Gebruiker gebruiker = new Gebruiker(email, "123456");

        tx.begin();
        em.persist(gebruiker);
        tx.commit();

        List<Gebruiker> gebruikers = em.createNamedQuery("Gebruiker.getByMail").setParameter("email", email).getResultList();

        assertTrue(gebruiker.hashCode() == gebruikers.get(0).hashCode());
    }
    
    @Test
    public void testGetGebruikerByName(){
        String firstName = "Pietje";
        Gebruiker gebruiker = new Gebruiker("test@mail.com", "2342");
        gebruiker.setFirstName(firstName);
        
        tx.begin();
        em.persist(gebruiker);
        tx.commit();
        
        List<Gebruiker> gebruikers = em.createNamedQuery("Gebruiker.getByName").setParameter("firstName", firstName).getResultList();
        
        assertEquals(firstName, gebruikers.get(0).getFirstName());
    }
}
