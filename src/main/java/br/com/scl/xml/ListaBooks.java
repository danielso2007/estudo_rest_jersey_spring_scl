package br.com.scl.xml;

import br.com.scl.domain.Book;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "books")
public class ListaBooks implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Book> books;

	@XmlElement(name = "book")
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "ListaBooks [books=" + books + "]";
	}
}
