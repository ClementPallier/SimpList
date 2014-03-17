/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adelplace
 */
@Entity
@Table(name = "geoloc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Geoloc.findAll", query = "SELECT g FROM Geoloc g")})
public class Geoloc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "lat")
    private String lat;
    @Size(max = 45)
    @Column(name = "lng")
    private String lng;
    @JoinColumn(name = "note_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Note noteId;

    public Geoloc() {
    }

    public Geoloc(Integer id) {
	this.id = id;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getLat() {
	return lat;
    }

    public void setLat(String lat) {
	this.lat = lat;
    }

    public String getLng() {
	return lng;
    }

    public void setLng(String lng) {
	this.lng = lng;
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
	if (!(object instanceof Geoloc)) {
	    return false;
	}
	Geoloc other = (Geoloc) object;
	if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "jpa.Geoloc[ id=" + id + " ]";
    }
    
}
