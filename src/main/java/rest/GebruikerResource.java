package rest;

import domain.Gebruiker;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
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
    @Path("getbyemail/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Gebruiker> getGebruikerByEmail(@PathParam("email") String email){
        return gebruikerService.getGebruikerByEmail(email);
    }
    
    @GET
    @Path("getbyname/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Gebruiker> getGebruikerByName(@PathParam("name") String name){
        return gebruikerService.getGebruikerByName(name);
    }
    
    
    
    
}
