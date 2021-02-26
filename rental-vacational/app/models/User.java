
package models;

import javax.persistence.Entity;

import play.db.jpa.Model;
import play.libs.Crypto;

@Entity
public class User extends Model {
	public String username;
	public String password;
	public String name;
	public String surname;
	public String dni;
	public String telephone;
	
	public void setPassword(String s) {
		password = Crypto.passwordHash(s);
	}
}