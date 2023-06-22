package com.github.dericksm.mapper;

import com.github.dericksm.entity.BookEntity;
import com.github.dericksm.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookEntity toBookEntity(final Book book);

    Book toBook(final BookEntity book);

}
