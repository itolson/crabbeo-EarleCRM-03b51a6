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
public class ContactTelephone implements Serializable {
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
    @Column(name = "telephonenumber")
    private String number;
    
    @Basic
    @Column(name = "primarytelephonenumber")
    private boolean primaryTelephoneNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }  

    public TelephoneType getType() {
        return type;
    }

    public void setType(TelephoneType type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isPrimary() {
        return primaryTelephoneNumber;
    }

    public void setPrimaryTelephoneNumber(boolean primaryTelephoneNumber) {
        this.primaryTelephoneNumber = primaryTelephoneNumber;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 89 * hash + (this.userDetails != null ? this.userDetails.hashCode() : 0);
        hash = 89 * hash + (this.type != null ? this.type.hashCode() : 0);
        hash = 89 * hash + (this.number != null ? this.number.hashCode() : 0);
        hash = 89 * hash + (this.primaryTelephoneNumber ? 1 : 0);
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
        final ContactTelephone other = (ContactTelephone) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.userDetails != other.userDetails && (this.userDetails == null || !this.userDetails.equals(other.userDetails))) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        if ((this.number == null) ? (other.number != null) : !this.number.equals(other.number)) {
            return false;
        }
        if (this.primaryTelephoneNumber != other.primaryTelephoneNumber) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ContactTelephone{" + "id=" + id + ", userDetails=" + userDetails + ", type=" + type + ", number=" + number + ", primary=" + primaryTelephoneNumber + '}';
    }
}
