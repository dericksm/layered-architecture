package com.github.dericksm.usecase;

import com.github.dericksm.exception.BookAlreadyExistsException;
import com.github.dericksm.model.Book;
import com.github.dericksm.port.persistence.BookRegisterPersistence;
import com.github.dericksm.port.presenter.BookRegisterPresenter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BookRegisterInteractor {

    private final BookRegisterPersistence bookRegisterPersistence;
    private final BookRegisterPresenter bookRegisterPresenter;

    public void register(Book book) {
        if (bookRegisterPersistence.existsBookByTitleAndAuthor(book.getTitle(), book.getAuthor())) {
            throw new BookAlreadyExistsException(book.getTitle(), book.getAuthor());
        }
        book = bookRegisterPersistence.save(book);
        bookRegisterPresenter.present(book);
    }

}
