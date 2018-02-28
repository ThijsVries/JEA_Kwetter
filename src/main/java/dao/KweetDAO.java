package dao;

import domain.Gebruiker;
import domain.Kweet;
import java.util.List;


public interface KweetDAO {
    
    Kweet getKweet (int id);
    
    List<Kweet> getAllKweets();
    
    void setKweetMentions(List<Gebruiker> mentions, Kweet kweet);
    
    void likeKweet(Gebruiker gebruiker, Kweet kweet);
    
    List<Gebruiker> getLikes(Kweet kweet);
    
    List<Gebruiker> getMentions(Kweet kweet);
    
    List<Kweet> getGebruikerKweets(Gebruiker gebruiker);
    
    void createKweet(Gebruiker gebruiker, String message);
    
    void deleteKweet(int id);
    
    void updateKweet(Kweet kweet);
}
