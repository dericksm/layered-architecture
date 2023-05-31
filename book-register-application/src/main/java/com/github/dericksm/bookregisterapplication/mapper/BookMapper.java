package com.github.dericksm.bookregisterapplication.mapper;

import com.github.dericksm.bookregisterapplication.model.dto.request.BookRequest;
import com.github.dericksm.bookregisterapplication.model.dto.response.BookResponse;
import com.github.dericksm.bookregisterapplication.model.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    Book fromBookRequest(final BookRequest bookRequest);
    BookResponse toBookResponse(final Book bookResponse);


}
