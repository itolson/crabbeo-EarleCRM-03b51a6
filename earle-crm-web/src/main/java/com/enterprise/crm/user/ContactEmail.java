/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.user;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 *
 * @author jamescrabbe
 */
@Entity
public class ContactEmail implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name="userdetails")
    public UserDetails userDetails;
    
    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TelephoneType type;
    
    @Basic
    @Size(max = 20)
    @Column(name = "emailaddress")
    private String emailAddress;
    
    @Basic
    @Column(name = "primaryEmailAddress")
    private boolean primaryEmailAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TelephoneType getType() {
        return type;
    }

    public void setType(TelephoneType type) {
        this.type = type;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public boolean isPrimary() {
        return primaryEmailAddress;
    }

    public void setPrimaryEmailAddress(boolean primaryEmailAddress) {
        this.primaryEmailAddress = primaryEmailAddress;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 83 * hash + (this.userDetails != null ? this.userDetails.hashCode() : 0);
        hash = 83 * hash + (this.type != null ? this.type.hashCode() : 0);
        hash = 83 * hash + (this.emailAddress != null ? this.emailAddress.hashCode() : 0);
        hash = 83 * hash + (this.primaryEmailAddress ? 1 : 0);
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
        final ContactEmail other = (ContactEmail) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.userDetails != other.userDetails && (this.userDetails == null || !this.userDetails.equals(other.userDetails))) {
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
        return "ContactEmail{" + "id=" + id + ", userDetails=" + userDetails + ", type=" + type + ", emailAddress=" + emailAddress + ", primary=" + primaryEmailAddress + '}';
    }
    
    
   
}
