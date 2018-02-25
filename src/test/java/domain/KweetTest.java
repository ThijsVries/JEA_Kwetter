/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thijs
 */
public class KweetTest {
    
    public KweetTest() {
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
     * Test of getMessage method, of class Kweet.
     */
    @Test
    public void testGetMessage() {
        System.out.println("getMessage");
        Kweet instance = new Kweet();
        String expResult = null;
        String result = instance.getMessage();
        assertEquals(expResult, result);
        
        expResult = "Test";
        Gebruiker gebruiker = new Gebruiker();
        instance = new Kweet(gebruiker, "Test");
        assertEquals(expResult, instance.getMessage());
    }

    /**
     * Test of setMessage method, of class Kweet.
     */
    @Test
    public void testSetMessage() {
        System.out.println("setMessage");
        String message = "Test";
        Kweet instance = new Kweet();
        
        instance.setMessage(message);
        
        assertEquals(instance.getMessage(), "Test");
        
        message = null;
        instance.setMessage(message);
        assertNull(instance.getMessage());
    }

    /**
     * Test of getDate method, of class Kweet.
     */
    @Test
    public void testGetDateSetDate() {
        System.out.println("getDate");
        Kweet instance = new Kweet();
        Date expResult = new Date(5, 12, 2016);
        instance.setDate(new Date(5,12,2016));
        
        Date result = instance.getDate();
        assertEquals(expResult, result);
        
        instance.setDate(null);
        assertNull(instance.getDate());
    }

    /**
     * Test of getTags method, of class Kweet.
     */
    @Test
    public void testGetTagsSetTags() {
        System.out.println("getTags");
        Kweet instance = new Kweet();
        
        List<String> expResult = new ArrayList();
        expResult.add("TestTag1");
        expResult.add("TestTag2");
        
        instance.setTags(expResult);
        
        List<String> result = instance.getTags();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOwnedBy method, of class Kweet.
     */
    @Test
    public void testGetOwnedBy() {
        System.out.println("getOwnedBy");
        Kweet instance = new Kweet();
        Gebruiker expResult = null;
        Gebruiker result = instance.getOwnedBy();
        assertEquals(expResult, result);
        
        expResult = new Gebruiker("test@mail.com", "123");
        instance = new Kweet(expResult, "test");
        assertEquals(expResult, instance.getOwnedBy());
    }

    /**
     * Test of setOwnedBy method, of class Kweet.
     */
    @Test
    public void testSetOwnedBy() {
        System.out.println("setOwnedBy");
        Gebruiker ownedBy = null;
        Kweet instance = new Kweet();
        instance.setOwnedBy(ownedBy);
        
        assertNull(instance.getOwnedBy());
        
        ownedBy = new Gebruiker("test@mail.com", "123");
        instance.setOwnedBy(ownedBy);
        assertEquals(ownedBy, instance.getOwnedBy());
    }

    /**
     * Test of getLikes method, of class Kweet.
     */
    @Test
    public void testGetLikesSetLikes() {
        System.out.println("getLikes");
        
        Kweet instance = new Kweet();
        List<Gebruiker> expResult = new ArrayList();
        
        Gebruiker test1 = new Gebruiker("test@mail.com", "123");
        Gebruiker test2 = new Gebruiker("test2@mail.com", "123");
        
        expResult.add(test1);
        expResult.add(test2);
        
        instance.setLikes(expResult);
        
        assertEquals(expResult, instance.getLikes());
        
        instance.setLikes(null);
        assertNull(instance.getLikes());
    }

    /**
     * Test of getMentioned method, of class Kweet.
     */
    @Test
    public void testGetMentionedSetMentioned() {
        System.out.println("getMentioned");
        Kweet instance = new Kweet();
        List<Gebruiker> expResult = new ArrayList();
        
        Gebruiker test1 = new Gebruiker("test@mail.com", "123");
        Gebruiker test2 = new Gebruiker("test2@mail.com", "123");
        
        expResult.add(test1);
        expResult.add(test2);
        
        instance.setMentioned(expResult);
        
        assertEquals(expResult, instance.getMentioned());
        
        instance.setMentioned(null);
        assertNull(instance.getMentioned());
    }

    /**
     * Test of like method, of class Kweet.
     */
    @Test
    public void testLike() {
        System.out.println("like");
        Gebruiker gebruiker = new Gebruiker("test@mail.com", "123");
        Kweet instance = new Kweet();
        instance.like(gebruiker);
        assertEquals(1, instance.getLikes().size());
        
        Gebruiker gebruiker2 = null;
        instance.like(gebruiker2);
        assertEquals(1, instance.getLikes().size());
        
        gebruiker2 = new Gebruiker("test2@mail.com", "123");
        instance.like(gebruiker2);
        assertEquals(2, instance.getLikes().size());
        
        instance.like(gebruiker);
        assertEquals(2, instance.getLikes().size());
    }

    /**
     * Test of unlike method, of class Kweet.
     */
    @Test
    public void testUnlike() {
        System.out.println("unlike");
        Gebruiker gebruiker = new Gebruiker("test@mail.com", "123");
        Kweet instance = new Kweet();
        
        instance.like(gebruiker);
        instance.unlike(gebruiker);
        assertEquals(0, instance.getLikes().size());
        
        Gebruiker gebruiker2 = null;
        instance.like(gebruiker);
        instance.unlike(gebruiker2);
        assertEquals(1, instance.getLikes().size());
        
        gebruiker2 = new Gebruiker("test2@mail.com", "123");
        instance.like(gebruiker2);
        instance.unlike(gebruiker);
        assertEquals(1, instance.getLikes().size());
    }

    /**
     * Test of equals method, of class Kweet.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Gebruiker gebruiker1 = new Gebruiker("test@mail.com", "123");
        Gebruiker gebruiker2 = new Gebruiker("test2@mail.com", "123");
        
        Kweet kweet1 = new Kweet(gebruiker1, "test1");
        Kweet kweet2 = new Kweet(gebruiker1, "test2");
        Kweet kweet3 = new Kweet(gebruiker2, "test1");
        
        assertFalse(kweet1.equals(kweet2));
        assertFalse(kweet1.equals(kweet3));
        assertTrue(kweet1.equals(kweet1));
    }
    
}
