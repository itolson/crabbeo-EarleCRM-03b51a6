/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.navigation;

/**
 *
 * @author jamescrabbe
 */
public enum DataEntryPages {
   
    MESSAGES("messages/view-messages.xhtml"),
    DIARY("diary/view-diary.xhtml"),
    NEWCLAIM("newclaim/view-newclaim.xhtml");
    
    private static final String PAGES_PREFIX = "/pages/";
    private String pageURL;
    
     private DataEntryPages(String pageURL) {
        this.pageURL = pageURL;
    }
    
    public String getURL() {
        return PAGES_PREFIX + pageURL; 
    }
    
    public String getURLRedirect() {
        return PAGES_PREFIX + pageURL + Pages.REDIRECT;
    }   
    
}
