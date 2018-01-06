package fr.univtln.lducarre365.infoCity.JSFBeans;

/**
 * Created by tomtom on 04/01/18.
 */

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.univtln.lducarre365.infoCity.business.Advert;
import org.primefaces.event.SelectEvent;



@ManagedBean
@SessionScoped
public class MainPage implements Serializable{

    @EJB
    private JSFModel jsfModel;

    @Inject
    private Advert advert;

    public List<Advert> getAdverts() {
        return jsfModel.getAdverts();
    }

    public String getTownName() {
        return jsfModel.getTown().getName();
    }

    public void createAdvert(){
        try {
            jsfModel.setAdvert(this.advert);
            FacesContext.getCurrentInstance().getExternalContext().redirect("changeOrAddAdvert.jsf");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setAdverts(List<Advert> adverts) {
        jsfModel.setAdverts(adverts);
    }

    public void onSelect(SelectEvent event) {
        try {
            System.out.println("VTFFFFFFFFFFFFFFFFFFFFFFFF "+event.getObject().getClass());
            jsfModel.setAdvert((Advert) event.getObject());
            FacesContext.getCurrentInstance().getExternalContext().redirect("changeOrAddAdvert.jsf");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
