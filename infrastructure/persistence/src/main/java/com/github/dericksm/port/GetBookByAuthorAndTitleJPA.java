package com.github.dericksm.port;

import com.github.dericksm.entity.BookEntity;
import com.github.dericksm.mapper.BookMapper;
import com.github.dericksm.model.Book;
import com.github.dericksm.port.persistence.GetBookByAuthorAndTitlePersistence;
import com.github.dericksm.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GetBookByAuthorAndTitleJPA implements GetBookByAuthorAndTitlePersistence {

    //TODO CHECK HOW TO NO LET THIS REPOSITOEY BE PUBLIC
    private final BookRepository bookRepository;

    @Override
    public Book getBookByTitleAndAuthor(String title, String author) {
        var bookEntity = bookRepository.getBookEntityByTitleAndAuthor(title, author);
        return BookMapper.INSTANCE.toBook(new BookEntity());
    }
}
