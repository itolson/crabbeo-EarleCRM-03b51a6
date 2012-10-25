/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.newentities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 *
 * @author jamescrabbe
 */
@Entity(name = "CONTACT_ADDRESS")
public class ContactAddress implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 
    
    @Basic
    @Size(max = 50)
    @Column(name = "LINE_ONE", length=50)
    private String lineOne;
    
    @Basic
    @Size(max = 50)
    @Column(name = "LINE_TWO", length=50)
    private String lineTwo;
    
    @Basic
    @Size(max = 50)
    @Column(name = "LINE_THREE", length=50)
    private String lineThree;
    
    @Basic
    @Size(max = 50)
    @Column(name = "LINE_FOUR", length=50)
    private String lineFour;
    
    @Basic
    @Size(max = 20)
    @Column(name = "TOWN", length=20)
    private String town;
    
    @Basic
    @Size(max = 20)
    @Column(name = "COUNTY", length=20)
    private String county;
    
    @Basic
    @Size(max = 20)
    @Column(name = "COUNTRY", length=20)
    private String country;
    
    @Basic
    @Size(max = 20)
    @Column(name = "POSTCODE", length=20)
    private String postCode;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLineOne() {
        return lineOne;
    }

    public void setLineOne(String lineOne) {
        this.lineOne = lineOne;
    }

    public String getLineTwo() {
        return lineTwo;
    }

    public void setLineTwo(String lineTwo) {
        this.lineTwo = lineTwo;
    }

    public String getLineThree() {
        return lineThree;
    }

    public void setLineThree(String lineThree) {
        this.lineThree = lineThree;
    }

    public String getLineFour() {
        return lineFour;
    }

    public void setLineFour(String lineFour) {
        this.lineFour = lineFour;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 61 * hash + (this.lineOne != null ? this.lineOne.hashCode() : 0);
        hash = 61 * hash + (this.lineTwo != null ? this.lineTwo.hashCode() : 0);
        hash = 61 * hash + (this.lineThree != null ? this.lineThree.hashCode() : 0);
        hash = 61 * hash + (this.lineFour != null ? this.lineFour.hashCode() : 0);
        hash = 61 * hash + (this.town != null ? this.town.hashCode() : 0);
        hash = 61 * hash + (this.county != null ? this.county.hashCode() : 0);
        hash = 61 * hash + (this.country != null ? this.country.hashCode() : 0);
        hash = 61 * hash + (this.postCode != null ? this.postCode.hashCode() : 0);
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
        final ContactAddress other = (ContactAddress) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.lineOne == null) ? (other.lineOne != null) : !this.lineOne.equals(other.lineOne)) {
            return false;
        }
        if ((this.lineTwo == null) ? (other.lineTwo != null) : !this.lineTwo.equals(other.lineTwo)) {
            return false;
        }
        if ((this.lineThree == null) ? (other.lineThree != null) : !this.lineThree.equals(other.lineThree)) {
            return false;
        }
        if ((this.lineFour == null) ? (other.lineFour != null) : !this.lineFour.equals(other.lineFour)) {
            return false;
        }
        if ((this.town == null) ? (other.town != null) : !this.town.equals(other.town)) {
            return false;
        }
        if ((this.county == null) ? (other.county != null) : !this.county.equals(other.county)) {
            return false;
        }
        if ((this.country == null) ? (other.country != null) : !this.country.equals(other.country)) {
            return false;
        }
        if ((this.postCode == null) ? (other.postCode != null) : !this.postCode.equals(other.postCode)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ContactAddress{" + "id=" + id + ", lineOne=" + lineOne + ", lineTwo=" + lineTwo + 
                ", lineThree=" + lineThree + ", lineFour=" + lineFour + ", town=" + town + 
                ", county=" + county + ", country=" + country + ", postCode=" + postCode + '}';
    }
    
    
    
}
