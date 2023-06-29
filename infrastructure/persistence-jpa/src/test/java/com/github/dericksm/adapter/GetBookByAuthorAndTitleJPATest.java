package com.github.dericksm.adapter;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.github.dericksm.entity.BookEntity;
import com.github.dericksm.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetBookByAuthorAndTitleJPATest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private GetBookByAuthorAndTitleJPA getBookByAuthorAndTitleJPA;

    @Test
    void getBookByTitleAndAuthor_whenBookDoesntExist_shouldReturnNull() {
        when(bookRepository.getBookEntityByTitleAndAuthor(anyString(), anyString())).thenReturn(null);
        assertNull(bookRepository.getBookEntityByTitleAndAuthor("Some title", "Some author"));
    }

    @Test
    void getBookByTitleAndAuthor_whenBookExist_shouldReturnBook() {
        when(bookRepository.getBookEntityByTitleAndAuthor(anyString(), anyString())).thenReturn(new BookEntity());
        assertNotNull(bookRepository.getBookEntityByTitleAndAuthor("Some title", "Some author"));
    }

}
