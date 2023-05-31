package com.github.dericksm.bookregisterapplication.exception;

import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException {

    public static final String BOOK_NOTFOUND_MESSAGE = "Book with id '%s' doesn't exist";

    public BookNotFoundException(final UUID id) {
        super(BOOK_NOTFOUND_MESSAGE.formatted(id.toString()));
    }
}