package com.github.dericksm.adapter;

import com.github.dericksm.mapper.BookMapper;
import com.github.dericksm.model.Book;
import com.github.dericksm.port.output.persistence.GetBookByAuthorAndTitlePersistence;
import com.github.dericksm.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GetBookByAuthorAndTitleJPA implements GetBookByAuthorAndTitlePersistence {

    private final BookRepository bookRepository;

    @Override
    public Book getBookByTitleAndAuthor(String title, String author) {
        var bookEntity = bookRepository.getBookEntityByTitleAndAuthor(title, author);
        return BookMapper.INSTANCE.toBook(bookEntity);
    }
}
