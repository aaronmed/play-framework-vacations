package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class User extends Model {
	public String username;
	public String password;
	public String name;
	public String surname;
	public String dni;
	public String telephone;
}
