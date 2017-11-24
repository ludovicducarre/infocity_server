package fr.univtln.lducarre365.infoCity.EJBs;

import fr.univtln.lducarre365.infoCity.business.Advert;
import fr.univtln.lducarre365.infoCity.crud.CrudServiceBean;

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
@Path("/advert")
@Stateless
public class AdvertEJB {
    @Inject
    Advert advert;

    @PersistenceContext(unitName = "infocityPersistence")
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Advert getAdvert(){
        advert.setId(1);
        advert.setTitle("test de titre");
        long id =1;
        this.em.persist(advert);
        return em.find(Advert.class,id);
    }
}
