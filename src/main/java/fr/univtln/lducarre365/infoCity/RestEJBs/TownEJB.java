package fr.univtln.lducarre365.infoCity.RestEJBs;

import fr.univtln.lducarre365.infoCity.business.Advert;
import fr.univtln.lducarre365.infoCity.business.Town;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;


/**
 * Created by tomtom on 14/11/17.
 */

@Path("/town")
@Stateless
public class TownEJB {

    private static final Logger LOGGER = Logger.getLogger(TownEJB.class.getName());

    @Inject
    Advert advert, advert2, advert1;
    @Inject
    Town town, town2, town3, town4, town5;
    @PersistenceContext(unitName = "infocityPersistence")
    EntityManager em;

    @GET
    @Path("/create")
    @Produces(MediaType.TEXT_PLAIN)
     public String remplir(){
        LOGGER.info("############ TEST ############### dans la fonction remplir");
        Town town1 = new Town();town1.setName("Sollies Pont");
        town1.setState("France"); town1.setCountry("PACA"); town1.setId(123456);


        town.setId(1); town.setState("France"); town.setName("Toulon"); town.setCountry("PACA");
        town2.setId(2); town2.setState("France"); town2.setName("La Valette"); town2.setCountry("PACA");
        town3.setId(3); town3.setState("France"); town3.setName("La Garde"); town3.setCountry("PACA");
        town4.setId(4); town4.setState("France"); town4.setName("Le Pradet"); town4.setCountry("PACA");
        town5.setId(5); town5.setState("France"); town5.setName("La Farlede"); town5.setCountry("PACA");


        advert.setMessage("helloww");
        advert.setTitle("Réunion des 0 - 3 ans");
        advert.setTown(town1);

        advert2.setTitle("Concours Ping pong");
        advert2.setMessage("Concours ouvert à tous les ages, venez tenter de remporter" +
                "un téléviseur!");advert2.setTown(town3);
        advert1.setTitle("Concours Biere pong");
        advert1.setMessage("Concours ouvert à tous les ages, venez tenter de remporter" +
                "une femme!");advert1.setTown(town3); advert1.setType("Sport");


        advert.setTown(town1);
        em.persist(advert);
        em.persist(advert1);
        em.persist(advert2);
        em.persist(town1);
        em.persist(town2);
        em.persist(town3);
        em.persist(town4);
        em.persist(town5);
        em.persist(town);

       LOGGER.info("############ TEST ############### " +   advert.getTown().toString());

       return "Création de " + town1.toString() + " et " + advert.toString() + ".";
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Town> getTowns(){
        long id =1;
        TypedQuery<Town> query =
                em.createNamedQuery("Town.findAll", Town.class);
        List<Town> results = query.getResultList();
        return results;
    }

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Town getTownById(@PathParam("id") long town_id){
        Town parameters = em.find(Town.class,town_id);
        LOGGER.info("Récupération d'une ville par id = " + town_id + " " + parameters.toString());

        return parameters;
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Town town){
        em.persist(town);
        LOGGER.info("Création d'une ville  : nom = " + town.getName() + " " + town.toString());
        return Response.status(200).build();
    }

    /*@PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void addTown(Town town) throws Exception {
        entityManager.persist(town);
    }*/
}
