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
        String sql = "SELECT * FROM book";
        return jdbcTemplate.query(sql, new BookRowMapper());
    }

    public Book findBookById(int id) {
        String sql = "SELECT * FROM book where book_id= ? ";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BookRowMapper());
    }


    public class BookRowMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {

            Book book = new Book();
            book.setBook_id(rs.getLong("book_id"));
            book.setBook_author(rs.getString("book_author"));
            book.setBook_title(rs.getString("book_title"));
            book.setBook_year((int) rs.getLong("book_year"));

            return book;

        }
    }
}
