package com.github.dericksm.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateBookRequestRest {

    @NotBlank
    private String author;
    @NotBlank
    private String title;
}
