/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.user;

/**
 *
 * @author jamescrabbe
 */
public enum TelephoneType {
   WORK("Work"), 
   HOME("Home"), 
   MOBILE("Mobile");
   
   private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private TelephoneType(String type) {
        this.type = type;
    }    
}
