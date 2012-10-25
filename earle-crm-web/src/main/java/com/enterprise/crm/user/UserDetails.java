/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.user;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author user
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "UserDetails.findAll", query = "SELECT u FROM UserDetails u "),
    @NamedQuery(name = "UserDetails.findByUserId", query = "SELECT u FROM UserDetails u WHERE u.userName = :userName"),
    @NamedQuery(name = "UserDetails.findByPartner", query = "SELECT u FROM UserDetails u WHERE u.partner = 1"),
    @NamedQuery(name = "UserDetails.findByFeeEarner", query = "SELECT u FROM UserDetails u WHERE u.partner = 0")    
})
public class UserDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Size(max = 10)
    @NotNull
    @Column(name = "userName")
    private String userName;
    
    @Size(max = 50)
    @Column(name = "forename")
    private String forename;
    
    @Size(max = 50)
    @Column(name = "surname")
    private String surname;
    
    @Column(name = "hourlyrate")
    private Integer hourlyrate;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "partner")
    private boolean partner;

    @OneToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL, mappedBy="userDetails")
    public List<ContactTelephone> contactTelephone;

    @OneToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL, mappedBy="userDetails")
    public List<ContactEmail> contactEmail;

    public UserDetails() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Integer getHourlyrate() {
        return hourlyrate;
    }

    public void setHourlyrate(Integer hourlyrate) {
        this.hourlyrate = hourlyrate;
    }
    
    public List<ContactTelephone> getContactTelephone() {
        return contactTelephone;
    }

    public void setContactTelephone(List<ContactTelephone> contactTelephone) {
        this.contactTelephone = contactTelephone;
    }

    public List<ContactEmail> getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(List<ContactEmail> contactEmail) {
        this.contactEmail = contactEmail;
    }

    public boolean isPartner() {
        return partner;
    }

    public void setPartner(boolean partner) {
        this.partner = partner;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 37 * hash + (this.userName != null ? this.userName.hashCode() : 0);
        hash = 37 * hash + (this.forename != null ? this.forename.hashCode() : 0);
        hash = 37 * hash + (this.surname != null ? this.surname.hashCode() : 0);
        hash = 37 * hash + (this.hourlyrate != null ? this.hourlyrate.hashCode() : 0);
        hash = 37 * hash + (this.partner ? 1 : 0);
        hash = 37 * hash + (this.contactTelephone != null ? this.contactTelephone.hashCode() : 0);
        hash = 37 * hash + (this.contactEmail != null ? this.contactEmail.hashCode() : 0);
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
        final UserDetails other = (UserDetails) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.userName == null) ? (other.userName != null) : !this.userName.equals(other.userName)) {
            return false;
        }
        if ((this.forename == null) ? (other.forename != null) : !this.forename.equals(other.forename)) {
            return false;
        }
        if ((this.surname == null) ? (other.surname != null) : !this.surname.equals(other.surname)) {
            return false;
        }
        if (this.hourlyrate != other.hourlyrate && (this.hourlyrate == null || !this.hourlyrate.equals(other.hourlyrate))) {
            return false;
        }
        if (this.partner != other.partner) {
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
        return "UserDetails{" + "id=" + id + ", userName=" + userName + ", forename=" + forename + ", surname=" + surname + ", hourlyrate=" + hourlyrate + ", partner=" + partner + ", contactTelephone=" + contactTelephone + ", contactEmail=" + contactEmail + '}';
    }
  
}
