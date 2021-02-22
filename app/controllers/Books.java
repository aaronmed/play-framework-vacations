package controllers;

import java.util.List;

import models.Advert;
import models.Book;
import play.mvc.Controller;

public class Books extends Controller {
	public static void form() {
		render();
	}
	
	public static void add(Book book) {
		book.save();
		form();
	}
	
	public static void list() {
		List<Book> books = Book.findAll();
		render(books);
	}
	
	public static void listByUser() {
		Long id =  Long.parseLong(session.get("user.id"));
		List<Advert> books = Book.find("byUser.id", id).fetch();
		
		renderTemplate("Books/list.html", books);
	}
	
	public static void edit(long id) {
		Book book = Book.findById(id);
		renderTemplate("Books/form.html", book);
	}
	
	public static void delete(long id) {
		Book book = Book.findById(id);
		book.delete();
		listByUser();
	}
}
