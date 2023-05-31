package com.github.dericksm.bookregisterapplication.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;
import lombok.Data;

@Data
public class BookRequest implements Serializable {

    @NotBlank
    private String title;
    @NotBlank
    private String author;
}
