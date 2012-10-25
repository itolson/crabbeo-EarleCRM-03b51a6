/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.insured;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "insureddetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InsuredDetails.findAll", query = "SELECT i FROM InsuredDetails i"),
    @NamedQuery(name = "InsuredDetails.findById", query = "SELECT i FROM InsuredDetails i WHERE i.id = :id"),
    @NamedQuery(name = "InsuredDetails.findByName", query = "SELECT i FROM InsuredDetails i WHERE i.name = :name")
})
public class InsuredDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(max = 80)
    @Column(name = "name")
    private String name;
    @Size(max = 80)
    @Column(name = "address1")
    private String address1;
    @Size(max = 80)
    @Column(name = "address2")
    private String address2;
    @Size(max = 80)
    @Column(name = "address3")
    private String address3;
    @Size(max = 80)
    @Column(name = "address4")
    private String address4;
    @Size(max = 80)
    @Column(name = "postcode")
    private String postcode;
    @Size(max = 80)
    @Column(name = "contacts")
    private String contacts;

    public InsuredDetails() {
    }

    public InsuredDetails(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getAddress4() {
        return address4;
    }

    public void setAddress4(String address4) {
        this.address4 = address4;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InsuredDetails)) {
            return false;
        }
        InsuredDetails other = (InsuredDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.enterprise.crm.insured.InsuredDetails[ id=" + id + " ]";
    }
    
}
