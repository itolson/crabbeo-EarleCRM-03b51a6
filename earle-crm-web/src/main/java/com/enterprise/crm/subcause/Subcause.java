/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.subcause;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "subcause")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subcause.findAll", query = "SELECT s FROM Subcause s"),
    @NamedQuery(name = "Subcause.findById", query = "SELECT s FROM Subcause s WHERE s.id = :id"),
    @NamedQuery(name = "Subcause.findByDescription", query = "SELECT s FROM Subcause s WHERE s.description = :description")})
public class Subcause implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Size(max = 50)
    @Column(name = "description")
    private String description;

    public Subcause() {
    }

    public Subcause(Long id) {
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
        if (!(object instanceof Subcause)) {
            return false;
        }
        Subcause other = (Subcause) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.enterprise.crm.subcause.Subcause[ id=" + id + " ]";
    }
    
}
