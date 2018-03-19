package domain;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "gebruikerGroup")
@NamedQueries({@NamedQuery(name = "GebruikerGroup.getByName", query = "SELECT gp FROM GebruikerGroup gp WHERE gp.groupName LIKE :groupname")})
public class GebruikerGroup implements Serializable{

    @Id
    private String groupName;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Gebruiker> getGebruikers() {
        return gebruikers;
    }

    public void setGebruikers(List<Gebruiker> gebruikers) {
        this.gebruikers = gebruikers;
    }
    
    @ManyToMany
    @JoinTable(name = "GEBRUIKER_GROUP", joinColumns = @JoinColumn(name = "groupName", referencedColumnName = "groupName"), inverseJoinColumns = @JoinColumn(name = "email",
    referencedColumnName = "email"))
    private List<Gebruiker> gebruikers;
    
    public GebruikerGroup(){
        
    }
    
    public GebruikerGroup(String groupName){
        this.groupName = groupName;
    }
    
    public void AddGebruikerToUserGroup(Gebruiker gebruiker){
        this.gebruikers.add(gebruiker);
    }
}
