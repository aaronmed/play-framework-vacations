package controllers;

import java.util.List;

import models.Review;
import play.mvc.Controller;

public class Reviews extends Controller {
	public static void form() {
		render();
	}
	
	public static void add(Review review) {
		review.save();
		form();
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
	}
}
