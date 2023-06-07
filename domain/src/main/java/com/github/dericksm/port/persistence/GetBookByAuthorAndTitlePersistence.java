package com.github.dericksm.port.persistence;

import com.github.dericksm.model.Book;
import java.util.UUID;

public interface GetBookByAuthorAndTitlePersistence {

    Book getBookByTitleAndAuthor(final String title, final String author);
}
