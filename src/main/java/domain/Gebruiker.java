package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Gebruiker implements Serializable{
    
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String profilePicture;
    private String password;
    
    private String bio;
    private String website;
    private String location;
    
    
    private GebruikerRole role = GebruikerRole.USER;
    
    @OneToMany
    private List<Gebruiker> following = new ArrayList();
    
    @OneToMany
    private List<Kweet> kweets = new ArrayList();
    
    public GebruikerRole getGebruikerRole(){
        return role;
    }
    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Gebruiker> getFollowing() {
        return following;
    }
     
    public Gebruiker(){
        
    }
    
    public Gebruiker(String email, String password){
        this.email = email;
        this.password = password;
    }

    public Gebruiker(String firstName, String lastName, String email, String profilePicture, String password, String bio, String website, String location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.profilePicture = profilePicture;
        this.password = password;
        this.bio = bio;
        this.website = website;
        this.location = location;
    }
    
    /**
     * Makes this user follow the given user.
     * @param gebruiker the given user TO follow
     */
    public void makeFollow(Gebruiker gebruiker){
        if(this.following == null){
            return;
        }
        if(gebruiker == null){
            return;
        }
        if(!this.following.contains(gebruiker)){
                this.following.add(gebruiker);
        }
    }
    
    /**
     * Makes this user ufollow the given user
     * @param gebruiker the given user TO unfollow
     */
    public void makeUnfollow(Gebruiker gebruiker){
        if(this.following == null){
            return;
        }
        if(gebruiker == null){
            return;
        }
        if(this.following.contains(gebruiker)){
            this.following.remove(gebruiker);
        }
    }
    
    /**
     * Promotes the selected user's role to one above the current one.
     */
    public void promoteUser(){
        switch(this.role){
            case USER:
                this.role = GebruikerRole.MOD;
                break;
            case MOD:
                this.role = GebruikerRole.ADMIN;
                break;
            case ADMIN:
                break;
            default:
                break;
        }
    }
    
    /**
     * Demotes the selected user's role to one below the current one.
     */
    public void demoteUser(){
        switch(this.role){
            case MOD:
                this.role = GebruikerRole.USER;
                break;
            case ADMIN:
                this.role = GebruikerRole.MOD;
                break;
            default:
                break;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.firstName);
        hash = 29 * hash + Objects.hashCode(this.lastName);
        hash = 29 * hash + Objects.hashCode(this.email);
        hash = 29 * hash + Objects.hashCode(this.profilePicture);
        hash = 29 * hash + Objects.hashCode(this.password);
        hash = 29 * hash + Objects.hashCode(this.bio);
        hash = 29 * hash + Objects.hashCode(this.website);
        hash = 29 * hash + Objects.hashCode(this.location);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Gebruiker other = (Gebruiker) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
        
    }
    
    
    
    
    
    
    
    
}
