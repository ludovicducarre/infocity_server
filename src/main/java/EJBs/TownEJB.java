package EJBs;

import business.Advert;
import business.Town;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by tomtom on 14/11/17.
 */

@Path("/town")
@Stateless
public class TownEJB {
    @Inject Town town;

    @GET
    @Produces("text/plain")
    public String getAdvert(){
        return this.town.toString();
    }
}
