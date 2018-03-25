package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({@NamedQuery(name = "Gebruiker.getAllGebruikers", query = "SELECT g FROM Gebruiker g"),
               @NamedQuery(name = "Gebruiker.getByMail", query = "SELECT g FROM Gebruiker g WHERE g.email LIKE :email"),
               @NamedQuery(name = "Gebruiker.getById", query = "SELECT g FROM Gebruiker g WHERE g.id LIKE :id"),
               @NamedQuery(name = "Gebruiker.getByName", query = "SELECT g FROM Gebruiker g WHERE g.firstName LIKE :firstName")})
public class Gebruiker implements Serializable{
    
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String profilePicture;
    private String password;
    
    private String bio;
    private String website;
    private String location;
    
    
    //TODO: change to ManyToMany
    @OneToMany(cascade = CascadeType.PERSIST)
    private final List<Gebruiker> following = new ArrayList();
    
    @OneToMany(cascade = CascadeType.ALL)
    private final List<Kweet> kweets = new ArrayList();
    
    @ManyToMany(mappedBy = "gebruikers", cascade = ALL)
    private List<GebruikerGroup> gebruikerGroups = new ArrayList();
    
    // <editor-fold defaultstate="collapsed" desc="Properties"> 
    
    @JsonbTransient
    public List<GebruikerGroup> getGebruikerGroups() {
        return gebruikerGroups;
    }
    
    public long getId(){
        return this.id;
    }
    
    public void setId(long id){
        this.id = id;
    }
    
    @JsonbTransient
    public List<Kweet> getKweets(){
        return this.kweets;
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

    @JsonbTransient
    public List<Gebruiker> getFollowing() {
        return following;
    }
    // </editor-fold>
    
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
    
    public Gebruiker(String firstName, String lastName, String email, String profilePicture, String password, String bio, String website, String location, GebruikerGroup group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.profilePicture = profilePicture;
        this.password = password;
        this.bio = bio;
        this.website = website;
        this.location = location;
        this.addGebruikerGroup(group);
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
    
    // <editor-fold defaultstate="collapsed" desc="Old user role code"> 
    /**
     * Promotes the selected user's role to one above the current one.
     */
//    public void promoteUser(){
//        switch(this.role){
//            case USER:
//                this.role = GebruikerRole.MOD;
//                break;
//            case MOD:
//                this.role = GebruikerRole.ADMIN;
//                break;
//            case ADMIN:
//                break;
//            default:
//                break;
//        }
//    }
//    
//    /**
//     * Demotes the selected user's role to one below the current one.
//     */
//    public void demoteUser(){
//        switch(this.role){
//            case MOD:
//                this.role = GebruikerRole.USER;
//                break;
//            case ADMIN:
//                this.role = GebruikerRole.MOD;
//                break;
//            default:
//                break;
//        }
//    }

    //</editor-fold>
    
    public void addGebruikerGroup(GebruikerGroup group){
        if(!this.gebruikerGroups.contains(group)){
            this.gebruikerGroups.add(group);
            group.addGebruikerToUserGroup(this);
        }
    }
    
    public void removeGebruikerGroup(GebruikerGroup group){
        if(this.gebruikerGroups.contains(group)){
            this.gebruikerGroups.remove(group);
            group.removeGebruikerFromUserGroup(this);
        }
    }
    
    public String getGebruikerGroupsToString(){
        if(this.gebruikerGroups.size() > 0){
            StringBuilder sb = new StringBuilder();
            for(GebruikerGroup gg : this.getGebruikerGroups()){
                sb.append(gg.getGroupName());
                sb.append(" - ");
            }
            
            return sb.toString();
        }else{
            return "None";
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

    @Override
    public String toString() {
        return "Gebruiker{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", profilePicture=" + profilePicture + ", password=" + password + ", bio=" + bio + ", website=" + website + ", location=" + location + '}';
    }
}
