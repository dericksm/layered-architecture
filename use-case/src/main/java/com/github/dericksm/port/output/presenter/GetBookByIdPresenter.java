package com.github.dericksm.port.output.presenter;

import com.github.dericksm.model.response.BookResponse;

public interface GetBookByIdPresenter {

    void present(final BookResponse book);
}
