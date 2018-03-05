package rest;

import domain.Gebruiker;
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
import service.GebruikerService;

@Stateless
@Path("gebruiker")
public class GebruikerResource {

    @Inject
    GebruikerService gebruikerService;
    
    @GET
    @Path("byemail/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Gebruiker> getGebruikerByEmail(@PathParam("email") String email){
        return gebruikerService.getGebruikerByEmail(email);
    }
    
    @GET
    @Path("byname/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Gebruiker> getGebruikerByName(@PathParam("name") String name){
        return gebruikerService.getGebruikerByName(name);
    }
    
    @GET
    @Path("followers/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Gebruiker> getGebruikerFollowers(@PathParam("email") String email){
        return gebruikerService.getGebruikerFollowers(email);
    }
    
    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addGebruiker(Gebruiker gebruiker){
        gebruikerService.addGebruiker(gebruiker);
    }
    
    @POST
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateGebruiker(Gebruiker gebruiker){
        gebruikerService.updateGebruiker(gebruiker);
    }
    
    @POST
    @Path("delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteGebruiker(Gebruiker gebruiker){
        gebruikerService.deleteGebruiker(gebruiker);
    }
}
