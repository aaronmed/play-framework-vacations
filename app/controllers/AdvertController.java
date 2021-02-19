package controllers;

import java.util.List;

import models.Advert;
import play.mvc.Controller;

public class AdvertController extends Controller {
	public static void form() {
		render();
	}
	
	public static void add(Advert advert) {
		advert.save();
		form();
	}
	
//	public static void show() {
//		List<Advert> adverts = Advert.findAll();
//		render(adverts);
//	}
	
	public static void show() {
		String filter = params.get("filter");
		
		List<Advert> adverts = Advert.find("byAddress", filter).fetch();
		
//		List<Advert> adverts = Advert.findAll();
		render(adverts);
	}
	
	public static void showOwnsByUser() {
		String filter = params.get("filter");
		List<Advert> adverts = Advert.find("byUser.name", filter).fetch();
		
		render(adverts);
	}
	
	public static void edit(long id) {
		Advert advert = Advert.findById(id);
		renderTemplate("AdvertController/form.html", advert);
	}
	
	public static void delete(long id) {
		Advert advert = Advert.findById(id);
		advert.delete();
	}
}
