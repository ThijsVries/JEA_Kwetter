
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({@NamedQuery(name = "Kweet.getKweetById", query = "SELECT k FROM Kweet k WHERE k.id LIKE :id"),
               @NamedQuery(name = "Kweet.getGebruikerKweets", query = "SELECT k FROM Kweet k WHERE k.ownedBy = (SELECT g.id FROM Gebruiker g WHERE g.email = :email) ORDER BY k.date"),
               @NamedQuery(name = "Kweet.getGebruikerKweetsById", query = "SELECT k FROM Kweet k WHERE k.ownedBy = :id"),
               @NamedQuery(name = "Kweet.getRecentkweets", query = "SELECT k FROM Kweet k ORDER BY k.date DESC")})
public class Kweet implements Serializable{
    
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String message;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private List<String> tags = new ArrayList();
    @ManyToOne
    private Gebruiker ownedBy;
    @OneToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "kweet_likes")
    private List<Gebruiker> likes = new ArrayList();
    @OneToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "kweet_mentioned")
    private List<Gebruiker> mentioned = new ArrayList();
    
    public long getId(){
        return this.id;
    }
    
    public void setId(long id){
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Gebruiker getOwnedBy() {
        return ownedBy;
    }

    public List<Gebruiker> getLikes() {
        return likes;
    }

    public List<Gebruiker> getMentioned() {
        return mentioned;
    }

    public void setMentioned(List<Gebruiker> mentioned) {
        this.mentioned = mentioned;
    }
    
    public Kweet(){
        
    }
    
    public Kweet(Gebruiker gebruiker, String message){
        this.ownedBy = gebruiker;
        this.message = message;
    }
    
    public Kweet(Gebruiker gebruiker, String message, Date date){
        this.ownedBy = gebruiker;
        this.message = message;
        this.date = date;
    }
    
    /**
     * Likes the selected kweet.
     * @param gebruiker The user liking the kweet.
     */
    public void like(Gebruiker gebruiker){
        if(gebruiker == null){
            return;
        }
        
        if(!likes.contains(gebruiker)){
            likes.add(gebruiker);
        }
    }
    
    /**
     * Unlikes the selected kweet.
     * @param gebruiker The user unliking the kweet.
     */
    public void unlike(Gebruiker gebruiker){
        if(gebruiker == null){
            return;
        }
        if(likes.contains(gebruiker)){
           likes.remove(gebruiker);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.message);
        hash = 97 * hash + Objects.hashCode(this.date);
        hash = 97 * hash + Objects.hashCode(this.tags);
        hash = 97 * hash + Objects.hashCode(this.ownedBy);
        hash = 97 * hash + Objects.hashCode(this.likes);
        hash = 97 * hash + Objects.hashCode(this.mentioned);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        
        if(obj == null){
            return false;
        }
        
        if(getClass() != obj.getClass()){
            return false;
        }
        
        final Kweet other = (Kweet)obj;
        if(!Objects.equals(this.message, other.message)){
            return false;
        }
        
        if(!Objects.equals(this.date, other.date)){
            return false;
        }

        if(!Objects.equals(this.ownedBy, other.ownedBy)){
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "Kweet{" + "id=" + id + ", message=" + message + ", date=" + date + ", tags=" + tags + ", ownedBy=" + ownedBy + ", likes=" + likes + ", mentioned=" + mentioned + '}';
    }
    
    
}
