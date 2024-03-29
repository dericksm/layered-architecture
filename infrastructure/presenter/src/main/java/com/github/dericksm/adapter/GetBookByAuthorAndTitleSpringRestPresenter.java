package com.github.dericksm.adapter;

import com.github.dericksm.model.response.BookResponse;
import com.github.dericksm.port.output.presenter.GetBookByAuthorAndTitlePresenter;
import com.github.dericksm.port.output.presenter.GetBookByIdPresenter;
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
public class GetBookByAuthorAndTitleSpringRestPresenter implements GetBookByAuthorAndTitlePresenter {

    private final HttpServletResponse httpServletResponse;
    private final MappingJackson2HttpMessageConverter jacksonConverter;

    @Override
    public void present(final BookResponse bookResponse) {
        final DelegatingServerHttpResponse httpOutputMessage =
            new DelegatingServerHttpResponse(new ServletServerHttpResponse(httpServletResponse));

        httpOutputMessage.setStatusCode(HttpStatus.OK);

        try {
            jacksonConverter.write(bookResponse, MediaType.APPLICATION_JSON, httpOutputMessage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
