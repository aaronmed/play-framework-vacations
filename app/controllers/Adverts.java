package controllers;

import java.util.List;

import models.Advert;
import play.mvc.Controller;

public class Adverts extends Controller {
	public static void form() {
		render();
	}
	
	public static void add(Advert advert) {
		advert.save();
		form();
	}
		
	public static void list() {
		String filter = params.get("filter");
		
		List<Advert> adverts = Advert.find("byAddress", filter).fetch();
		
		renderTemplate("Application/index.html", adverts);
	}
	
	public static void listByUser() {
		String filter = params.get("filter");
		List<Advert> adverts = Advert.find("byUser.name", filter).fetch();
		
		render(adverts);
	}
	
	public static void edit(long id) {
		Advert advert = Advert.findById(id);
		renderTemplate("Adverts/form.html", advert);
	}
	
	public static void delete(long id) {
		Advert advert = Advert.findById(id);
		advert.delete();
	}
}
