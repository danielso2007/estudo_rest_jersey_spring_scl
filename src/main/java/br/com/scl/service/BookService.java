package br.com.scl.service;

import br.com.scl.domain.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();

    Book getBook(Long id);

    List<Book> getBookByTitle(String title);

    boolean delete(Long id);

    boolean save(Book book);
}
