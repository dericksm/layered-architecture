package com.github.dericksm.model;

import java.io.Serializable;
import java.util.UUID;
import lombok.Data;

@Data
public class Book implements Serializable {

    private UUID id;
    private String title;
    private String author;
}
