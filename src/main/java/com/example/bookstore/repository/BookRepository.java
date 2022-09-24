package com.example.bookstore.repository;

import com.example.bookstore.dto.internal.Book;

import java.util.List;

public interface BookRepository {

    List<Book> getBookData();
}
