package EJBs;
import business.Advert;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import java.io.Serializable;

/**
 * Created by tomtom on 09/11/17.
 */

@Named
@SessionScoped
public class AdvertManager implements Serializable{

    @Inject private Advert advert;

    private String newTitle;

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }

    public String printAdvert(){
        return this.advert.toString();
    }

    public String setAdvertTitle(){
        this.advert.setTitle(this.newTitle);
        return "mainPage";
    }


    public String getAdvert(){
        return this.advert.toString();
    }

}
