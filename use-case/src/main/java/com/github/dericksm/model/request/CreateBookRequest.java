package com.github.dericksm.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateBookRequest {

    private String author;
    private String title;
}
