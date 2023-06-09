package com.github.dericksm.repository;

import com.github.dericksm.entity.BookEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, UUID> {

    BookEntity getBookEntityByTitleAndAuthor(final String title, final String author);

    boolean existsBookEntitiesByTitleAndAuthor(final String title, final String author);
}
