/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.newentities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author jamescrabbe
 */
@Entity(name="MESSAGE")
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "FROM_ID")  
    private Person from;
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "TO_ID")  
    private Person to;
    
    @OneToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
    @JoinTable(name="MESSAGE_NOTES", joinColumns={@JoinColumn(name="MESSAGE_ID", referencedColumnName="ID")}, inverseJoinColumns={@JoinColumn(name="NOTE_ID", referencedColumnName="ID")})
    private List<Notes> messageNotes;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="SENT_DATE")
    Date sentDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="READ_DATE")
    Date readDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getFrom() {
        return from;
    }

    public void setFrom(Person from) {
        this.from = from;
    }

    public Person getTo() {
        return to;
    }

    public void setTo(Person to) {
        this.to = to;
    }
    
    public List<Notes> getMessageNotes() {
        return messageNotes;
    }

    public void setMessageNotes(List<Notes> messageNotes) {
        this.messageNotes = messageNotes;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public Date getReadDate() {
        return readDate;
    }

    public void setReadDate(Date readDate) {
        this.readDate = readDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 37 * hash + (this.from != null ? this.from.hashCode() : 0);
        hash = 37 * hash + (this.to != null ? this.to.hashCode() : 0);
        hash = 37 * hash + (this.messageNotes != null ? this.messageNotes.hashCode() : 0);
        hash = 37 * hash + (this.sentDate != null ? this.sentDate.hashCode() : 0);
        hash = 37 * hash + (this.readDate != null ? this.readDate.hashCode() : 0);
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
        final Message other = (Message) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.from != other.from && (this.from == null || !this.from.equals(other.from))) {
            return false;
        }
        if (this.to != other.to && (this.to == null || !this.to.equals(other.to))) {
            return false;
        }
        if (this.messageNotes != other.messageNotes && (this.messageNotes == null || !this.messageNotes.equals(other.messageNotes))) {
            return false;
        }
        if (this.sentDate != other.sentDate && (this.sentDate == null || !this.sentDate.equals(other.sentDate))) {
            return false;
        }
        if (this.readDate != other.readDate && (this.readDate == null || !this.readDate.equals(other.readDate))) {
            return false;
        }
        return true;
    }
}
