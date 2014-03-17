/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adelplace
 */
@Entity
@Table(name = "typeList")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeList.findAll", query = "SELECT t FROM TypeList t")})
public class TypeList implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "image")
    private Boolean image;
    @Column(name = "line")
    private Boolean line;
    @Size(max = 45)
    @Column(name = "geoloc")
    private String geoloc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeListid")
    private List<jpa.List> listList;

    public TypeList() {
    }

    public TypeList(Integer id) {
	this.id = id;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getLibelle() {
	return libelle;
    }

    public void setLibelle(String libelle) {
	this.libelle = libelle;
    }

    public Boolean getImage() {
	return image;
    }

    public void setImage(Boolean image) {
	this.image = image;
    }

    public Boolean getLine() {
	return line;
    }

    public void setLine(Boolean line) {
	this.line = line;
    }

    public String getGeoloc() {
	return geoloc;
    }

    public void setGeoloc(String geoloc) {
	this.geoloc = geoloc;
    }

    @XmlTransient
    public List<jpa.List> getListList() {
	return listList;
    }

    public void setListList(List<jpa.List> listList) {
	this.listList = listList;
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
	if (!(object instanceof TypeList)) {
	    return false;
	}
	TypeList other = (TypeList) object;
	if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "jpa.TypeList[ id=" + id + " ]";
    }
    
}
