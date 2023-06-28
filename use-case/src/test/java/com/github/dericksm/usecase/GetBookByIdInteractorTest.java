package com.github.dericksm.usecase;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.dericksm.exception.BookNotFoundException;
import com.github.dericksm.model.Book;
import com.github.dericksm.port.output.persistence.GetBookByIdPersistence;
import com.github.dericksm.port.output.presenter.GetBookByIdPresenter;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetBookByIdInteractorTest {

    private final static String AUTHOR = "Some Author";
    private final static String TITLE = "Some Title";

    @Mock
    private GetBookByIdPersistence getBookByIdPersistence;

    @Mock
    private GetBookByIdPresenter getBookByIdPresenter;

    @InjectMocks
    private GetBookByIdInteractor getBookByIdInteractor;

    @Test
    void getById_whenBookIsNotFound_shouldThrowBookNotFoundException() {
        when(getBookByIdPersistence.getBookById(any())).thenReturn(null);
        assertThrows(BookNotFoundException.class, () -> getBookByIdInteractor.getById(UUID.randomUUID()));
    }

    @Test
    void getById_whenBookIsFound_shouldPresent() {
        when(getBookByIdPersistence.getBookById(any())).thenReturn(new Book(AUTHOR, TITLE));
        getBookByIdInteractor.getById(UUID.randomUUID());
        verify(getBookByIdPresenter).present(any());
    }
}
