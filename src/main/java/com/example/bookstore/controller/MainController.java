package com.example.bookstore.controller;

import com.example.bookstore.dto.internal.Book;
import com.example.bookstore.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@AllArgsConstructor
public class MainController {

    private final BookRepository bookRepository;

    @ModelAttribute("recommendedBooks")
    public List<Book> recommendedBooks() {
        return bookRepository.getBookData();
    }

    @GetMapping("/")
    public String mainPage() {
        return "index";
    }
}
