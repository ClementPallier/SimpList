/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adelplace
 */
@Entity
@Table(name = "note")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Note.findAll", query = "SELECT n FROM Note n")})
public class Note implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "body")
    private String body;
    @Size(max = 45)
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "createdAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "noteId")
    private List<Geoloc> geolocList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "noteId")
    private List<Image> imageList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "noteId")
    private List<Line> lineList;
    @JoinColumn(name = "list_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private jpa.List listId;

    public Note() {
    }

    public Note(Integer id) {
	this.id = id;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getBody() {
	return body;
    }

    public void setBody(String body) {
	this.body = body;
    }

    public String getLibelle() {
	return libelle;
    }

    public void setLibelle(String libelle) {
	this.libelle = libelle;
    }

    public Date getCreatedAt() {
	return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
    }

    @XmlTransient
    public List<Geoloc> getGeolocList() {
	return geolocList;
    }

    public void setGeolocList(List<Geoloc> geolocList) {
	this.geolocList = geolocList;
    }

    @XmlTransient
    public List<Image> getImageList() {
	return imageList;
    }

    public void setImageList(List<Image> imageList) {
	this.imageList = imageList;
    }

    @XmlTransient
    public List<Line> getLineList() {
	return lineList;
    }

    public void setLineList(List<Line> lineList) {
	this.lineList = lineList;
    }

    public jpa.List getListId() {
	return listId;
    }

    public void setListId(jpa.List listId) {
	this.listId = listId;
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
	if (!(object instanceof Note)) {
	    return false;
	}
	Note other = (Note) object;
	if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "jpa.Note[ id=" + id + " ]";
    }
    
}
