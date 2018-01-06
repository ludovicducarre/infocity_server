package fr.univtln.lducarre365.infoCity.JSFBeans;


import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import fr.univtln.lducarre365.infoCity.business.Advert;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

@ManagedBean
@SessionScoped
public class Stats implements Serializable {

    @EJB
    private JSFModel jsfModel;

    private BarChartModel barModel;

    @PostConstruct
    public void init() {
        createBarModel();
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();

        Object [][] advertByMonth = {{"Janvier",0},{"Fevrier",0},{"Mars",0},{"Avril",0},{"Mai",0},{"Juin",0},
                            {"Juillet",0},{"Aout",0},{"Septembre",0},{"Octobre",0},{"Novembre",0},{"Decembre",0}};

        for (Advert advert : jsfModel.getAdverts()){
            advertByMonth[advert.getDate().getMonth()][1] = (Integer)(advertByMonth[advert.getDate().getMonth()][1])+1;
        }

        ChartSeries series = new ChartSeries();
        for (Object[] obj : advertByMonth){
            series.set(obj[0],(Integer)obj[1]);
        }
        model.addSeries(series);

        return model;
    }

    private void createBarModel() {
        barModel = initBarModel();

        barModel.setTitle("nombre d'annonces par mois");

        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Mois");

        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Nombre d'annonces");
        yAxis.setMin(0);
        yAxis.setMax(10);
    }

}