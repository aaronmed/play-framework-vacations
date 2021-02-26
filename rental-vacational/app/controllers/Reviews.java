package controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import models.Review;
import play.mvc.Controller;

public class Reviews extends Controller {
	public static void form() {
		render();
	}
	
	public static void add(Review review) {
		Date today = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(today);
		
		review.published = date;
		review.save();
		System.out.print(review.advert.id);
		Adverts.detail(review.advert.id);
	}
	
	public static void show() {
		List<Review> reviews = Review.findAll();
		render(reviews);
	}
	
	public static void edit(long id) {
		Review review = Review.findById(id);
		renderTemplate("Reviews/form.html", review);
	}
	
	public static void delete(long id) {
		Review review = Review.findById(id);
		review.delete();
		Adverts.detail(review.advert.id);
	}
}
