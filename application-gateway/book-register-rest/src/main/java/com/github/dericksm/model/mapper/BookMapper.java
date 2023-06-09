package com.github.dericksm.model.mapper;

import com.github.dericksm.model.Book;
import com.github.dericksm.model.request.CreateBookRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    Book toBook(final CreateBookRequest bookRequest);


}
