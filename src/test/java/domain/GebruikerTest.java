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
        assertEquals(expResult2, instance2.getFirstName());
    }

    /**
     * Test of setFirstName method, of class Gebruiker.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        
        String firstName = "Jan";
        Gebruiker instance = new Gebruiker("", "", "", "", "", "", "", "");
        assertEquals("", instance.getFirstName());
        instance.setFirstName(firstName);
        assertEquals(firstName, instance.getFirstName());
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
        assertEquals(lastName, instance2.getLastName());
    }

    /**
     * Test of setLastName method, of class Gebruiker.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "Pietje";
        Gebruiker instance = new Gebruiker("", "", "", "", "", "", "", "");
        assertEquals("", instance.getLastName());
        instance.setLastName(lastName);
        assertEquals(lastName, instance.getLastName());
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
        assertEquals(email, instance2.getEmail());
    }

    /**
     * Test of setEmail method, of class Gebruiker.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "mail@mail.com";
        Gebruiker instance = new Gebruiker("", "", "", "", "", "", "", "");
        assertEquals("", instance.getEmail());
        
        instance.setEmail(email);
        assertEquals(email, instance.getEmail());
        
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
        assertEquals(profilePicture, instance2.getProfilePicture());
    }

    /**
     * Test of setProfilePicture method, of class Gebruiker.
     */
    @Test
    public void testSetProfilePicture() {
        System.out.println("setProfilePicture");
        String profilePicture = "test.jpg";
        Gebruiker instance = new Gebruiker("", "", "", "", "", "", "", "");
        assertEquals("", instance.getProfilePicture());
        
        instance.setProfilePicture(profilePicture);
        assertEquals(profilePicture, instance.getProfilePicture());
        
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
        assertEquals(password, instance2.getPassword());
    }

    /**
     * Test of setPassword method, of class Gebruiker.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "password";
        Gebruiker instance = new Gebruiker("", "", "", "", "", "", "", "");
        assertEquals("", instance.getPassword());
        
        instance.setPassword(password);
        assertEquals(password, instance.getPassword());
        
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
        assertEquals(bio, instance2.getBio());
    }

    /**
     * Test of setBio method, of class Gebruiker.
     */
    @Test
    public void testSetBio() {
        System.out.println("setBio");
        String bio = "bla";
        Gebruiker instance = new Gebruiker("", "", "", "", "", "", "", "");
        assertEquals("", instance.getBio());
        
        instance.setBio(bio);
        assertEquals(bio, instance.getBio());
        
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
        assertEquals(website, instance2.getWebsite());
    }

    /**
     * Test of setWebsite method, of class Gebruiker.
     */
    @Test
    public void testSetWebsite() {
        System.out.println("setWebsite");
        String website = "test.com";
        Gebruiker instance = new Gebruiker("", "", "", "", "", "", "", "");
        assertEquals("", instance.getWebsite());
        
        instance.setWebsite(website);
        assertEquals(website, instance.getWebsite());
        
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
        assertEquals(location, instance2.getLocation());
    }

    /**
     * Test of setLocation method, of class Gebruiker.
     */
    @Test
    public void testSetLocation() {
        System.out.println("setLocation");
        String location = "Eindhoven";
        Gebruiker instance = new Gebruiker("", "", "", "", "", "", "", "");
        assertEquals("", instance.getLocation());
        
        instance.setLocation(location);
        assertEquals(location, instance.getLocation());
        
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
        
        assertEquals(1, instance.getFollowing().size());
        
        //Test if you can add duplicates to following
        instance.makeFollow(a);
        assertEquals(1, instance.getFollowing().size());
        
        instance.makeFollow(null);
        assertEquals(1, instance.getFollowing().size());
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
        assertEquals(1, instance.getFollowing().size());
        instance.makeUnfollow(null);
        assertEquals(1, instance.getFollowing().size());
        instance.makeUnfollow(a);
        assertEquals(0, instance.getFollowing().size());
    }
    
    @Test
    public void testEqualsGebruiker(){
        Gebruiker instance1 = new Gebruiker("test@mail.com", "123");
        Gebruiker instance2 = new Gebruiker("test@mail.com", "123");
        Gebruiker instance3 = new Gebruiker("123@mail.com", "456");
        Gebruiker instance4 = new Gebruiker();
        
        assertTrue(instance1.equals(instance2));
        assertFalse(instance2.equals(instance3));
        assertFalse(instance1.equals(instance4));
        assertFalse(instance4.equals(instance1));
        
    }
    
    
    /**
     * Test of getGebruikerRole method, of class Gebruiker.
     */
    @Test
    public void testGetGebruikerRole() {
        System.out.println("getGebruikerRole");
        Gebruiker instance = new Gebruiker();
        GebruikerRole expResult = GebruikerRole.USER;
        assertEquals(expResult, instance.getGebruikerRole());
    }

    /**
     * Test of promoteUser method, of class Gebruiker.
     */
    @Test
    public void testPromoteUser() {
        System.out.println("promoteUser");
        Gebruiker instance = new Gebruiker();
        instance.promoteUser();
        
        GebruikerRole expResult = GebruikerRole.MOD;
        assertEquals(expResult, instance.getGebruikerRole());
        
        instance.promoteUser();
        expResult = GebruikerRole.ADMIN;
        assertEquals(expResult, instance.getGebruikerRole());
        
        instance.promoteUser();
        assertEquals(expResult, instance.getGebruikerRole());
    }

    /**
     * Test of demoteUser method, of class Gebruiker.
     */
    @Test
    public void testDemoteUser() {
        System.out.println("demoteUser");
        Gebruiker instance = new Gebruiker();
        GebruikerRole expResult = GebruikerRole.MOD;
        
        instance.promoteUser();
        assertEquals(expResult, instance.getGebruikerRole());
        
        instance.promoteUser();
        expResult = GebruikerRole.ADMIN;
        assertEquals(expResult, instance.getGebruikerRole());
        
        instance.demoteUser();
        instance.demoteUser();
        
        expResult = GebruikerRole.USER;
        assertEquals(expResult, instance.getGebruikerRole());
    }
    
    @Test
    public void testHashCode(){
        Gebruiker instance = new Gebruiker();
        
        Kweet testKweet = new Kweet(instance, "123");
        Kweet testKweet2 = new Kweet(instance, "456");
        Kweet testKweet3 = new Kweet(instance, "123");
        
        assertTrue(testKweet.hashCode() == testKweet3.hashCode());
        assertFalse(testKweet.hashCode() == testKweet2.hashCode());
    }
}
