package com.github.dericksm.bookregisterapplication.controller;

import com.github.dericksm.bookregisterapplication.mapper.BookMapper;
import com.github.dericksm.bookregisterapplication.model.dto.request.BookRequest;
import com.github.dericksm.bookregisterapplication.model.dto.response.BookResponse;
import com.github.dericksm.bookregisterapplication.model.entity.Book;
import com.github.dericksm.bookregisterapplication.service.BookService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    @PostMapping
    ResponseEntity<BookResponse> create(@Valid @RequestBody final BookRequest bookRequest) {
        var book = new Book();
        book.setAuthor(bookRequest.getAuthor());
        book.setTitle(bookRequest.getTitle());
        book = bookService.create(book);
        return ResponseEntity.ok(bookMapper.toBookResponse(book));
    }

    @GetMapping("/{id}")
    ResponseEntity<BookResponse> getById(@PathVariable("id") @NotEmpty UUID id) {
        return ResponseEntity.ok(bookMapper.toBookResponse(bookService.getById(id)));
    }

}
