/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.practice;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "practice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Practice.findAll", query = "SELECT p FROM Practice p"),
    @NamedQuery(name = "Practice.findById", query = "SELECT p FROM Practice p WHERE p.id = :id"),
    @NamedQuery(name = "Practice.findByDescription", query = "SELECT p FROM Practice p WHERE p.description = :description")})
public class Practice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Size(max = 50)
    @Column(name = "description")
    private String description;

    public Practice() {
    }

    public Practice(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof Practice)) {
            return false;
        }
        Practice other = (Practice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.enterprise.crm.practice.Practice[ id=" + id + " ]";
    }
    
}
