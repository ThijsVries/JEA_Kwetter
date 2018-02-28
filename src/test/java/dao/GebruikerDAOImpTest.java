/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Gebruiker;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tvrie
 */
public class GebruikerDAOImpTest {
    
    public GebruikerDAOImpTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addGebruiker method, of class GebruikerDAOImp.
     */
    @Test
    public void testAddGebruiker() throws Exception {
        System.out.println("addGebruiker");
        Gebruiker gebruiker = null;
        GebruikerDAOImp instance = new GebruikerDAOImp();
        boolean expResult = false;
        boolean result = instance.addGebruiker(gebruiker);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateGebruiker method, of class GebruikerDAOImp.
     */
    @Test
    public void testUpdateGebruiker() throws Exception {
        System.out.println("updateGebruiker");
        Gebruiker gebruiker = null;
        GebruikerDAOImp instance = new GebruikerDAOImp();
        boolean expResult = false;
        boolean result = instance.updateGebruiker(gebruiker);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGebruikerFollowers method, of class GebruikerDAOImp.
     */
    @Test
    public void testGetGebruikerFollowers() throws Exception {
        System.out.println("getGebruikerFollowers");
        int id = 0;
        GebruikerDAOImp instance = new GebruikerDAOImp();
        List<Gebruiker> expResult = null;
        List<Gebruiker> result = instance.getGebruikerFollowers(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findGebruikerById method, of class GebruikerDAOImp.
     */
    @Test
    public void testFindGebruikerById() throws Exception {
        System.out.println("findGebruikerById");
        int id = 0;
        GebruikerDAOImp instance = new GebruikerDAOImp();
        Gebruiker expResult = null;
        Gebruiker result = instance.findGebruikerById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
