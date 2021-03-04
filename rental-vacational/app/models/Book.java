
package models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Book extends Model {
	@ManyToOne
	@JoinColumn(name="user")
	public User user;
	
	@ManyToOne
	@JoinColumn(name="advert")
	public Advert advert;
	
	public String start;
	public String end;
	@Override
	public String toString() {
		return "Book [user=" + user + ", advert=" + advert + ", start=" + start + ", end=" + end + "] \n";
	}
	
	
}