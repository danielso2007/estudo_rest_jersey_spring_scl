package br.com.scl.dao;

import br.com.scl.domain.Book;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookDAO extends BaseDAO {

    public Book getBookById(Long id) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("select * from book where id=?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Book c = createBook(rs);
                rs.close();
                return c;
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return null;
    }

    public List<Book> findByTitle(String title) throws SQLException {
        List<Book> books = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("select * from book where lower(title) like ?");
            stmt.setString(1, "%" + title.toLowerCase() + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Book c = createBook(rs);
                books.add(c);
            }
            rs.close();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return books;
    }

    public List<Book> getBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("select * from book");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Book c = createBook(rs);
                books.add(c);
            }
            rs.close();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return books;
    }

    public Book createBook(ResultSet rs) throws SQLException {
        Book c = new Book();
        c.setId(rs.getLong("id"));
        c.setTitle(rs.getString("title"));
        c.setDescription(rs.getString("description"));
        c.setAuthor(rs.getString("author"));
        c.setTotalPage(rs.getLong("total_page"));
        c.setIsbn(rs.getString("isbn"));
        c.setYearPublished(rs.getString("year_published"));
        c.setCoverUrl(rs.getString("cover_url"));
        return c;
    }

    public void save(Book c) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            if (c.getId() == null) {
                stmt = conn
                        .prepareStatement(
                                "INSERT INTO book(author, cover_url, description, isbn, status, title, total_page, year_published) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                                Statement.RETURN_GENERATED_KEYS);
            } else {
                stmt = conn
                        .prepareStatement("UPDATE book SET author=?, cover_url=?, description=?, isbn=?, status=?, title=?, total_page=?, year_published=? WHERE id=?");
            }
            stmt.setString(1, c.getAuthor());
            stmt.setString(2, c.getCoverUrl());
            stmt.setString(3, c.getDescription());
            stmt.setString(4, c.getIsbn());
            stmt.setString(5, c.getStatus().toString());
            stmt.setString(6, c.getTitle());
            stmt.setLong(7, c.getTotalPage());
            stmt.setString(8, c.getYearPublished());

            int count = stmt.executeUpdate();
            if (count == 0) {
                throw new SQLException("Erro ao inserir o book");
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public boolean delete(Long id) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("delete from book where id=?");
            stmt.setLong(1, id);
            int count = stmt.executeUpdate();
            boolean ok = count > 0;
            return ok;
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
