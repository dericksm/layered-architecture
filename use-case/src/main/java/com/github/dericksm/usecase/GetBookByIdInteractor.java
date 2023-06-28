package com.github.dericksm.usecase;

import com.github.dericksm.exception.BookNotFoundException;
import com.github.dericksm.model.response.BookResponse;
import com.github.dericksm.port.output.persistence.GetBookByIdPersistence;
import com.github.dericksm.port.output.presenter.GetBookByIdPresenter;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetBookByIdInteractor {

    private final GetBookByIdPersistence getBookByIdPersistence;
    private final GetBookByIdPresenter getBookByIdPresenter;

    public void getById(final UUID uuid) {
        var book = Optional.ofNullable(getBookByIdPersistence.getBookById(uuid)).orElseThrow(() -> new BookNotFoundException(uuid));
        getBookByIdPresenter.present(new BookResponse(book.getId(), book.getTitle(), book.getAuthor()));
    }

}
