package com.github.dericksm.usecase;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.dericksm.exception.BookNotFoundException;
import com.github.dericksm.model.Book;
import com.github.dericksm.port.output.persistence.GetBookByAuthorAndTitlePersistence;
import com.github.dericksm.port.output.presenter.GetBookByAuthorAndTitlePresenter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetBookAuthorAndTitleInteractorTest {

    private final static String AUTHOR = "Some Author";
    private final static String TITLE = "Some Title";

    @Mock
    private GetBookByAuthorAndTitlePersistence getBookByAuthorAndTitlePersistence;

    @Mock
    private GetBookByAuthorAndTitlePresenter getBookByAuthorAndTitlePresenter;

    @InjectMocks
    private GetBookAuthorAndTitleInteractor getBookAuthorAndTitleInteractor;

    @Test
    void getByTitleAndAuthor_whenBookIsNotFound_shouldThrowBookNotFoundException() {
        when(getBookByAuthorAndTitlePersistence.getBookByTitleAndAuthor(anyString(), anyString())).thenReturn(null);
        assertThrows(BookNotFoundException.class,
            () -> getBookAuthorAndTitleInteractor.getByTitleAndAuthor(TITLE, AUTHOR));
    }

    @Test
    void getByTitleAndAuthor_whenBookIsFound_shouldPresent() {
        when(getBookByAuthorAndTitlePersistence.getBookByTitleAndAuthor(anyString(), anyString())).thenReturn(new Book(TITLE, AUTHOR));
        getBookAuthorAndTitleInteractor.getByTitleAndAuthor(TITLE, AUTHOR);
        verify(getBookByAuthorAndTitlePresenter).present(any());
    }

}
