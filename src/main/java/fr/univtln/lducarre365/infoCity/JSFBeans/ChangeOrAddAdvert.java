package fr.univtln.lducarre365.infoCity.JSFBeans;

import fr.univtln.lducarre365.infoCity.business.Advert;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by tomtom on 09/11/17.
 */

@ManagedBean
@SessionScoped
public class ChangeOrAddAdvert implements Serializable{
    @EJB
    private JSFModel jsfModel;

    @PostConstruct
    public void init() {
        System.out.println("TIMEZONE "+TimeZone.getDefault());
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+1"));
        System.out.println("TIMEZONE "+TimeZone.getDefault());
    }

    public String printAdvert(){
        return jsfModel.getAdvert().toString();
    }

    public String setAdvertTitle(){
        return "mainPage";
    }

    public String getTitle(){
        return jsfModel.getAdvert().getTitle();
    }
    public void setTitle(String title){
        jsfModel.getAdvert().setTitle(title);
    }


    public String getType(){
        return jsfModel.getAdvert().getType();
    }
    public void setType(String type){
        type = type.toUpperCase();
        jsfModel.getAdvert().setType(type);
    }



    public Date getDate(){
        return jsfModel.getAdvert().getDate();
    }
    public void setDate(Date date){
        jsfModel.getAdvert().setDate(date);
    }


    public String getLocation(){
        return jsfModel.getAdvert().getLocation();
    }
    public void setLocation(String location){
        jsfModel.getAdvert().setLocation(location);
    }


    public String getMessage(){
        return jsfModel.getAdvert().getMessage();
    }
    public void setMessage(String message){
        jsfModel.getAdvert().setMessage(message);
    }

    public void validate(){
        try {
            jsfModel.putAdvert();
            FacesContext.getCurrentInstance().getExternalContext().redirect("mainPage.jsf");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(){
        try {
            jsfModel.deleteAdvert();
            FacesContext.getCurrentInstance().getExternalContext().redirect("mainPage.jsf");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
