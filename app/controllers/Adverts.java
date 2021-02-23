package controllers;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import models.Advert;
import models.User;
import play.libs.Crypto;
import play.mvc.Controller;

public class Adverts extends Controller {
	public static void form() {
		Long iduser = Long.parseLong(session.get("user.id"));
		
		Date today = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(today);
		
		render(iduser, date);
	}
	
	public static void add(Advert advert, File photo) {
		photo.renameTo(new File("./uploads/" + photo.getName()));
		
		advert.photoName = photo.getName();
		advert.save();
		listByUser();
	}
		
	public static void list() {
		String filter = params.get("filter");
		
		List<Advert> adverts = Advert.find("byAddress", filter).fetch();
		
		renderTemplate("Application/index.html", adverts);
	}
	
	public static void listByUser() {
		Long id =  Long.parseLong(session.get("user.id"));
		List<Advert> adverts = Advert.find("byUser.id", id).fetch();
		
		renderTemplate("Adverts/list.html", adverts);
	}
	
	public static void edit(long id) {
		Advert advert = Advert.findById(id);
		
		Long iduser = Long.parseLong(session.get("user.id"));
		
		Date today = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(today);
		
		renderTemplate("Adverts/form.html", advert, iduser, date);
	}
	
	public static void delete(long id) {
		Advert advert = Advert.findById(id);
		advert.delete();
		listByUser();
	}
	
	public static String listpostman() {
		List<Advert> adverts = Advert.findAll();
		String total = "";
		for (Advert a: adverts) {
			total += a.toString();
		}
		return total;
	}
	
	public static void addpostman(Advert advert) {
		advert.save();
	}

}
