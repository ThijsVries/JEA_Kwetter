package dao;

import domain.Gebruiker;
import domain.Kweet;
import java.util.List;


public interface KweetDAO {
    
    Kweet getKweet (int id);
    
    List<Kweet> getAllKweets();
    
    boolean createKweet(Gebruiker gebruiker, String message);
    
    boolean deleteKweet(int id);
    
    boolean updateKweet(int id);
}
