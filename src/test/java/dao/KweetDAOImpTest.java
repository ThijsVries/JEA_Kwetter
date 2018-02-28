package dao;

import domain.Gebruiker;
import domain.Kweet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import util.DatabaseCleaner;


public class KweetDAOImpTest {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("kwetter_testPU");
    private EntityManager em;
    private EntityTransaction tx;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        try {
            new DatabaseCleaner(emf.createEntityManager()).clean();
        } catch (SQLException ex) {
            Logger.getLogger(GebruikerDAOImpTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of getKweet method, of class KweetDAOImp.
     */
    @Test
    public void testGetKweet() throws Exception {
        Gebruiker instance = new Gebruiker("test@mail.com", "12345");
        
        String kweetContent = "Yoyo whats good";
        Kweet kweet = new Kweet(instance, kweetContent);
        
        tx.begin();
        em.persist(instance);
        em.persist(kweet);
        tx.commit();
        
        Kweet kweet2 = em.find(Kweet.class, kweet.getId());
        assertEquals(kweetContent, kweet2.getMessage());
        
    }

    /**
     * Test of getAllKweets method, of class KweetDAOImp.
     */
    @Test
    public void testGetAllKweets() throws Exception {
        
    }

    /**
     * Test of setKweetMentions method, of class KweetDAOImp.
     */
    @Test
    public void testSetKweetMentionsGetMentions() throws Exception {
        Gebruiker instance = new Gebruiker("test@mail.com", "12345");
        
        Kweet kweet = new Kweet(instance, "test kweet");
        
        tx.begin();
        em.persist(instance);
        em.persist(kweet);
        tx.commit();
        
        List<Gebruiker> gebruikers = new ArrayList<Gebruiker>();
        gebruikers.add(new Gebruiker("test2@mail.com", "1231"));
        gebruikers.add(new Gebruiker("test3@mail.com", "1233421"));
        kweet.setMentioned(gebruikers);
        
        assertTrue(kweet.getMentioned().size() == 2);
    }

    /**
     * Test of likeKweet method, of class KweetDAOImp.
     */
    @Test
    public void testLikeKweet() throws Exception {
        Gebruiker gebruiker1 = new Gebruiker("test@mail.com", "12423");
        Gebruiker gebruiker2 = new Gebruiker("test2@mail.com", "12312");
        Gebruiker gebruiker3 = new Gebruiker("test3@mail.com", "2312");
        
        Kweet kweet = new Kweet(gebruiker1, "Ik heb swag man");
        kweet.like(gebruiker2);
        
        tx.begin();
        em.persist(gebruiker1);
        em.persist(gebruiker2);
        em.persist(gebruiker3);
        em.persist(kweet);
        tx.commit();
        
        Kweet kweetCopy = em.find(Kweet.class, kweet.getId());
        assertTrue(kweetCopy.getLikes().size() == 1);
        
        kweet.like(gebruiker3);
        //TODO check if this updates the original object in the database
    }

    /**
     * Test of getLikes method, of class KweetDAOImp.
     */
    @Test
    public void testGetLikes() throws Exception {
        Gebruiker gebruiker1 = new Gebruiker("test@mail.com", "12423");
        Gebruiker gebruiker2 = new Gebruiker("test2@mail.com", "12312");
        Gebruiker gebruiker3 = new Gebruiker("test3@mail.com", "2312");
        
        Kweet kweet = new Kweet(gebruiker1, "Get likes test kweet");
        kweet.like(gebruiker2);
        kweet.like(gebruiker3);
        
        tx.begin();
        em.persist(gebruiker1);
        em.persist(gebruiker2);
        em.persist(gebruiker3);
        tx.commit();
        
        Kweet kweetCopy = em.find(Kweet.class, kweet.getId());
        assertTrue(kweetCopy.getLikes().size() == 2);
    }

    /**
     * Test of getGebruikerKweets method, of class KweetDAOImp.
     */
    @Test
    public void testGetGebruikerKweets() throws Exception {
        Gebruiker instance = new Gebruiker("test@mail.com", "124342");
        
        Kweet kweet1 = new Kweet(instance,"Yoyoyo");
        Kweet kweet2 = new Kweet(instance,"whats cracking");
        
        List<Kweet> kweets = em.createNamedQuery("Kweet.getGebruikerKweets").setParameter("email", instance.getEmail()).getResultList();
    }

    /**
     * Test of createKweet method, of class KweetDAOImp.
     */
    @Test
    public void testCreateKweet() throws Exception {
        
    }

    /**
     * Test of deleteKweet method, of class KweetDAOImp.
     */
    @Test
    public void testDeleteKweet() throws Exception {
        
    }

    /**
     * Test of updateKweet method, of class KweetDAOImp.
     */
    @Test
    public void testUpdateKweet() throws Exception {
        
    }

}
