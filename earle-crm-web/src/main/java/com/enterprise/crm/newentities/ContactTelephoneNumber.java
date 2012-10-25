/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.newentities;

import com.enterprise.crm.user.TelephoneType;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 *
 * @author jamescrabbe
 */
@Entity(name="CONTACT_TELEPHONE_NUMBER")
public class ContactTelephoneNumber implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    @Basic
    @Enumerated(EnumType.STRING) 
    @Column(name = "TYPE")
    private TelephoneType type;
    
    @Basic
    @Size(max = 20)
    @Column(name = "TELEPHONE_NUMBER", length=20)
    private String telephoneNumber;
    
    @Basic
    @Column(name = "PRIMARY_TELPHONE_NUMBER")
    private boolean primaryTelephoneNumber;

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

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public boolean isPrimaryTelephoneNumber() {
        return primaryTelephoneNumber;
    }

    public void setPrimaryTelephoneNumber(boolean primaryTelephoneNumber) {
        this.primaryTelephoneNumber = primaryTelephoneNumber;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 43 * hash + (this.type != null ? this.type.hashCode() : 0);
        hash = 43 * hash + (this.telephoneNumber != null ? this.telephoneNumber.hashCode() : 0);
        hash = 43 * hash + (this.primaryTelephoneNumber ? 1 : 0);
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
        final ContactTelephoneNumber other = (ContactTelephoneNumber) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        if ((this.telephoneNumber == null) ? (other.telephoneNumber != null) : !this.telephoneNumber.equals(other.telephoneNumber)) {
            return false;
        }
        if (this.primaryTelephoneNumber != other.primaryTelephoneNumber) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ContactTelephoneNumber{" + "id=" + id + ", type=" + type + 
                ", telephoneNumber=" + telephoneNumber + 
                ", primaryTelephoneNumber=" + primaryTelephoneNumber + '}';
    } 
}
