
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Kweet implements Serializable{
    
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long Id;
    private String message;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private List<String> tags = new ArrayList();
    @ManyToOne
    private Gebruiker ownedBy;
    @OneToMany
    private List<Gebruiker> likes;
    @OneToMany
    private List<Gebruiker> mentioned;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public void setOwnedBy(Gebruiker ownedBy) {
        this.ownedBy = ownedBy;
    }

    public List<Gebruiker> getLikes() {
        return likes;
    }

    public void setLikes(List<Gebruiker> likes) {
        this.likes = likes;
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
    
    /**
     * Likes the selected kweet.
     * @param gebruiker The user liking the kweet.
     */
    public void like(Gebruiker gebruiker){
        if(!likes.contains(gebruiker)){
            likes.add(gebruiker);
        }
    }
    
    /**
     * Unlikes the selected kweet.
     * @param gebruiker The user unliking the kweet.
     */
    public void unlike(Gebruiker gebruiker){
        
    }
    
    
    
    
    
    
    
}
