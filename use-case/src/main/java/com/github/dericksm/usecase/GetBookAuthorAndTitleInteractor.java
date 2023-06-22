package com.github.dericksm.usecase;

import com.github.dericksm.exception.BookNotFoundException;
import com.github.dericksm.model.response.BookResponse;
import com.github.dericksm.port.output.persistence.GetBookByAuthorAndTitlePersistence;
import com.github.dericksm.port.output.presenter.GetBookByAuthorAndTitlePresenter;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetBookAuthorAndTitleInteractor {

    private final GetBookByAuthorAndTitlePersistence getBookByAuthorAndTitlePersistence;
    private final GetBookByAuthorAndTitlePresenter getBookByAuthorAndTitlePresenter;

    public void getByTitleAndAuthor(String title, String author) {
        var book = Optional.ofNullable(getBookByAuthorAndTitlePersistence.getBookByTitleAndAuthor(title, author))
            .orElseThrow(() -> new BookNotFoundException(title, author));
        getBookByAuthorAndTitlePresenter.present(new BookResponse(book.getId(), book.getTitle(), book.getAuthor()));
    }

}
