package com.github.dericksm.exception;

public class BookAlreadyExistsException extends RuntimeException {

    public static final String BOOK_ALREADY_EXISTS_MESSAGE = "Book with title %s and author %s already exists";

    public BookAlreadyExistsException(final String title, final String author) {
        super(BOOK_ALREADY_EXISTS_MESSAGE.formatted(title, author));
    }
}