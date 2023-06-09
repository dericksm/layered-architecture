package com.github.dericksm.model.request;

import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;
import lombok.Data;

@Data
public class CreateBookRequest implements Serializable {

    @NotBlank
    private String title;
    @NotBlank
    private String author;
}
