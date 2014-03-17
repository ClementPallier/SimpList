/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adelplace
 */
@Entity
@Table(name = "line")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Line.findAll", query = "SELECT l FROM Line l")})
public class Line implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "valid")
    private String valid;
    @Lob
    @Size(max = 65535)
    @Column(name = "body")
    private String body;
    @Column(name = "date_limit")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLimit;
    @JoinColumn(name = "note_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Note noteId;

    public Line() {
    }

    public Line(Integer id) {
	this.id = id;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getValid() {
	return valid;
    }

    public void setValid(String valid) {
	this.valid = valid;
    }

    public String getBody() {
	return body;
    }

    public void setBody(String body) {
	this.body = body;
    }

    public Date getDateLimit() {
	return dateLimit;
    }

    public void setDateLimit(Date dateLimit) {
	this.dateLimit = dateLimit;
    }

    public Note getNoteId() {
	return noteId;
    }

    public void setNoteId(Note noteId) {
	this.noteId = noteId;
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
	if (!(object instanceof Line)) {
	    return false;
	}
	Line other = (Line) object;
	if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "jpa.Line[ id=" + id + " ]";
    }
    
}
