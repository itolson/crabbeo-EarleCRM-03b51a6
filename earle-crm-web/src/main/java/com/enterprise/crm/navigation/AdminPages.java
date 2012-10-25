/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.navigation;

/**
 *
 * @author jamescrabbe
 */
public enum AdminPages {
   
    ADMIN_PROFESSION("admin/profession/view-professions.xhtml"),
    ADMIN_USER("admin/user/view-user.xhtml"),
    ADMIN_PANEL("admin/panel/view-panel.xhtml"),
    ADMIN_PRACTICE("admin/practice/view-practice.xhtml"),
    ADMIN_CAUSECODE("admin/causecode/view-causecode.xhtml"),
    ADMIN_SUBCAUSE("admin/subcause/view-subcause.xhtml"),    
    ADMIN_INSURED("admin/insured/view-insured.xhtml"),
    ADMIN_CHANGEPASSWD("admin/password/changepassword.xhtml");

    
    private static final String PAGES_PREFIX = "/pages/";
    private String pageURL;
    
     private AdminPages(String pageURL) {
        this.pageURL = pageURL;
    }
    
    public String getURL() {
        return PAGES_PREFIX + pageURL; 
    }
    
    public String getURLRedirect() {
        return PAGES_PREFIX + pageURL + Pages.REDIRECT;
    }   
    
}
