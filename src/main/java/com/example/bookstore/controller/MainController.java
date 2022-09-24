package com.example.bookstore.controller;

import com.example.bookstore.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookstore")
@AllArgsConstructor
public class MainController {

    private final BookRepository bookRepository;

    @GetMapping("/main")
    public String mainPage(Model model) {
        model.addAttribute("bookData", bookRepository.getBookData());
        return "index";
    }
}
