package com.github.dericksm.usecase;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.dericksm.exception.BookAlreadyExistsException;
import com.github.dericksm.model.Book;
import com.github.dericksm.model.request.CreateBookRequest;
import com.github.dericksm.port.output.persistence.BookRegisterPersistence;
import com.github.dericksm.port.output.presenter.BookRegisterPresenter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BookRegisterInteractorTest {

    private final static String AUTHOR = "Some Author";
    private final static String TITLE = "Some Title";
    private final static Book BOOK = new Book(TITLE, AUTHOR);

    @Mock
    private BookRegisterPersistence bookRegisterPersistence;

    @Mock
    private BookRegisterPresenter bookRegisterPresenter;

    @InjectMocks
    private BookRegisterInteractor bookRegisterInteractor;

    @Test
    void registerBook_withExistingBook_shouldThrowBookAlreadyExistsException() {
        when(bookRegisterPersistence.existsBookByTitleAndAuthor(anyString(), anyString())).thenReturn(Boolean.TRUE);
        assertThrows(BookAlreadyExistsException.class,
            () -> bookRegisterInteractor.registerBook(new CreateBookRequest(AUTHOR, TITLE)));
    }

    @Test
    void registerBook_withNewBook_shouldPersistData() {
        when(bookRegisterPersistence.existsBookByTitleAndAuthor(anyString(), anyString())).thenReturn(Boolean.FALSE);
        when(bookRegisterPersistence.save(any())).thenReturn(BOOK);

        bookRegisterInteractor.registerBook(new CreateBookRequest(AUTHOR, TITLE));
        verify(bookRegisterPersistence).save(any());
    }

    @Test
    void registerBook_withNewBook_shouldPresentData() {
        when(bookRegisterPersistence.existsBookByTitleAndAuthor(anyString(), anyString())).thenReturn(Boolean.FALSE);
        when(bookRegisterPersistence.save(any())).thenReturn(BOOK);

        bookRegisterInteractor.registerBook(new CreateBookRequest(AUTHOR, TITLE));
        verify(bookRegisterPresenter).present(any());
    }

}
