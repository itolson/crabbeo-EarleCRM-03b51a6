/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
package com.enterprise.crm.charts;

import java.io.Serializable;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

@Named
@Stateful
@SessionScoped
public class ChartBean implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private CartesianChartModel categoryModel;
    private CartesianChartModel linearModel;
    private PieChartModel pieModel;
    
    public ChartBean() {
        createCategoryModel();
        createLinearModel();
        createPieModel();
    }
    public PieChartModel getPieModel() {
        return pieModel;
    }

    private void createPieModel() {
        pieModel = new PieChartModel();

        pieModel.set("Accountants", 540);
        pieModel.set("Architects", 325);
        pieModel.set("Engineers", 702);
        pieModel.set("D&C", 421);
        pieModel.set("IFA - general", 540);
        pieModel.set("IFA - Pilgrim SIPP", 325);
        pieModel.set("IFA - Keydata", 702);
        pieModel.set("Barristers", 421);
        pieModel.set("Solicitors", 540);
        pieModel.set("Surveyors", 325);
        pieModel.set("Other", 702);
        pieModel.set("D&O", 421);
    }
    public CartesianChartModel getCategoryModel() {
        return categoryModel;
    }

    public CartesianChartModel getLinearModel() {
        return linearModel;
    }

    
    
    private void createCategoryModel() {
        categoryModel = new CartesianChartModel();

        ChartSeries claims = new ChartSeries();
        claims.setLabel("Claims Builders");
        claims.set("2004", 120);
        claims.set("2005", 100);
        claims.set("2006", 44);
        claims.set("2007", 150);
        claims.set("2008", 25);

        ChartSeries sols = new ChartSeries();
        sols.setLabel("Claims Solicitors");
        sols.set("2004", 52);
        sols.set("2005", 60);
        sols.set("2006", 110);
        sols.set("2007", 135);
        sols.set("2008", 120);

        ChartSeries claimsacc = new ChartSeries();
        claimsacc.setLabel("Claims Accountants");
        claimsacc.set("2004", 128);
        claimsacc.set("2005", 108);
        claimsacc.set("2006", 48);
        claimsacc.set("2007", 158);
        claimsacc.set("2008", 28);

        ChartSeries arch = new ChartSeries();
        arch.setLabel("Claims Architects");
        arch.set("2004", 12);
        arch.set("2005", 16);
        arch.set("2006", 10);
        arch.set("2007", 13);
        arch.set("2008", 99);

        categoryModel.addSeries(claims);
        categoryModel.addSeries(sols);
        categoryModel.addSeries(claimsacc);
        categoryModel.addSeries(arch);
    }

    private void createLinearModel() {
        linearModel = new CartesianChartModel();

        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Series 1");

        series1.set(1, 2);
        series1.set(2, 1);
        series1.set(3, 3);
        series1.set(4, 6);
        series1.set(5, 8);

        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Series 2");
        series2.setMarkerStyle("diamond");

        series2.set(1, 6);
        series2.set(2, 3);
        series2.set(3, 2);
        series2.set(4, 7);
        series2.set(5, 9);

        linearModel.addSeries(series1);
        linearModel.addSeries(series2);
    }
}
