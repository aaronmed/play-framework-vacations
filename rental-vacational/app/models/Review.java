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
	
	@ManyToOne
	@JoinColumn(name="user")
	public User user;

	@Override
	public String toString() {
		return "Review [description=" + description + ", stars=" + stars + ", published=" + published + ", advert="
				+ advert + ", user=" + user + "] \n";
	}
}
