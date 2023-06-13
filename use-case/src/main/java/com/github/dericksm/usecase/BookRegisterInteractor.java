package com.github.dericksm.usecase;

import com.github.dericksm.exception.BookAlreadyExistsException;
import com.github.dericksm.model.Book;
import com.github.dericksm.model.request.CreateBookRequest;
import com.github.dericksm.model.response.BookResponse;
import com.github.dericksm.port.output.persistence.BookRegisterPersistence;
import com.github.dericksm.port.output.presenter.BookRegisterPresenter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BookRegisterInteractor {

    private final BookRegisterPersistence bookRegisterPersistence;
    private final BookRegisterPresenter bookRegisterPresenter;

    public void registerBook(final CreateBookRequest createBookRequest) {
        if (bookRegisterPersistence.existsBookByTitleAndAuthor(createBookRequest.getTitle(), createBookRequest.getAuthor())) {
            throw new BookAlreadyExistsException(createBookRequest.getTitle(), createBookRequest.getAuthor());
        }
        var book = new Book(createBookRequest.getTitle(), createBookRequest.getAuthor());
        book = bookRegisterPersistence.save(book);
        bookRegisterPresenter.present(new BookResponse(book.getId(), book.getTitle(), book.getAuthor()));
    }

}
