package dao;

import domain.Gebruiker;
import domain.Kweet;
import java.util.List;


public interface KweetDAO {
    
    Kweet getKweet (int id);
    
    List<Kweet> getAllKweets();
    
    void setKweetMentions(List<Gebruiker> mentions, Kweet kweet);
    
    boolean likeKweet(Gebruiker gebruiker, Kweet kweet);
    
    List<Gebruiker> getLikes(Kweet kweet);
    
    List<Gebruiker> getMentions(Kweet kweet);
    
    List<Kweet> getGebruikerKweets(Gebruiker gebruiker);
    
    boolean createKweet(Gebruiker gebruiker, String message);
    
    boolean deleteKweet(int id);
    
    boolean updateKweet(int id);
}
