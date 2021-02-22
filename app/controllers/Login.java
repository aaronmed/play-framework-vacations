package controllers;

import models.User;
import play.libs.Crypto;
import play.mvc.Controller;

public class Login extends Controller {
	
	public static void form() {
		render();
	}
	
	public static void login(String username, String password) {
		User user = User.find("username = ?1 and password = ?2", 
				username, Crypto.passwordHash(password)).first();
		
		if (user == null) {
			System.out.println("Login incorrecto");
			flash.error("Las credenciales no son correctas");
			Login.form();
			
		} else {
			session.put("user.username", user.username);
			session.put("user.id", user.id);
			System.out.println("Login correcto con " + user.username);
			Application.index();
			
		}
	}
	
	public static void logout() {
		session.clear();
		System.out.println("Sesión cerrada");
		Application.index();
	}
}
