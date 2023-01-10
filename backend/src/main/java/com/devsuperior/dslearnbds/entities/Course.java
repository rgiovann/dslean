package com.devsuperior.dslearnbds.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_course")
public class Course implements Serializable{
	
 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	private String name;
	private String imgUri;
	private String imgGrayUri;
	
	// === one Course line id to many Offers === 
	// If the relationship is bidirectional, 
	// the  mappedBy element must be used to specify the relationship 
	// field or property of the entity that is the owner of the relationship. 
	// Course 1 |--------------| * Offers
	// But commonly the target foreign key (course_id) is mapped in the target entity (Offer) - it is a 
	// ManyToOne after all - and so the mappedby is used to specify that this 
	// OneToMany should use the relationship already defined in the target entity (Offer).
	// In this case, "mappedBy=course" tells it to look at the "course" property
	// mapping within the "Offer" entity. There, it finds "course" has a ManyToMany 
	// mapping with a default joinColumn "course_id" that it also uses for the OneToMany. 
	// Because it is already mapped within the Offer entity, the OneToMany is read-only. 
	// This ensures that should the two relationships be out of sync, JPA has one side
	// to always trust and use to set the database field.
	@OneToMany(mappedBy = "course")
	private List<Offer> offers = new ArrayList<Offer>();

	public Course() {
	}

	public Course(Long id, String name, String imgUri, String imgGrayUri) {
		super();
		this.id = id;
		this.name = name;
		this.imgUri = imgUri;
		this.imgGrayUri = imgGrayUri;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgUri() {
		return imgUri;
	}

	public void setImgUri(String imgUri) {
		this.imgUri = imgUri;
	}

	public String getImgGrayUri() {
		return imgGrayUri;
	}

	public void setImgGrayUri(String imgGrayUri) {
		this.imgGrayUri = imgGrayUri;
	}
	
	
	public List<Offer> getOffers() {
		return offers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
