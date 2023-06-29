package com.github.dericksm.adapter;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.github.dericksm.entity.BookEntity;
import com.github.dericksm.repository.BookRepository;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetBookByIdJPATest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private GetBookByIdJPA getBookByIdJPA;

    @Test
    void getBookByTitleAndAuthor_whenBookDoesntExist_shouldReturnNull() {
        when(bookRepository.getReferenceById(any(UUID.class))).thenReturn(null);
        assertNull(getBookByIdJPA.getBookById(UUID.randomUUID()));
    }

    @Test
    void getBookByTitleAndAuthor_whenBookExist_shouldReturnBook() {
        when(bookRepository.getReferenceById(any(UUID.class))).thenReturn(new BookEntity());
        assertNotNull(getBookByIdJPA.getBookById(UUID.randomUUID()));
    }

}
