package com.github.dericksm.model;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.Data;

@Data
public class Book implements Serializable {

    private UUID id;
    private String title;
    private String author;
    private OffsetDateTime createdAt;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}
