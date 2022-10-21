package com.example.bookstore.repository.impl;

import com.example.bookstore.dto.internal.Author;
import com.example.bookstore.repository.AuthorsRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class AuthorsRepositoryImpl implements AuthorsRepository {

    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, List<Author>> getAuthorsMap() {
        List<Author> authors = jdbcTemplate.query("SELECT * FROM authors", (ResultSet rs, int rowNum) -> getAuthors(rs));

        return authors.stream()
                .collect(Collectors.groupingBy((Author a) -> a.getLastName().substring(0, 1)));
    }

    private Author getAuthors(ResultSet rs) throws SQLException {
        Author author = new Author();
        author.setId(rs.getInt("id"));
        author.setFirstName(rs.getString("first_name"));
        author.setLastName(rs.getString("last_name"));
        return author;
    }
}
