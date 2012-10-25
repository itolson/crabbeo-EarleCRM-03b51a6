/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.navigation;

/**
 *
 * @author jamescrabbe
 */
public enum DataSearchPages {
   
    CLAIMS("claims/view-claims.xhtml"),
    WORKBOOK("workbook/view-workbook.xhtml");
    
    private static final String PAGES_PREFIX = "/pages/";
    private String pageURL;
    
     private DataSearchPages(String pageURL) {
        this.pageURL = pageURL;
    }
    
    public String getURL() {
        return PAGES_PREFIX + pageURL; 
    }
    
    public String getURLRedirect() {
        return PAGES_PREFIX + pageURL + Pages.REDIRECT;
    }   
    
}
