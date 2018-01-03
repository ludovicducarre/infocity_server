package fr.univtln.lducarre365.infoCity.EJBs;

import fr.univtln.lducarre365.infoCity.business.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by tomtom on 14/11/17.
 */
@Path("/user")
@Stateless
public class UserEJB {
    @Inject
    User user;

    @PersistenceContext(unitName = "infocityPersistence")
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(){
        //user.setId(1);
        long id =1;
        this.em.persist(user);
        return em.find(User.class,id);
    }
}
