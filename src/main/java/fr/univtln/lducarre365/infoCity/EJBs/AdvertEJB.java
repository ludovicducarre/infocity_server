package fr.univtln.lducarre365.infoCity.EJBs;

import fr.univtln.lducarre365.infoCity.business.Advert;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

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
    @Path("/id/{id}")
    public Advert getAdvertById(@PathParam("id") long id){
        advert = em.find(Advert.class, id);
        return advert;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/townName/{name}")
    public List<Advert> getAdvertsByTown(@PathParam("name") String town_name){
        TypedQuery<Advert> q = (TypedQuery<Advert>) em.createQuery("SELECT a FROM Advert AS a WHERE a.town.name = :town_name ", Advert.class);
        //TypedQuery<Advert> q = (TypedQuery<Advert>) em.createQuery("SELECT advert FROM Advert advert JOIN advert.town town WHERE advert.town.name = :town_name ", Advert.class);
        q.setParameter("town_name", town_name);
        List<Advert> results = q.getResultList();
        return results;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Advert> getAdverts(){
        Query q = em.createQuery("SELECT advert FROM Advert advert", Advert.class);
        List<Advert> results = q.getResultList();
        return results;
    }

}
