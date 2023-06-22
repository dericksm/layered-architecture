package com.github.dericksm.adapter;

import com.github.dericksm.mapper.BookMapper;
import com.github.dericksm.model.Book;
import com.github.dericksm.port.output.persistence.BookRegisterPersistence;
import com.github.dericksm.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookRegisterJPA implements BookRegisterPersistence {

    private final BookRepository bookRepository;

    @Override
    public boolean existsBookByTitleAndAuthor(String title, String author) {
        return bookRepository.existsBookEntitiesByTitleAndAuthor(title, author);
    }

    @Override
    public Book save(Book book) {
        var bookEntity = BookMapper.INSTANCE.toBookEntity(book);
        bookEntity = bookRepository.save(bookEntity);
        return BookMapper.INSTANCE.toBook(bookEntity);
    }
}
