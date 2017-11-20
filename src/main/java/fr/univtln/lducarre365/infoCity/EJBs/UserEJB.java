package fr.univtln.lducarre365.infoCity.EJBs;

import fr.univtln.lducarre365.infoCity.business.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by tomtom on 14/11/17.
 */
@Path("/user")
@Stateless
public class UserEJB {
    @Inject
    User user;

    @GET
    @Produces("text/plain")
    public String getAdvert(){
        return this.user.toString();
    }
}
