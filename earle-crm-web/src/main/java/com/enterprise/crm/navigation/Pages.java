
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.navigation;

/**
 *
 * @author jamescrabbe
 */
public enum Pages {

    WELCOME("/pages/welcome.xhtml"),
    HOME("/pages/workbook/view-workbook.xhtml");
    
    
    static final String REDIRECT = "&redirect=true";
    private String pageURL;

    private Pages(String pageURL) {
        this.pageURL = pageURL;
    }
    
    public String getURL() {
        return pageURL; 
    }
    
    public String getURLRedirect() {
        return pageURL + REDIRECT;
    }
    
}