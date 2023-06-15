package com.github.dericksm.controller;

import com.github.dericksm.model.mapper.BookMapper;
import com.github.dericksm.model.request.CreateBookRequestRest;
import com.github.dericksm.usecase.BookRegisterInteractor;
import com.github.dericksm.usecase.GetBookAuthorAndTitleInteractor;
import com.github.dericksm.usecase.GetBookByIdInteractor;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final GetBookByIdInteractor getBookByIdInteractor;
    private final GetBookAuthorAndTitleInteractor getBookAuthorAndTitleInteractor;
    private final BookRegisterInteractor bookRegisterInteractor;
    private final BookMapper bookMapper;

    @GetMapping("/{id}")
    public void getById(@PathVariable("id") @NotEmpty UUID id) {
        getBookByIdInteractor.getById(id);
    }

    @GetMapping
    public void getByTitleAndAuthor(@RequestParam("title") final String title, @RequestParam("author") final String author) {
        getBookAuthorAndTitleInteractor.getByTitleAndAuthor(title, author);
    }

    @PostMapping
    public void create(@Valid @RequestBody final CreateBookRequestRest bookRequest) {
        bookRegisterInteractor.registerBook(bookMapper.toUseCaseRequest(bookRequest));
    }

}
