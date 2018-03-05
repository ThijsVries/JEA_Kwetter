package rest;

import domain.Kweet;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import service.KweetService;

@Stateless
@Path("kweet")
public class KweetResource {

    @Inject
    KweetService kweetService;
    
    @GET
    @Path("kweet/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Kweet> getKweet(@PathParam("id") int id){
        return kweetService.getKweet(id);
    }
    
    @GET
    @Path("recent/{limit}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Kweet> getRecentKweets(@PathParam("limit") int limit){
        return kweetService.getRecentKweets(limit);
    }
    
    @GET
    @Path("gebruikerkweets/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Kweet> getGebruikerKweets(@PathParam("email") String email){
        return kweetService.getGebruikerKweets(email, 10);
    }
    
    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addKweet(Kweet kweet){
        kweetService.addKweet(kweet);
    }
    
    @POST
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateKweet(Kweet kweet){
        kweetService.updateKweet(kweet);
    }
    
    @POST
    @Path("delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteKweet(Kweet kweet){
        kweetService.deleteKweet(kweet);
    }
}
