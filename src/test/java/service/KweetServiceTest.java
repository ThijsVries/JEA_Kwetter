/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.KweetDAO;
import domain.Gebruiker;
import domain.Kweet;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Tvrie
 */
public class KweetServiceTest {
    
    @Mock
    KweetDAO kweetDAO;
    
    @InjectMocks
    KweetService kweetService;
    
    public KweetServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getKweet method, of class KweetService.
     */
    @Test
    public void testGetKweet() throws Exception {
        Gebruiker instance = new Gebruiker();
        Kweet kweet = new Kweet(instance, "Swah");
        
        kweetService.addKweet(0, "Swah");
        kweetService.getKweet(1);
        
        verify(kweetDAO, times(1)).getKweet(1);
    }

    /**
     * Test of getRecentKweets method, of class KweetService.
     */
    @Test
    public void testGetRecentKweets() throws Exception {
        kweetService.getRecentKweets(10);
        verify(kweetDAO, times(1)).getRecentKweets(10);
    }

    /**
     * Test of getGebruikerKweets method, of class KweetService.
     */
    @Test
    public void testGetGebruikerKweets() throws Exception {
        kweetService.getGebruikerKweets("Testmail@test.com", 20);
        verify(kweetDAO, times(1)).getGebruikerKweets("Testmail@test.com", 20);
    }

    /**
     * Test of addKweet method, of class KweetService.
     */
    @Test
    public void testAddKweet() throws Exception {
        kweetService.addKweet(1, "swag");
        verify(kweetDAO, times(1)).createKweet(1, "swag");
    }

    /**
     * Test of updateKweet method, of class KweetService.
     */
    @Test
    public void testUpdateKweet() throws Exception {
        kweetService.updateKweet(new Kweet(null, "Skrr"));
        verify(kweetDAO, times(1)).updateKweet(new Kweet(null, "Skrr"));
    }

    /**
     * Test of deleteKweet method, of class KweetService.
     */
    @Test
    public void testDeleteKweet() throws Exception {
        kweetService.deleteKweet(new Kweet(null, "swag"));
        verify(kweetDAO, times(1)).deleteKweet(new Kweet(null, "swag"));
    }
    
}
