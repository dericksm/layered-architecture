package com.github.dericksm.bookregisterapplication.persistence;

import com.github.dericksm.bookregisterapplication.model.entity.Book;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {

    Book getBookByTitleAndAuthor(final String title, final String author);
    boolean existsBookByTitleAndAuthor(final String title, final String author);

}
