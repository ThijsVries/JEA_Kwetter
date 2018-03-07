package dao;

import domain.Gebruiker;
import domain.Kweet;
import java.util.List;


public interface KweetDAO {
    
    List<Kweet> getKweet (int id);
    
    List<Kweet> getRecentKweets(int limit);
    
    void addKweetMention(Gebruiker gebruiker, Kweet kweet);
    
    void removeKweetMention(Gebruiker gebruiker, Kweet kweet);
    
    void addTag(String tag, Kweet kweet);
    
    void removeTag(String tag, Kweet kweet);
    
    void likeKweet(Gebruiker gebruiker, Kweet kweet);
    
    void unlikeKweet(Gebruiker gebruiker, Kweet kweet);
    
    List<Gebruiker> getLikes(Kweet kweet);
    
    List<Gebruiker> getMentions(Kweet kweet);
    
    List<Kweet> getGebruikerKweets(String email, int limit);
    
    void createKweet(int gebruikerid, String content);
    
    void deleteKweet(Kweet kweet);
    
    void updateKweet(Kweet kweet);
}
