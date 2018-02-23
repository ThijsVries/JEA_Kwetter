package domain;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GebruikerTest {
    
    public GebruikerTest() {
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
     * Test of getFirstName method, of class Gebruiker.
     */
    @Test
    public void testGetFirstName() {
        //First test the getter with a null result
        System.out.println("getFirstName");
        Gebruiker instance = new Gebruiker();
        String expResult = null;
        String result = instance.getFirstName();
        assertEquals(expResult, result);
        
        //Test the getter with a proper result
        Gebruiker instance2 = new Gebruiker("jan@mail.com", "Jan", "password");
        String expResult2 = "Jan";
        assertEquals(instance2.getFirstName(), expResult2);
    }

    /**
     * Test of setFirstName method, of class Gebruiker.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "";
        Gebruiker instance = new Gebruiker();
        instance.setFirstName(firstName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastName method, of class Gebruiker.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        Gebruiker instance = new Gebruiker();
        String expResult = "";
        String result = instance.getLastName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastName method, of class Gebruiker.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "";
        Gebruiker instance = new Gebruiker();
        instance.setLastName(lastName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class Gebruiker.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Gebruiker instance = new Gebruiker();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class Gebruiker.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Gebruiker instance = new Gebruiker();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProfilePicture method, of class Gebruiker.
     */
    @Test
    public void testGetProfilePicture() {
        System.out.println("getProfilePicture");
        Gebruiker instance = new Gebruiker();
        String expResult = "";
        String result = instance.getProfilePicture();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProfilePicture method, of class Gebruiker.
     */
    @Test
    public void testSetProfilePicture() {
        System.out.println("setProfilePicture");
        String profilePicture = "";
        Gebruiker instance = new Gebruiker();
        instance.setProfilePicture(profilePicture);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class Gebruiker.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Gebruiker instance = new Gebruiker();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class Gebruiker.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        Gebruiker instance = new Gebruiker();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBio method, of class Gebruiker.
     */
    @Test
    public void testGetBio() {
        System.out.println("getBio");
        Gebruiker instance = new Gebruiker();
        String expResult = "";
        String result = instance.getBio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBio method, of class Gebruiker.
     */
    @Test
    public void testSetBio() {
        System.out.println("setBio");
        String bio = "";
        Gebruiker instance = new Gebruiker();
        instance.setBio(bio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWebsite method, of class Gebruiker.
     */
    @Test
    public void testGetWebsite() {
        System.out.println("getWebsite");
        Gebruiker instance = new Gebruiker();
        String expResult = "";
        String result = instance.getWebsite();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWebsite method, of class Gebruiker.
     */
    @Test
    public void testSetWebsite() {
        System.out.println("setWebsite");
        String website = "";
        Gebruiker instance = new Gebruiker();
        instance.setWebsite(website);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocation method, of class Gebruiker.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        Gebruiker instance = new Gebruiker();
        String expResult = "";
        String result = instance.getLocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLocation method, of class Gebruiker.
     */
    @Test
    public void testSetLocation() {
        System.out.println("setLocation");
        String location = "";
        Gebruiker instance = new Gebruiker();
        instance.setLocation(location);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFollowing method, of class Gebruiker.
     */
    @Test
    public void testGetFollowing() {
        System.out.println("getFollowing");
        Gebruiker instance = new Gebruiker();
        List<Gebruiker> expResult = null;
        List<Gebruiker> result = instance.getFollowing();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFollowing method, of class Gebruiker.
     */
    @Test
    public void testSetFollowing() {
        System.out.println("setFollowing");
        List<Gebruiker> following = null;
        Gebruiker instance = new Gebruiker();
        instance.setFollowing(following);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeFollow method, of class Gebruiker.
     */
    @Test
    public void testMakeFollow() {
        System.out.println("makeFollow");
        Gebruiker gebruiker = null;
        Gebruiker instance = new Gebruiker();
        instance.makeFollow(gebruiker);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeUnfollow method, of class Gebruiker.
     */
    @Test
    public void testMakeUnfollow() {
        System.out.println("makeUnfollow");
        Gebruiker gebruiker = null;
        Gebruiker instance = new Gebruiker();
        instance.makeUnfollow(gebruiker);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeUserRole method, of class Gebruiker.
     */
    @Test
    public void testChangeUserRole() {
        System.out.println("changeUserRole");
        int rank = 0;
        Gebruiker instance = new Gebruiker();
        instance.changeUserRole(rank);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
