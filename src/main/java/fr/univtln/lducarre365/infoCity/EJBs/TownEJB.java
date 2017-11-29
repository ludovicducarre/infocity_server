package fr.univtln.lducarre365.infoCity.EJBs;

import fr.univtln.lducarre365.infoCity.business.Advert;
import fr.univtln.lducarre365.infoCity.business.Town;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


/**
 * Created by tomtom on 14/11/17.
 */

@Path("/town")
@Stateless
public class TownEJB {
    @Inject
    Town town;

    @PersistenceContext(unitName = "infocityPersistence")
    EntityManager em;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Town getUser(){
        town.setId(1);
        long id =1;
        this.em.persist(town);
        return em.find(Town.class,id);
    }

    /*@PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void addTown(Town town) throws Exception {
        entityManager.persist(town);
    }*/
}
