package boundary.controllers;

import domain.Gebruiker;
import domain.GebruikerRole;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import service.GebruikerService;

@Named
@SessionScoped
public class GebruikerController implements Serializable{

    @Inject
    private GebruikerService gebruikerService;
    
    private String userMail;
    private String password;

    public String getUserName() {
        return userMail;
    }

    public void setUserName(String userName) {
        this.userMail = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public GebruikerController(){
        
    }
    
    @PostConstruct
    public void init(){
        
    }
    
    public String logIn(){
        Gebruiker gebruiker = gebruikerService.getGebruikerByEmail(userMail).get(0);
        if(userMail.equals(gebruiker.getEmail()) && password.equals(gebruiker.getPassword())){
            if(gebruiker.getGebruikerRole() == GebruikerRole.ADMIN || gebruiker.getGebruikerRole() == GebruikerRole.MOD){
                return "adminPanel";
            }else{
                return "gebruikerPage";
            }
        }
        else{
            return "login";
        }
    }
    
    public List<Gebruiker> getAllGebruikers(){
        List<Gebruiker> gebruikers = gebruikerService.getAllGebruikers();
        return gebruikers;
    }
}
