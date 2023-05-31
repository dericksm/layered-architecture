package com.github.dericksm.bookregisterapplication.service;

import com.github.dericksm.bookregisterapplication.exception.BookAlreadyExistsException;
import com.github.dericksm.bookregisterapplication.exception.BookNotFoundException;
import com.github.dericksm.bookregisterapplication.model.entity.Book;
import com.github.dericksm.bookregisterapplication.persistence.BookRepository;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;


    public Book create(final Book book) {
        if (bookRepository.existsBookByTitleAndAuthor(book.getTitle(), book.getAuthor())) {
            throw new BookAlreadyExistsException(book.getTitle(), book.getAuthor());
        }
        return bookRepository.save(book);
    }

    public Book getById(final UUID uuid) {
        return Optional.of(bookRepository.getReferenceById(uuid)).orElseThrow(() -> new BookNotFoundException(uuid));
    }

    public Optional<Book> getByTitleAndAuthor(final String title, final String author) {
        return Optional.ofNullable(bookRepository.getBookByTitleAndAuthor(title, author));
    }

}
