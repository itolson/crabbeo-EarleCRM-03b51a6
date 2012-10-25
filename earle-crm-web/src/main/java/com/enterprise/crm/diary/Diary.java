/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.diary;

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
@Table(name = "diary")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diary.findAll", query = "SELECT d FROM Diary d"),
    @NamedQuery(name = "Diary.findById", query = "SELECT d FROM Diary d WHERE d.id = :id"),
    @NamedQuery(name = "Diary.findByEvent", query = "SELECT d FROM Diary d WHERE d.event = :event"),
    @NamedQuery(name = "Diary.findByStartDate", query = "SELECT d FROM Diary d WHERE d.startDate = :startDate"),
    @NamedQuery(name = "Diary.findByEndDate", query = "SELECT d FROM Diary d WHERE d.endDate = :endDate"),
    @NamedQuery(name = "Diary.findByStartTime", query = "SELECT d FROM Diary d WHERE d.startTime = :startTime"),
    @NamedQuery(name = "Diary.findByEndTime", query = "SELECT d FROM Diary d WHERE d.endTime = :endTime"),
    @NamedQuery(name = "Diary.findByUserName", query = "SELECT d FROM Diary d WHERE d.userName = :userName"),
    @NamedQuery(name = "Diary.findByClaimRef", query = "SELECT d FROM Diary d WHERE d.claimRef = :claimRef")})
public class Diary implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Size(max = 450)
    @Column(name = "event")
    private String event;
    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "endDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "startTime")
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Column(name = "endTime")
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @Size(max = 45)
    @Column(name = "userName")
    private String userName;
    @Size(max = 45)
    @Column(name = "claimRef")
    private String claimRef;

    public Diary() {
    }

    public Diary(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getClaimRef() {
        return claimRef;
    }

    public void setClaimRef(String claimRef) {
        this.claimRef = claimRef;
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
        if (!(object instanceof Diary)) {
            return false;
        }
        Diary other = (Diary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.enterprise.crm.diary.Diary[ id=" + id + " ]";
    }
    
}
