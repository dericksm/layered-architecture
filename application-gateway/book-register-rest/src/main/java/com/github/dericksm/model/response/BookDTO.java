package com.github.dericksm.model.response;

import java.io.Serializable;
import java.util.UUID;
import lombok.Data;

@Data
public class BookDTO implements Serializable {

    private UUID id;
    private String title;
    private String author;
}
