package controllers;

import java.util.List;

import models.Advert;
import models.User;
import play.libs.Crypto;
import play.mvc.Controller;
import play.mvc.With;


public class Users extends Controller {
	public static void form() {
		render();
	}
	
	public static void add(User user) {
		user.save();
		renderTemplate("Application/index.html");
	}
	
	public static void show() {
		List<User> users = User.findAll();
		render(users);
	}
	
	public static void list() {
		Long id =  Long.parseLong(session.get("user.id"));
		User user = User.findById(id);
		render(user);
	}
	
	public static void edit(long id) {
		User user = User.findById(id);
		renderTemplate("Users/edit.html", user);
	}
	
	public static void delete(long id) {
		User user = User.findById(id);
		user.delete();
		session.clear();
        renderTemplate("Application/index.html");
	}
	
	public static String listUser() {
		List<User> users = User.findAll();
		String total = "";
		for (User u : users) {
			total += u.toString();
		}
		return total;
	}

	public static void addUser(User user) {
		user.save();
		
	}
}
