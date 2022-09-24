package com.example.bookstore.dto.internal;

import lombok.Data;

@Data
public class Book {

    private int id;

    private String author;

    private String title;

    private String priceOld;

    private String price;
}
