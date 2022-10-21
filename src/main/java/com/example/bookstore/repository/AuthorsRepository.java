package com.example.bookstore.repository;

import com.example.bookstore.dto.internal.Author;

import java.util.List;
import java.util.Map;

public interface AuthorsRepository {
    Map<String, List<Author>> getAuthorsMap();
}
