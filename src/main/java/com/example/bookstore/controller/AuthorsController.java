package com.example.bookstore.controller;

import com.example.bookstore.dto.internal.Author;
import com.example.bookstore.repository.AuthorsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
public class AuthorsController {

    private final AuthorsRepository authorsRepository;

    @ModelAttribute("authorsMap")
    public Map<String, List<Author>> authorsMap() {
        Map<String, List<Author>> authors = authorsRepository.getAuthorsMap();
        return authorsRepository.getAuthorsMap();
    }

    @GetMapping("/authors")
    public String authorsPage() {
        return "/authors/index";
    }
}
