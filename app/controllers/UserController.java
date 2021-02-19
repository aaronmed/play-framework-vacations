package controllers;

import java.util.List;

import models.User;
import play.mvc.Controller;

public class UserController extends Controller {
	public static void form() {
		render();
	}
	
	public static void add(User user) {
		user.save();
	}
	
	public static void show() {
		List<User> users = User.findAll();
		render(users);
	}
	
	public static void edit(long id) {
		User user = User.findById(id);
		renderTemplate("Users/form.html", user);
	}
	
	public static void delete(long id) {
		User user = User.findById(id);
		user.delete();
	}

}
