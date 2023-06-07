package com.github.dericksm.port.persistence;

import com.github.dericksm.model.Book;

public interface BookRegisterPersistence {

    boolean existsBookByTitleAndAuthor(final String title, final String author);

    Book save(final Book book);
}
