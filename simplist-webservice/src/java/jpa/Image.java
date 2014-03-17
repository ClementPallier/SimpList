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
@Table(name = "image")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Image.findAll", query = "SELECT i FROM Image i")})
public class Image implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "min_path")
    private String minPath;
    @Size(max = 255)
    @Column(name = "original_path")
    private String originalPath;
    @Size(max = 255)
    @Column(name = "med_path")
    private String medPath;
    @JoinColumn(name = "note_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Note noteId;

    public Image() {
    }

    public Image(Integer id) {
	this.id = id;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getMinPath() {
	return minPath;
    }

    public void setMinPath(String minPath) {
	this.minPath = minPath;
    }

    public String getOriginalPath() {
	return originalPath;
    }

    public void setOriginalPath(String originalPath) {
	this.originalPath = originalPath;
    }

    public String getMedPath() {
	return medPath;
    }

    public void setMedPath(String medPath) {
	this.medPath = medPath;
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
	if (!(object instanceof Image)) {
	    return false;
	}
	Image other = (Image) object;
	if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "jpa.Image[ id=" + id + " ]";
    }
    
}
