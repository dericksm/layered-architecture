package com.github.dericksm.bookregisterapplication.model.dto.response;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class BooksResponse implements Serializable {

    private List<BookResponse> books;
}
