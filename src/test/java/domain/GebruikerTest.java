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
        Gebruiker instance2 = new Gebruiker("Jan", "", "", "", "", "", "", "");
        String expResult2 = "Jan";
        assertEquals(instance2.getFirstName(), expResult2);
    }

    /**
     * Test of setFirstName method, of class Gebruiker.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        
        String firstName = "Jan";
        Gebruiker instance = new Gebruiker("", "", "", "", "", "", "", "");
        assertEquals(instance.getFirstName(), "");
        instance.setFirstName(firstName);
        assertEquals(instance.getFirstName(), firstName);
        instance.setFirstName(null);
        assertNull(instance.getFirstName());
    }

    /**
     * Test of getLastName method, of class Gebruiker.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        Gebruiker instance = new Gebruiker();
        assertNull(instance.getLastName());
        
        String lastName = "Pietje";
        Gebruiker instance2 = new Gebruiker("", "Pietje", "", "", "", "", "", "");
        assertEquals(instance2.getLastName(), lastName);
    }

    /**
     * Test of setLastName method, of class Gebruiker.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "Pietje";
        Gebruiker instance = new Gebruiker("", "", "", "", "", "", "", "");
        assertEquals(instance.getLastName(), "");
        instance.setLastName(lastName);
        assertEquals(instance.getLastName(), lastName);
        instance.setLastName(null);
        assertNull(instance.getLastName());
    }

    /**
     * Test of getEmail method, of class Gebruiker.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Gebruiker instance = new Gebruiker();
        assertNull(instance.getEmail());
        
        String email = "mail@mail.com";
        Gebruiker instance2 = new Gebruiker("", "", "mail@mail.com", "", "", "", "", "");
        assertEquals(instance2.getEmail(), email);
    }

    /**
     * Test of setEmail method, of class Gebruiker.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "mail@mail.com";
        Gebruiker instance = new Gebruiker("", "", "", "", "", "", "", "");
        assertEquals(instance.getEmail(), "");
        
        instance.setEmail(email);
        assertEquals(instance.getEmail(), email);
        
        instance.setEmail(null);
        assertNull(instance.getEmail());
    }

    /**
     * Test of getProfilePicture method, of class Gebruiker.
     */
    @Test
    public void testGetProfilePicture() {
        System.out.println("getProfilePicture");
        Gebruiker instance = new Gebruiker();
        assertNull(instance.getProfilePicture());
        
        String profilePicture = "test.jpg";
        Gebruiker instance2 = new Gebruiker("", "", "", "test.jpg", "", "", "", "");
        assertEquals(instance2.getProfilePicture(), profilePicture);
    }

    /**
     * Test of setProfilePicture method, of class Gebruiker.
     */
    @Test
    public void testSetProfilePicture() {
        System.out.println("setProfilePicture");
        String profilePicture = "test.jpg";
        Gebruiker instance = new Gebruiker("", "", "", "", "", "", "", "");
        assertEquals(instance.getProfilePicture(), "");
        
        instance.setProfilePicture(profilePicture);
        assertEquals(instance.getProfilePicture(), profilePicture);
        
        instance.setEmail(null);
        assertNull(instance.getEmail());
    }

    /**
     * Test of getPassword method, of class Gebruiker.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Gebruiker instance = new Gebruiker();
        assertNull(instance.getPassword());
        
        String password = "password";
        Gebruiker instance2 = new Gebruiker("", "", "", "", "password", "", "", "");
        assertEquals(instance2.getPassword(), password);
    }

    /**
     * Test of setPassword method, of class Gebruiker.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "password";
        Gebruiker instance = new Gebruiker("", "", "", "", "", "", "", "");
        assertEquals(instance.getPassword(), "");
        
        instance.setPassword(password);
        assertEquals(instance.getPassword(), password);
        
        instance.setPassword(null);
        assertNull(instance.getPassword());
    }

    /**
     * Test of getBio method, of class Gebruiker.
     */
    @Test
    public void testGetBio() {
        System.out.println("getBio");
        Gebruiker instance = new Gebruiker();
        assertNull(instance.getBio());
        
        String bio = "bla";
        Gebruiker instance2 = new Gebruiker("", "", "", "", "", "bla", "", "");
        assertEquals(instance2.getBio(), bio);
    }

    /**
     * Test of setBio method, of class Gebruiker.
     */
    @Test
    public void testSetBio() {
        System.out.println("setBio");
        String bio = "bla";
        Gebruiker instance = new Gebruiker("", "", "", "", "", "", "", "");
        assertEquals(instance.getBio(), "");
        
        instance.setBio(bio);
        assertEquals(instance.getBio(), bio);
        
        instance.setBio(null);
        assertNull(instance.getBio());
    }

    /**
     * Test of getWebsite method, of class Gebruiker.
     */
    @Test
    public void testGetWebsite() {
        System.out.println("getWebsite");
        Gebruiker instance = new Gebruiker();
        assertNull(instance.getWebsite());
        
        String website = "test.com";
        Gebruiker instance2 = new Gebruiker("", "", "", "", "", "", "test.com", "");
        assertEquals(instance2.getWebsite(), website);
    }

    /**
     * Test of setWebsite method, of class Gebruiker.
     */
    @Test
    public void testSetWebsite() {
        System.out.println("setWebsite");
        String website = "test.com";
        Gebruiker instance = new Gebruiker("", "", "", "", "", "", "", "");
        assertEquals(instance.getWebsite(), "");
        
        instance.setWebsite(website);
        assertEquals(instance.getWebsite(), website);
        
        instance.setWebsite(null);
        assertNull(instance.getWebsite());
    }

    /**
     * Test of getLocation method, of class Gebruiker.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        Gebruiker instance = new Gebruiker();
        assertNull(instance.getLocation());
        
        String location = "Eindhoven";
        Gebruiker instance2 = new Gebruiker("", "", "", "", "", "", "", "Eindhoven");
        assertEquals(instance2.getLocation(), location);
    }

    /**
     * Test of setLocation method, of class Gebruiker.
     */
    @Test
    public void testSetLocation() {
        System.out.println("setLocation");
        String location = "Eindhoven";
        Gebruiker instance = new Gebruiker("", "", "", "", "", "", "", "");
        assertEquals(instance.getLocation(), "");
        
        instance.setLocation(location);
        assertEquals(instance.getLocation(), location);
        
        instance.setLocation(null);
        assertNull(instance.getLocation());
    }

    /**
     * Test of getFollowing method, of class Gebruiker.
     */
    @Test
    public void testGetFollowingAndMakeFollow() {
        System.out.println("getFollowing");
        
        Gebruiker instance = new Gebruiker();
        Gebruiker a = new Gebruiker();
        
        instance.makeFollow(a);
        
        assertEquals(instance.getFollowing().size(), 1);
        
        //Test if you can add duplicates to following
        instance.makeFollow(a);
        assertEquals(instance.getFollowing().size(), 1);
        
        instance.makeFollow(null);
        assertEquals(instance.getFollowing().size(), 1);
    }

    /**
     * Test of makeUnfollow method, of class Gebruiker.
     */
    @Test
    public void testMakeUnfollow() {
        System.out.println("makeUnfollow");
        
        Gebruiker instance = new Gebruiker();
        Gebruiker a = new Gebruiker();
        
        instance.makeFollow(a);
        assertEquals(instance.getFollowing().size(), 1);
        instance.makeUnfollow(null);
        assertEquals(instance.getFollowing().size(), 1);
        instance.makeUnfollow(a);
        assertEquals(instance.getFollowing().size(), 0);
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
