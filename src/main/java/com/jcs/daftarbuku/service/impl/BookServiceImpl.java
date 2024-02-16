package com.jcs.daftarbuku.service.impl;

import com.jcs.daftarbuku.entity.Book;
import com.jcs.daftarbuku.repository.BookRepository;
import com.jcs.daftarbuku.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book getById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Buku tidak ditemukan!"));
    }

    @Override
    public Book update(Book book) {
        Book currentBook = getById(book.getId());
        if (currentBook != null) {
            return bookRepository.save(book);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
