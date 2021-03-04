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
		System.out.println(book.start);
		System.out.println(book.end);
		if (book.start.equals("")|| book.end.equals("")) {
			flash.error("Los datos de la reserva no son correctos");
			Adverts.detail(book.advert.id);
		} else {
			book.save();
			listByUser();
		}
	}
	
	public static void list() {
		List<Book> books = Book.findAll();
		render(books);
	}
	
	public static void listByUser() {
		Long id =  Long.parseLong(session.get("user.id"));
		List<Advert> books = Book.find("byUser.id", id).fetch();
		
		System.out.println(books.isEmpty());
		
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
	
	public static String listBook() {
		List<Book> books = Book.findAll();
		String total = "";
		for (Book b : books) {
			total += b.toString();
		}
		return total;
	}

	public static void addBook(Book book) {
		book.save();
	}
}
