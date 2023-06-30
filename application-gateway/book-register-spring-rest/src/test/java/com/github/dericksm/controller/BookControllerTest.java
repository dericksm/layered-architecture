package com.github.dericksm.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.dericksm.model.mapper.BookMapper;
import com.github.dericksm.model.request.CreateBookRequest;
import com.github.dericksm.model.request.CreateBookRequestRest;
import com.github.dericksm.usecase.BookRegisterInteractor;
import com.github.dericksm.usecase.GetBookAuthorAndTitleInteractor;
import com.github.dericksm.usecase.GetBookByIdInteractor;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BookControllerTest {

    @Mock
    private GetBookByIdInteractor getBookByIdInteractor;

    @Mock
    private GetBookAuthorAndTitleInteractor getBookAuthorAndTitleInteractor;

    @Mock
    private BookRegisterInteractor bookRegisterInteractor;

    @Mock
    private BookMapper bookMapper;

    @InjectMocks
    private BookController bookController;

    @Test
    void getById() {
        bookController.getById(UUID.randomUUID());
        verify(getBookByIdInteractor).getById(any(UUID.class));
    }

    @Test
    void getByTitleAndAuthor() {
        bookController.getByTitleAndAuthor("Some title", "Some author");
        verify(getBookAuthorAndTitleInteractor).getByTitleAndAuthor(anyString(), anyString());
    }

    @Test
    void create() {
        when(bookMapper.toUseCaseRequest(any(CreateBookRequestRest.class))).thenReturn(new CreateBookRequest());
        bookController.create(new CreateBookRequestRest());
        verify(bookRegisterInteractor).registerBook(any(CreateBookRequest.class));
    }
}
