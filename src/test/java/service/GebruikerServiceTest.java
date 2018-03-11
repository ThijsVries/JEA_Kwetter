/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.GebruikerDAO;
import domain.Gebruiker;
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Tvrie
 */
public class GebruikerServiceTest {
    
    @Mock
    private GebruikerDAO gebruikerDAO;
    @InjectMocks
    private GebruikerService gebruikerService;
    
    public GebruikerServiceTest() {
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
     * Test of addGebruiker method, of class GebruikerService.
     */
    @Test
    public void testAddGebruiker() throws Exception {
        Gebruiker gebruiker = new Gebruiker("test", "124234");
        gebruikerService.addGebruiker(gebruiker);
        
        verify(gebruikerDAO, times(1)).addGebruiker(gebruiker);
    }

    /**
     * Test of updateGebruiker method, of class GebruikerService.
     */
    @Test
    public void testUpdateGebruiker() throws Exception {
        Gebruiker gebruiker = new Gebruiker("test", "12334234");
        gebruikerService.addGebruiker(gebruiker);
        
        gebruiker.setFirstName("Jantje");
        gebruikerService.updateGebruiker(gebruiker);
        
        verify(gebruikerDAO, times(1)).updateGebruiker(gebruiker);
    }

    /**
     * Test of deleteGebruiker method, of class GebruikerService.
     */
    @Test
    public void testDeleteGebruiker() throws Exception {
        Gebruiker gebruiker = new Gebruiker("test", "23423423");
        gebruikerService.addGebruiker(gebruiker);
        
        gebruikerService.deleteGebruiker(gebruiker);
        verify(gebruikerDAO, times(1)).deleteGebruiker(gebruiker);
    }

    /**
     * Test of getGebruikerByEmail method, of class GebruikerService.
     */
    @Test
    public void testGetGebruikerByEmail() throws Exception {
        Gebruiker gebruiker = new Gebruiker("test", "23423423");
        gebruikerService.addGebruiker(gebruiker);
        
        gebruikerService.getGebruikerByEmail("test");
        verify(gebruikerDAO, times(1)).getGebruikerByEmail("test");
    }

    /**
     * Test of getGebruikerFollowers method, of class GebruikerService.
     */
    @Test
    public void testGetGebruikerFollowers() throws Exception {
        Gebruiker gebruiker = new Gebruiker("test", "23234");
        gebruikerService.addGebruiker(gebruiker);
        
        gebruikerService.getGebruikerFollowers("test");
        verify(gebruikerDAO, times(1)).getGebruikerFollowers("test");
    }

    /**
     * Test of getGebruikerByName method, of class GebruikerService.
     */
    @Test
    public void testGetGebruikerByName() throws Exception {
        Gebruiker gebruiker = new Gebruiker("test", "324234");
        gebruiker.setFirstName("Jantje");
        
        gebruikerService.addGebruiker(gebruiker);
        gebruikerService.getGebruikerByName("Jantje");
        verify(gebruikerDAO, times(1)).getGebruikerByName("Jantje");
    }
    
}
