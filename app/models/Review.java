package models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Review extends Model {
	public String description;
	public int stars;
	public String published;
	
	@ManyToOne
	@JoinColumn(name="advert")
	public Advert advert;
}
