package boundary.controllers;

import domain.Gebruiker;
import domain.GebruikerGroup;
import domain.GebruikerRole;
import domain.Kweet;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import service.GebruikerService;
import service.KweetService;

@Named
@SessionScoped
public class AdminController implements Serializable{

    @Inject
    private GebruikerService gebruikerService;
    
    @Inject
    private KweetService kweetService;

    private List<GebruikerGroup> gebruikerGroups;
    private String selectedGroup;
    
    private List<Gebruiker> allGebruikers;
    private Gebruiker selectedGebruiker;
    
    private List<Kweet> allKweets;
    private Kweet selectedKweet;

    public List<Kweet> getAllKweets() {
        return allKweets;
    }

    public void setAllKweets(List<Kweet> allKweets) {
        this.allKweets = allKweets;
    }

    public Kweet getSelectedKweet() {
        return selectedKweet;
    }

    public void setSelectedKweet(Kweet selectedKweet) {
        this.selectedKweet = selectedKweet;
    }
    
    public Gebruiker getSelectedGebruiker() {
        return selectedGebruiker;
    }

    public void setSelectedGebruiker(Gebruiker selectedGebruiker) {
        this.selectedGebruiker = selectedGebruiker;
    }

    public String getSelectedGroup() {
        return selectedGroup;
    }

    public void setSelectedGroup(String selectedGroup) {
        this.selectedGroup = selectedGroup;
    }

    public List<GebruikerGroup> getGebruikerGroups() {
        return gebruikerGroups;
    }

    public void setGebruikerGroups(List<GebruikerGroup> gebruikerGroups) {
        this.gebruikerGroups = gebruikerGroups;
    }
    
    public AdminController(){
        
    }
    
    @PostConstruct
    public void init(){
        gebruikerGroups = gebruikerService.getAllGebruikerGroups();
        allKweets = kweetService.getRecentKweets(2000);
    }
    
    public void promoteGebruiker(){
        System.out.println("yo");
        if(selectedGebruiker != null && selectedGroup != null){
            GebruikerGroup managedGroup = gebruikerService.getGebruikerGroup(selectedGroup);
            selectedGebruiker.addGebruikerGroup(managedGroup);
            
            gebruikerService.updateGebruikerGroup(managedGroup);
            gebruikerService.updateGebruiker(selectedGebruiker);
            
            gebruikerGroups = gebruikerService.getAllGebruikerGroups();
        }
    }
    
    public void demoteGebruiker(){
        if(selectedGebruiker != null && selectedGroup != null){
            GebruikerGroup managedGroup = gebruikerService.getGebruikerGroup(selectedGroup);
            selectedGebruiker.removeGebruikerGroup(managedGroup);
            
            gebruikerService.updateGebruikerGroup(managedGroup);
            gebruikerService.updateGebruiker(selectedGebruiker);
            
            gebruikerGroups = gebruikerService.getAllGebruikerGroups();
        }
    }
    
    public List<Gebruiker> getAllGebruikers(){
        allGebruikers = gebruikerService.getAllGebruikers();
        return allGebruikers;
    }
}
