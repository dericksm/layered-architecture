package com.github.dericksm.exception;

import java.util.UUID;

public class BookNotFoundException extends RuntimeException {

    public static final String BOOK_NOTFOUND_MESSAGE = "Book with id '%s' doesn't exist";
    public static final String BOOK_WITH_TITLE_AND_AUTHOR_NOTFOUND_MESSAGE = "Book with title '%s and %s doesn't exist";

    public BookNotFoundException(final UUID id) {
        super(BOOK_NOTFOUND_MESSAGE.formatted(id.toString()));
    }

    public BookNotFoundException(final String title, final String author) {
        super(BOOK_WITH_TITLE_AND_AUTHOR_NOTFOUND_MESSAGE.formatted(title, author));
    }
}