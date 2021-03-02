package controllers;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import models.Advert;
import models.Review;
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
		if (photo != null) {
			String random = Double.toString(Math.random());
			photo.renameTo(new File("./uploads/" + random + photo.getName()));

			advert.photoName = random + photo.getName();
		}

		advert.save();
		listByUser();
	}

	public static void list() {
		List<Advert> adverts = new ArrayList<Advert>();
		String filter = params.get("filter");
		String guestsString = params.get("guests");
		int guests = 0;
		
		if (guestsString.equals("") && filter.trim().equals("")) {
			System.out.println("1");
			adverts = Advert.findAll();
		} else if (filter.trim().equals("")) {
			System.out.println("2");
			guests = Integer.parseInt(guestsString);
			adverts = Advert.find("byGuests", guests).fetch();
		} else if (guestsString.equals("")) {
			System.out.println("3");
			adverts = Advert.find("byAddress", filter).fetch();
		} else {
			System.out.println("4");
			guests = Integer.parseInt(guestsString);

			List<Advert> advertsAd = Advert.find("byAddress", filter).fetch();
			for (Advert a : advertsAd) {
				if (a.guests >= guests) {
					adverts.add(a);
				}
			}
		}

		renderTemplate("Adverts/search.html", adverts);
	}

	public static void listByUser() {
		Long id = Long.parseLong(session.get("user.id"));
		List<Advert> adverts = Advert.find("byUser.id", id).fetch();

		renderTemplate("Adverts/list.html", adverts);
	}

	public static void detail(long id) {
		Advert advert = Advert.findById(id);
		List<Review> reviews = Review.find("byAdvert.id", id).fetch();
		Long iduser = 0L;
		if (session.get("user.id") != null) {
			iduser = Long.parseLong(session.get("user.id"));
		}
		
		renderTemplate("Adverts/details.html", advert, reviews, iduser);
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

	public static String listAdvert() {
		List<Advert> adverts = Advert.findAll();
		String total = "";
		for (Advert a : adverts) {
			total += a.toString();
		}
		return total;
	}

	public static void addAdvert(Advert advert) {
		advert.save();
	}
}
