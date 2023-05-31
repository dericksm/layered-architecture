package com.github.dericksm.bookregisterapplication.model.dto.response;

import java.io.Serializable;
import java.util.UUID;
import lombok.Data;

@Data
public class BookResponse implements Serializable {

    private UUID id;
    private String title;
    private String author;
}
