package dao;

import domain.Gebruiker;
import domain.Kweet;
import java.util.List;


public interface KweetDAO {
    
    Kweet getKweet (int id);
    
    List<Kweet> getRecentKweets(int limit);
    
    void setKweetMentions(List<Gebruiker> mentions, Kweet kweet);
    
    void likeKweet(Gebruiker gebruiker, Kweet kweet);
    
    List<Gebruiker> getLikes(Kweet kweet);
    
    List<Gebruiker> getMentions(Kweet kweet);
    
    List<Kweet> getGebruikerKweets(Gebruiker gebruiker, int limit);
    
    void createKweet(Gebruiker gebruiker, String message);
    
    void deleteKweet(Kweet kweet);
    
    void updateKweet(Kweet kweet);
}
