/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.causecode;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "causecode")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Causecode.findAll", query = "SELECT c FROM Causecode c"),
    @NamedQuery(name = "Causecode.findById", query = "SELECT c FROM Causecode c WHERE c.id = :id"),
    @NamedQuery(name = "Causecode.findByDescription", query = "SELECT c FROM Causecode c WHERE c.description = :description")})
public class Causecode implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Size(max = 50)
    @Column(name = "description")
    private String description;

    public Causecode() {
    }

    public Causecode(Long id) {
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
        if (!(object instanceof Causecode)) {
            return false;
        }
        Causecode other = (Causecode) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.enterprise.crm.causecode.Causecode[ id=" + id + " ]";
    }
    
}
