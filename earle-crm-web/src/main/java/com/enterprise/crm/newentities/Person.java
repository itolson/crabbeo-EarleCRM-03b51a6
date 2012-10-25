/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.newentities;

import com.enterprise.crm.user.ContactEmail;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 *
 * @author jamescrabbe
 */
@Entity(name="PERSON")
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    @Basic
    @Size(max = 50)
    @Column(name="FORENAME", length=50)
    private String forename;
    
    @Basic
    @Size(max = 50)
    @Column(name="SURNAME", length=50)
    private String surname;
    
    @OneToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
    @JoinTable(name="PERSON_ADDRESS", joinColumns={@JoinColumn(name="PERSON_ID", referencedColumnName="ID")}, inverseJoinColumns={@JoinColumn(name="ADDRESS_ID", referencedColumnName="ID")})
    private List<ContactAddress> contactAddress;
    
    @OneToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
    @JoinTable(name="PERSON_TELEPONE", joinColumns={@JoinColumn(name="PERSON_ID", referencedColumnName="ID")}, inverseJoinColumns={@JoinColumn(name="TELEPHONE_ID", referencedColumnName="ID")})
    private List<ContactTelephoneNumber> contactTelephone;
    
    @OneToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
    @JoinTable(name="PERSON_EMAIL", joinColumns={@JoinColumn(name="PERSON_ID", referencedColumnName="ID")}, inverseJoinColumns={@JoinColumn(name="TELEPHONE_ID", referencedColumnName="ID")})
    private List<ContactEmail> contactEmail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<ContactAddress> getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(List<ContactAddress> contactAddress) {
        this.contactAddress = contactAddress;
    }

    public List<ContactTelephoneNumber> getContactTelephone() {
        return contactTelephone;
    }

    public void setContactTelephone(List<ContactTelephoneNumber> contactTelephone) {
        this.contactTelephone = contactTelephone;
    }

    public List<ContactEmail> getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(List<ContactEmail> contactEmail) {
        this.contactEmail = contactEmail;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 41 * hash + (this.forename != null ? this.forename.hashCode() : 0);
        hash = 41 * hash + (this.surname != null ? this.surname.hashCode() : 0);
        hash = 41 * hash + (this.contactAddress != null ? this.contactAddress.hashCode() : 0);
        hash = 41 * hash + (this.contactTelephone != null ? this.contactTelephone.hashCode() : 0);
        hash = 41 * hash + (this.contactEmail != null ? this.contactEmail.hashCode() : 0);
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
        final Person other = (Person) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.forename == null) ? (other.forename != null) : !this.forename.equals(other.forename)) {
            return false;
        }
        if ((this.surname == null) ? (other.surname != null) : !this.surname.equals(other.surname)) {
            return false;
        }
        if (this.contactAddress != other.contactAddress && (this.contactAddress == null || !this.contactAddress.equals(other.contactAddress))) {
            return false;
        }
        if (this.contactTelephone != other.contactTelephone && (this.contactTelephone == null || !this.contactTelephone.equals(other.contactTelephone))) {
            return false;
        }
        if (this.contactEmail != other.contactEmail && (this.contactEmail == null || !this.contactEmail.equals(other.contactEmail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", forename=" + forename + 
                ", surname=" + surname + ", contactAddress=" + contactAddress 
                + ", contactTelephone=" + contactTelephone + 
                ", contactEmail=" + contactEmail + '}';
    }    
}
