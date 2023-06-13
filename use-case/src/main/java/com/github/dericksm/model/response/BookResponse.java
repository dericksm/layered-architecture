package com.github.dericksm.model.response;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookResponse {

    private UUID id;
    private String title;
    private String author;
}
