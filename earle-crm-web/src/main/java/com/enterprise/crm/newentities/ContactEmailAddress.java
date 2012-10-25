/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.newentities;

import com.enterprise.crm.user.EmailType;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 *
 * @author jamescrabbe
 */
@Entity(name="CONTACT_EMAIL_ADDRESS")
public class ContactEmailAddress implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 
    
    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private EmailType type;
    
    @Basic
    @Size(max = 20)
    @Column(name = "EMAIL_ADDRESS", length = 20)
    private String emailAddress;
    
    @Basic
    @Column(name = "PRIMARY_EMAIL_ADDRESS")
    private boolean primaryEmailAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmailType getType() {
        return type;
    }

    public void setType(EmailType type) {
        this.type = type;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public boolean isPrimaryEmailAddress() {
        return primaryEmailAddress;
    }

    public void setPrimaryEmailAddress(boolean primaryEmailAddress) {
        this.primaryEmailAddress = primaryEmailAddress;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 97 * hash + (this.type != null ? this.type.hashCode() : 0);
        hash = 97 * hash + (this.emailAddress != null ? this.emailAddress.hashCode() : 0);
        hash = 97 * hash + (this.primaryEmailAddress ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ContactEmailAddress other = (ContactEmailAddress) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        if ((this.emailAddress == null) ? (other.emailAddress != null) : !this.emailAddress.equals(other.emailAddress)) {
            return false;
        }
        if (this.primaryEmailAddress != other.primaryEmailAddress) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ContactEmailAddress{" + "id=" + id + ", type=" + type + 
                ", emailAddress=" + emailAddress + ", primaryEmailAddress=" 
                + primaryEmailAddress + '}';
    }  
}
