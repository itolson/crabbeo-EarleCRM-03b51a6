/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.messaging;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author user
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Messages.findAll", query = "SELECT m FROM Messages m"),
    @NamedQuery(name = "Messages.findById", query = "SELECT m FROM Messages m WHERE m.id = :id"),
    @NamedQuery(name = "Messages.findByIdFrom", query = "SELECT m FROM Messages m WHERE m.idfrom = :idfrom"),
    @NamedQuery(name = "Messages.findByIdTo", query = "SELECT m FROM Messages m WHERE m.idto = :idto"),
    @NamedQuery(name = "Messages.findByDateSent", query = "SELECT m FROM Messages m WHERE m.datesent = :datesent"),
    @NamedQuery(name = "Messages.findByDateRead", query = "SELECT m FROM Messages m WHERE m.dateread = :dateread"),
    @NamedQuery(name = "Messages.findByMessage", query = "SELECT m FROM Messages m WHERE m.message = :message")})
public class Messages implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Size(max = 32)
    @Column(name = "idfrom")
    private String idfrom;
    @Size(max = 32)
    @Column(name = "idto")
    private String idto;
    @Column(name = "datesent")
    @Temporal(TemporalType.DATE)
    private Date datesent;
    @Column(name = "dateread")
    @Temporal(TemporalType.DATE)
    private Date dateread;
    @Size(max = 250)
    @Column(name = "message")
    private String message;

    public Messages() {
    }

    public Messages(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdFrom() {
        return idfrom;
    }

    public void setIdFrom(String idfrom) {
        this.idfrom = idfrom;
    }

    public String getIdTo() {
        return idto;
    }

    public void setIdTo(String idto) {
        this.idto = idto;
    }

    public Date getDateSent() {
        return datesent;
    }

    public void setDateSent(Date datesent) {
        this.datesent = datesent;
    }

    public Date getDateRead() {
        return dateread;
    }

    public void setDateRead(Date dateread) {
        this.dateread = dateread;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
        if (!(object instanceof Messages)) {
            return false;
        }
        Messages other = (Messages) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.enterprise.crm.messaging.Messages[ id=" + id + " ]";
    }
    
}
