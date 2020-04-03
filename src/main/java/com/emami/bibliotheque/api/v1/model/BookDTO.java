package com.emami.bibliotheque.api.v1.model;

import lombok.Data;

import java.util.Date;

@Data
public class BookDTO {
    private String title;

    private String author;

    private Long isbn;
    private Date created_at;
}
