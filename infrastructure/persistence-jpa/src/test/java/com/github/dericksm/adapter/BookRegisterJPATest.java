package com.github.dericksm.adapter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.dericksm.entity.BookEntity;
import com.github.dericksm.model.Book;
import com.github.dericksm.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BookRegisterJPATest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookRegisterJPA bookRegisterJPA;

    @Test
    void existsBookByTitleAndAuthor_whenBookDoesntExist_shouldReturnFalse() {
        when(bookRepository.existsBookEntitiesByTitleAndAuthor(anyString(), anyString())).thenReturn(Boolean.FALSE);
        assertFalse(bookRegisterJPA.existsBookByTitleAndAuthor("Some Title", "Some Book"));
    }

    @Test
    void existsBookByTitleAndAuthor_whenBookExists_shouldReturnTrue() {
        when(bookRepository.existsBookEntitiesByTitleAndAuthor(anyString(), anyString())).thenReturn(Boolean.TRUE);
        assertTrue(bookRegisterJPA.existsBookByTitleAndAuthor("Some Title", "Some Book"));
    }

    @Test
    void save_shouldPersistBook() {
        bookRegisterJPA.save(new Book("Some Title", "Some Author"));
        verify(bookRepository).save(any(BookEntity.class));
    }

}
