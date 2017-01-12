package br.com.scl.service.impl;

import br.com.scl.dao.BookDAO;
import br.com.scl.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements br.com.scl.service.BookService {

    @Autowired
    private BookDAO db;

    @Override
    public List<Book> getBooks() {
        try {
            List<Book> books = db.getBooks();
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<Book>();
        }
    }

    @Override
    public Book getBook(Long id) {
        try {
            return db.getBookById(id);
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public List<Book> getBookByTitle(String title) {
        try {
            return db.findByTitle(title);
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public boolean delete(Long id) {
        try {
            return db.delete(id);
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean save(Book book) {
        try {
            db.save(book);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

}
