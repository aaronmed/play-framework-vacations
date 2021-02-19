package controllers;

import java.util.List;

import models.Book;
import play.mvc.Controller;

public class BookController extends Controller {
	public static void form() {
		render();
	}
	
	public static void add(Book book) {
		book.save();
		form();
	}
	
	public static void show() {
		List<Book> books = Book.findAll();
		render(books);
	}
	
	public static void edit(long id) {
		Book book = Book.findById(id);
		renderTemplate("Books/form.html", book);
	}
	
	public static void delete(long id) {
		Book book = Book.findById(id);
		book.delete();
	}
}
