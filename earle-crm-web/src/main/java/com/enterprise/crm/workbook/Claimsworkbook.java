/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.workbook;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "claimsworkbook")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Claimsworkbook.findAll", query = "SELECT c FROM Claimsworkbook c"),
    @NamedQuery(name = "Claimsworkbook.findById", query = "SELECT c FROM Claimsworkbook c WHERE c.id = :id"),
    @NamedQuery(name = "Claimsworkbook.findByUsername", query = "SELECT c FROM Claimsworkbook c WHERE c.username = :username"),
    @NamedQuery(name = "Claimsworkbook.findByClaimNo", query = "SELECT c FROM Claimsworkbook c WHERE c.claimNo = :claimNo"),
    @NamedQuery(name = "Claimsworkbook.findByClaimDate", query = "SELECT c FROM Claimsworkbook c WHERE c.claimDate = :claimDate"),
    @NamedQuery(name = "Claimsworkbook.findByClaimUpdate", query = "SELECT c FROM Claimsworkbook c WHERE c.claimUpdate = :claimUpdate")})
public class Claimsworkbook implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Size(max = 60)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "claimNo")
    private String claimNo;
    @Column(name = "claimDate")
    @Temporal(TemporalType.DATE)
    private Date claimDate;
    @Size(max = 100)
    @Column(name = "claimUpdate")
    private String claimUpdate;

    public Claimsworkbook() {
    }

    public Claimsworkbook(Long id) {
        this.id = id;
    }

    public Claimsworkbook(Long id, String claimNo) {
        this.id = id;
        this.claimNo = claimNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getClaimNo() {
        return claimNo;
    }

    public void setClaimNo(String claimNo) {
        this.claimNo = claimNo;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public String getClaimUpdate() {
        return claimUpdate;
    }

    public void setClaimUpdate(String claimUpdate) {
        this.claimUpdate = claimUpdate;
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
        if (!(object instanceof Claimsworkbook)) {
            return false;
        }
        Claimsworkbook other = (Claimsworkbook) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.enterprise.crm.workbook.Claimsworkbook[ id=" + id + " ]";
    }
    
}
