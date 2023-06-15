package com.github.dericksm.adapter;

import com.github.dericksm.mapper.BookMapper;
import com.github.dericksm.model.Book;
import com.github.dericksm.port.output.persistence.GetBookByIdPersistence;
import com.github.dericksm.repository.BookRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GetBookByIdJPA implements GetBookByIdPersistence {

    private final BookRepository bookRepository;

    @Override
    public Book getBookById(UUID id) {
        var bookEntity = bookRepository.getReferenceById(id);
        return BookMapper.INSTANCE.toBook(bookEntity);
    }
}
