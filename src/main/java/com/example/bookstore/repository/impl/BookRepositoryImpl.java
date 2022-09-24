package com.example.bookstore.repository.impl;

import com.example.bookstore.dto.internal.Book;
import com.example.bookstore.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class BookRepositoryImpl implements BookRepository {

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Book> getBookData() {
        List<Book> books = jdbcTemplate.query("SELECT * FROM books;", (ResultSet rs, int rowNum) -> {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setAuthor(rs.getString("author"));
            book.setTitle(rs.getString("title"));
            book.setPriceOld(rs.getString("priceOld"));
            book.setPrice(rs.getString("price"));
            return book;
        });
        return new ArrayList<>(books);
    }
}
