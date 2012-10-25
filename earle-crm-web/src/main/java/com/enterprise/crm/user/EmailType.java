/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.user;

/**
 *
 * @author jamescrabbe
 */
public enum EmailType {
    WORK("Company"),
    PERSONAL("Personal");
    
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private EmailType(String type) {
        this.type = type;
    }
    
}
