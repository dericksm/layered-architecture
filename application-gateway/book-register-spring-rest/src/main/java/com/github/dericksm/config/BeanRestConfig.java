package com.github.dericksm.config;

import com.github.dericksm.port.output.persistence.BookRegisterPersistence;
import com.github.dericksm.port.output.persistence.GetBookByAuthorAndTitlePersistence;
import com.github.dericksm.port.output.persistence.GetBookByIdPersistence;
import com.github.dericksm.port.output.presenter.BookRegisterPresenter;
import com.github.dericksm.port.output.presenter.GetBookByAuthorAndTitlePresenter;
import com.github.dericksm.port.output.presenter.GetBookByIdPresenter;
import com.github.dericksm.usecase.BookRegisterInteractor;
import com.github.dericksm.usecase.GetBookAuthorAndTitleInteractor;
import com.github.dericksm.usecase.GetBookByIdInteractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.github.dericksm")
@ComponentScan(basePackages = {"com.github.dericksm", "com.github.dericksm.port", "com.github.dericksm.adapter"})
public class BeanRestConfig {

    @Bean
    public GetBookByIdInteractor getBookByIdPersistence(final GetBookByIdPersistence getBookByIdPersistence,
        final GetBookByIdPresenter getBookByIdPresenter) {
        return new GetBookByIdInteractor(getBookByIdPersistence, getBookByIdPresenter);
    }

    @Bean
    public BookRegisterInteractor bookRegisterInteractor(final BookRegisterPersistence bookRegisterPersistence,
        final BookRegisterPresenter bookRegisterPresenter) {
        return new BookRegisterInteractor(bookRegisterPersistence, bookRegisterPresenter);
    }

    @Bean
    public GetBookAuthorAndTitleInteractor getBookAuthorAndTitleInteractor(
        final GetBookByAuthorAndTitlePersistence getBookByAuthorAndTitlePersistence,
        final GetBookByAuthorAndTitlePresenter getBookByAuthorAndTitlePresenter) {
        return new GetBookAuthorAndTitleInteractor(getBookByAuthorAndTitlePersistence, getBookByAuthorAndTitlePresenter);
    }


}
