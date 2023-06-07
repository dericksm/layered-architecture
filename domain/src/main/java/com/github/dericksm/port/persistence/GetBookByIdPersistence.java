package com.github.dericksm.port.persistence;

import com.github.dericksm.model.Book;
import java.util.UUID;

public interface GetBookByIdPersistence {

    Book getBookById(final UUID id);

}
