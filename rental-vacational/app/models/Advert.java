package models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Advert extends Model {
	public String description;
	public String address;
	public String published;
	public float price;
	public int guests;
	public int bathrooms;
	public int bedrooms;
	public int beds;
	
	@ManyToOne
	@JoinColumn(name="user")
	public User user;
	
	public String photoName;

	@Override
	public String toString() {
		return "Advert [description=" + description + ", address=" + address + ", published=" + published + ", price="
				+ price + ", guests=" + guests + ", bathrooms=" + bathrooms + ", bedrooms=" + bedrooms + ", beds="
				+ beds + ", user=" + user + ", photoName=" + photoName + "] \n";
	}
}