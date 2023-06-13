package com.github.dericksm.port.output.persistence;

import com.github.dericksm.model.Book;

public interface GetBookByAuthorAndTitlePersistence {

    Book getBookByTitleAndAuthor(final String title, final String author);
}
