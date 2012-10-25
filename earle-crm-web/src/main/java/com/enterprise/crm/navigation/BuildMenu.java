/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.navigation;

import javax.ejb.Stateful;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

@Named
@Stateful
@ViewScoped
public class BuildMenu {

    private MenuModel model;

    public BuildMenu() {

        FacesContext facesCtx = FacesContext.getCurrentInstance();
        ELContext elCtx = facesCtx.getELContext();
        ExpressionFactory expFact = facesCtx.getApplication().getExpressionFactory();

        model = new DefaultMenuModel();

        MenuItem item = new MenuItem();

        Submenu submenu = new Submenu();
        submenu.setLabel("Home Page");
        submenu.setIcon("ui-icon ui-icon-home");

        item.setValue("Goto Home Page");
        item.setIcon("ui-icon ui-icon-home");
        item.setAjax(false);
        item.setActionExpression(expFact.createMethodExpression(elCtx, "#{menuBean.add}", String.class, new Class[0]));
        item.setUrl(DataSearchPages.WORKBOOK.getURL());
        item.setTitle("Navigate to the Home Page");

        submenu.getChildren().add(item);
        model.addSubmenu(submenu);

        submenu = new Submenu();
        submenu.setLabel("Claims Menu");
        submenu.setIcon("ui-icon ui-icon-document");
        item = new MenuItem();
        item.setValue("New Claim");
        item.setIcon("ui-icon ui-icon-contact");
        item.setAjax(false);
        item.setActionExpression(expFact.createMethodExpression(elCtx, "#{menuBean.add}", String.class, new Class[0]));
        item.setUrl(DataEntryPages.NEWCLAIM.getURL());
        item.setTitle("Enter New Claim Details");

        submenu.getChildren().add(item);
        item = new MenuItem();
        item.setValue("Search Claims");
        item.setIcon("ui-icon ui-icon-search");
        item.setAjax(false);
        item.setActionExpression(expFact.createMethodExpression(elCtx, "#{menuBean.add}", Void.class, new Class[]{Object.class, String.class}));
        item.setUrl(DataSearchPages.CLAIMS.getURL());
        item.setTitle("Search Claim Details");

        submenu.getChildren().add(item);
        model.addSubmenu(submenu);

        submenu = new Submenu();
        submenu.setLabel("Message / Diary Menu");
        submenu.setIcon("ui-icon ui-icon-document");
        item = new MenuItem();
        item.setValue("Messages");
        item.setIcon("ui-icon ui-icon-contact");
        item.setAjax(false);
        item.setActionExpression(expFact.createMethodExpression(elCtx, "#{menuBean.add}", String.class, new Class[0]));
        item.setUrl(DataEntryPages.MESSAGES.getURL());
        item.setTitle("Display your messages");

        submenu.getChildren().add(item);
        item = new MenuItem();
        item.setValue("Diary");
        item.setIcon("ui-icon ui-icon-search");
        item.setAjax(false);
        item.setActionExpression(expFact.createMethodExpression(elCtx, "#{menuBean.add}", Void.class, new Class[]{Object.class, String.class}));
        item.setUrl(DataEntryPages.DIARY.getURL());
        item.setTitle("Diary Details");

        submenu.getChildren().add(item);
        model.addSubmenu(submenu);

        submenu = new Submenu();
        submenu.setLabel("Admin");
        submenu.setIcon("ui-icon ui-icon-document");
        item = new MenuItem();
        item.setValue("Add / Edit Insured");
        item.setIcon("ui-icon ui-icon-pencil");
        item.setAjax(false);
        item.setActionExpression(expFact.createMethodExpression(elCtx, "#{menuBean.add}", String.class, new Class[0]));
        item.setUrl(AdminPages.ADMIN_INSURED.getURL());
        item.setTitle("Add / Edit Insured Details");

        submenu.getChildren().add(item);
        item = new MenuItem();
        item.setValue("Add / Edit Panel");
        item.setIcon("ui-icon ui-icon-pencil");
        item.setAjax(false);
        item.setActionExpression(expFact.createMethodExpression(elCtx, "#{menuBean.add}", Void.class, new Class[]{Object.class, String.class}));
        item.setUrl(AdminPages.ADMIN_PANEL.getURL());
        submenu.getChildren().add(item);
        item.setTitle("Add / Edit Panel Details");

        submenu.getChildren().add(item);
        item = new MenuItem();
        item.setValue("Add / Edit Users");
        item.setIcon("ui-icon ui-icon-pencil");
        item.setAjax(false);
        item.setActionExpression(expFact.createMethodExpression(elCtx, "#{menuBean.add}", Void.class, new Class[]{Object.class, String.class}));
        item.setUrl(AdminPages.ADMIN_USER.getURL());
        submenu.getChildren().add(item);
        item.setTitle("Add / Edit User Details");

        submenu.getChildren().add(item);
        item = new MenuItem();
        item.setValue("Add / Edit Profession");
        item.setIcon("ui-icon ui-icon-pencil");
        item.setAjax(false);
        item.setActionExpression(expFact.createMethodExpression(elCtx, "#{menuBean.add}", Void.class, new Class[]{Object.class, String.class}));
        item.setUrl(AdminPages.ADMIN_PROFESSION.getURL());
        submenu.getChildren().add(item);
        item.setTitle("Add / Edit Profession Details");

        submenu.getChildren().add(item);
        item = new MenuItem();
        item.setValue("Add / Edit Practice");
        item.setIcon("ui-icon ui-icon-pencil");
        item.setAjax(false);
        item.setActionExpression(expFact.createMethodExpression(elCtx, "#{menuBean.add}", Void.class, new Class[]{Object.class, String.class}));
        item.setUrl(AdminPages.ADMIN_PRACTICE.getURL());
        submenu.getChildren().add(item);
        item.setTitle("Add / Edit Practice Details");

        submenu.getChildren().add(item);
        item = new MenuItem();
        item.setValue("Add / Edit Sub Causes");
        item.setIcon("ui-icon ui-icon-pencil");
        item.setAjax(false);
        item.setActionExpression(expFact.createMethodExpression(elCtx, "#{menuBean.add}", Void.class, new Class[]{Object.class, String.class}));
        item.setUrl(AdminPages.ADMIN_SUBCAUSE.getURL());
        submenu.getChildren().add(item);
        item.setTitle("Add / Edit Sub Causes Details");

        submenu.getChildren().add(item);
        item = new MenuItem();
        item.setValue("Add / Edit Cause Codes");
        item.setIcon("ui-icon ui-icon-pencil");
        item.setAjax(false);
        item.setActionExpression(expFact.createMethodExpression(elCtx, "#{menuBean.add}", Void.class, new Class[]{Object.class, String.class}));
        item.setUrl(AdminPages.ADMIN_CAUSECODE.getURL());
        submenu.getChildren().add(item);
        item.setTitle("Add / Edit Cause Codes Details");

        submenu.getChildren().add(item);
        item = new MenuItem();
        item.setValue("Change Password");
        item.setIcon("ui-icon ui-icon-pencil");
        item.setAjax(false);
        item.setActionExpression(expFact.createMethodExpression(elCtx, "#{menuBean.add}", Void.class, new Class[]{Object.class, String.class}));
        item.setUrl(AdminPages.ADMIN_CHANGEPASSWD.getURL());
        submenu.getChildren().add(item);
        item.setTitle("Change Password");

        submenu.getChildren().add(item);
        model.addSubmenu(submenu);

        submenu = new Submenu();
        submenu.setLabel("Reporting");
        submenu.setIcon("ui-icon ui-icon-document");
        item = new MenuItem();
        item.setValue("Graphs");
        item.setIcon("ui-icon ui-icon-newwin");
        item.setAjax(false);
        item.setActionExpression(expFact.createMethodExpression(elCtx, "#{menuBean.add}", String.class, new Class[0]));
        item.setUrl(ReportPages.GRAPHS.getURL());
        item.setTitle("Management Information Graphs");

        submenu.getChildren().add(item);
        item = new MenuItem();
        item.setValue("Excel");
        item.setIcon("ui-icon ui-icon-newwin");
        item.setAjax(false);
        item.setActionExpression(expFact.createMethodExpression(elCtx, "#{menuBean.add}", Void.class, new Class[]{Object.class, String.class}));
        item.setUrl("#");
        item.setTitle("Management Information Export To Excel");

        submenu.getChildren().add(item);
        item = new MenuItem();
        item.setValue("Audit");
        item.setIcon("ui-icon ui-icon-newwin");
        item.setAjax(false);
        item.setActionExpression(expFact.createMethodExpression(elCtx, "#{menuBean.add}", Void.class, new Class[]{Object.class, String.class}));
        item.setUrl("#");
        item.setTitle("Managemet Information Audit Report");

        submenu.getChildren().add(item);
        model.addSubmenu(submenu);

        submenu = new Submenu();
        submenu.setLabel("Log off");
        submenu.setIcon("ui-icon ui-icon-star");
        item.setValue("End Session");
        item.setIcon("ui-icon ui-icon-close");
        item.setAjax(false);
        item.setActionExpression(expFact.createMethodExpression(elCtx, "#{menuBean.add}", String.class, new Class[0]));
        item.setUrl(WelcomePage.WELCOME.getURL());
        item.setTitle("End Claim Track Session");

        submenu.getChildren().add(item);
        model.addSubmenu(submenu);

    }

    public MenuModel getModel() {
        return model;
    }

    public String add(Object obj, String nodeId) {
        return null;
    }
}