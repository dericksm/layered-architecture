package com.github.dericksm.model.mapper;

import com.github.dericksm.model.request.CreateBookRequest;
import com.github.dericksm.model.request.CreateBookRequestRest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    CreateBookRequest toUseCaseRequest(CreateBookRequestRest request);

}
