package com.github.dericksm.bookregisterapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class BookAlreadyExistsException extends RuntimeException {

    public static final String BOOK_ALREADY_EXISTS_MESSAGE = "Book with title %s and author %s already exists";

    public BookAlreadyExistsException(final String title, final String author) {
        super(BOOK_ALREADY_EXISTS_MESSAGE.formatted(title, author));
    }
}