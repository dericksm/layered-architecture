package com.github.dericksm.port;

import com.github.dericksm.model.Book;
import com.github.dericksm.port.presenter.GetBookByIdPresenter;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GetBookByIdSpringRestPresenter implements GetBookByIdPresenter {

    private final HttpServletResponse httpServletResponse;
    private final MappingJackson2HttpMessageConverter jacksonConverter;

    //TODO REVIEW THE MODEL
    @Override
    public void present(final Book book) {
        final DelegatingServerHttpResponse httpOutputMessage =
            new DelegatingServerHttpResponse(new ServletServerHttpResponse(httpServletResponse));

        httpOutputMessage.setStatusCode(HttpStatus.OK);

        try {
            jacksonConverter.write(book, MediaType.APPLICATION_JSON, httpOutputMessage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
