package rest;

import domain.Kweet;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
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
    @Path("getkweet/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Kweet> getKweet(@PathParam("id") int id){
        return kweetService.getKweet(id);
    }
    
    @GET
    @Path("getgebruikerkweets/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Kweet> getGebruikerKweets(@PathParam("email") String email){
        return kweetService.getGebruikerKweets(email, 10);
    }
}
