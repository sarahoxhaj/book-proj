package com.library.repository;

import com.library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<Book> findAllBooks() {
        String sql = "SELECT * FROM libri";
        return jdbcTemplate.query(sql, new BookRowMapper());
    }

    public Book findBookById(int isbn) {
        String sql = "SELECT * FROM libri where isbnLibri= ? ";
        return jdbcTemplate.queryForObject(sql, new Object[]{isbn}, new BookRowMapper());
    }

    public List<Book> getAllBooksFromAuthor(String author) {
        String sql = "SELECT * FROM libri WHERE autori = '" + author + "'";
        return jdbcTemplate.query(sql, new BookRowMapper());
    }

    public boolean deleteBookByIsbn(int isbn) {
        return this.jdbcTemplate.update("DELETE FROM libri WHERE isbnLibri = ? ", isbn) > 0;
    }


    public List<Book> getAllBooksStartingWith(String st) {
        String sql = "SELECT * FROM libri WHERE titull LIKE '" + st + "%'";
        return jdbcTemplate.query(sql, new BookRowMapper());
    }


    public boolean insertBook(Book book) {
        String sql = " INSERT INTO libri (isbnLibri,titull,autori,shtepiBotuese,cmimi,idStudenti)" + " values (" + book.getIsbnLibri() + ",'" + book.getTitulli() + "','" + book.getAutori() + "','" + book.getShtepiB() + "'," + book.getCmimi() + "," + book.getIdStudenti() + ")";
        return jdbcTemplate.update(sql) > 0;
    }

    public boolean updateBook(Book book) {
        String sql = "UPDATE libri SET cmimi = " + book.getCmimi() + " WHERE isbnLibri = " + book.getIsbnLibri();
        return jdbcTemplate.update(sql) > 0;

    }


    public class BookRowMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {

            Book book = new Book();
            book.setIsbnLibri(rs.getInt("isbnLibri"));
            book.setTitulli(rs.getString("titull"));
            book.setAutori(rs.getString("autori"));
            book.setShtepiB(rs.getString("shtepiBotuese"));
            book.setCmimi(rs.getInt("cmimi"));
            book.setIdStudenti(rs.getInt("idStudenti"));
            return book;
        }
    }
}
