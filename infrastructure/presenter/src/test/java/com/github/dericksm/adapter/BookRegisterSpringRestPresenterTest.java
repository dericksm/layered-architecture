package com.github.dericksm.adapter;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import com.github.dericksm.model.response.BookResponse;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpResponse;

@ExtendWith({MockitoExtension.class})
class BookRegisterSpringRestPresenterTest {

    @Mock
    private HttpServletResponse httpServletResponse;

    @Mock
    private MappingJackson2HttpMessageConverter jacksonConverter;

    @InjectMocks
    private BookRegisterSpringRestPresenter bookRegisterSpringRestPresenter;

    @Test
    void present_shouldSerializeResponse() throws IOException {
        var bookResponseMock = new BookResponse();
        bookRegisterSpringRestPresenter.present(bookResponseMock);
        verify(jacksonConverter)
            .write(eq(bookResponseMock), eq(MediaType.APPLICATION_JSON), any(ServerHttpResponse.class));
    }
}
