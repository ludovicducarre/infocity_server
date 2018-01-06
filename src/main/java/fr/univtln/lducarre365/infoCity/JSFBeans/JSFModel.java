package fr.univtln.lducarre365.infoCity.JSFBeans;

import fr.univtln.lducarre365.infoCity.RestEJBs.AdvertEJB;
import fr.univtln.lducarre365.infoCity.business.Advert;
import fr.univtln.lducarre365.infoCity.business.Town;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.persistence.*;
import java.beans.ConstructorProperties;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomtom on 04/01/18.
 */
@Singleton
public class JSFModel {

    private Town town;
    private Advert advert;
    private List<Advert> adverts;

    @PersistenceContext(unitName = "infocityPersistence")
    EntityManager em;

    @PostConstruct
    public void init() {
        long id = 3;
        this.town = em.find(Town.class,id);
        refresh();
    }

    public Town getTown() {
        return town;
    }

    public Advert getAdvert() {
        return advert;
    }

    public void setAdvert(Advert advert) {
        this.advert = advert;
    }

    public List<Advert> getAdverts() {
        return adverts;
    }

    public void setAdverts(List<Advert> adverts) {
        this.adverts = adverts;
    }

    public void putAdvert(){
        advert.setTown(town);
        em.merge(advert);
        refresh();
    }
    public void refresh(){
        String town_name = this.town.getName();
        TypedQuery<Advert> q = (TypedQuery<Advert>) em.createQuery("SELECT a FROM Advert AS a WHERE a.town.name = :town_name ", Advert.class);
        q.setParameter("town_name", town_name);
        adverts = q.getResultList();
    }

    public void deleteAdvert(){
        this.em.createQuery("DELETE FROM Advert WHERE id = "+Long.toString(this.advert.getId())).executeUpdate();
        refresh();
    }
}
