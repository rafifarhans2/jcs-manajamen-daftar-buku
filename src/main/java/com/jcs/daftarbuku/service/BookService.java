package com.jcs.daftarbuku.service;


import com.jcs.daftarbuku.entity.Book;

import java.util.List;

public interface BookService {

    Book create(Book book);
    List<Book> getAll();
    Book getById(Long id);
    Book update(Book book);
    void deleteById(Long id);
}
