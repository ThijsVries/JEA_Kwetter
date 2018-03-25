package domain;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({@NamedQuery(name = "GebruikerGroup.getByName", query = "SELECT gp FROM GebruikerGroup gp WHERE gp.groupName LIKE :groupname"),
               @NamedQuery(name = "GebruikerGroup.getAll", query = "SELECT gp FROM GebruikerGroup gp")})
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
    @JoinTable(name = "GEBRUIKER_GROUP", 
            joinColumns = @JoinColumn(name = "groupName", referencedColumnName = "groupName"), 
            inverseJoinColumns = @JoinColumn(name = "email", referencedColumnName = "email"))
    private List<Gebruiker> gebruikers = new ArrayList();
    
    public GebruikerGroup(){
        
    }
    
    public GebruikerGroup(String groupName){
        this.groupName = groupName;
    }
    
    public void addGebruikerToUserGroup(Gebruiker gebruiker){
        this.gebruikers.add(gebruiker);
    }
    
    public void removeGebruikerFromUserGroup(Gebruiker gebruiker){
        this.gebruikers.remove(gebruiker);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.groupName);
        hash = 17 * hash + Objects.hashCode(this.gebruikers);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null){
            GebruikerGroup temp = (GebruikerGroup) obj;
            return this.getGroupName().equals(temp.getGroupName());
        }
        return false;
    }
    
    

    @Override
    public String toString() {
        return this.groupName;
    }
}
