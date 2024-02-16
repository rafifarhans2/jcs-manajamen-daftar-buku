package com.jcs.daftarbuku.controller;

import com.jcs.daftarbuku.entity.Book;
import com.jcs.daftarbuku.response.CommonResponse;
import com.jcs.daftarbuku.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/book")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<?> createNewBook(@RequestBody Book book) {
        return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.<Book>builder()
                .statusCode(HttpStatus.CREATED.value())
                .message("Sukses Input Buku!")
                .data(bookService.create(book))
                .build());
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Book> books = bookService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Berhasil! Menampilkan Semua Buku")
                .data(books)
                .build());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        List<Book> books = bookService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<Book>builder()
                .statusCode(HttpStatus.OK.value())
                .message("Berhasil! Menampilkan Buku Berdasarkan ID")
                .data(bookService.getById(id))
                .build());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updatedPatient(@RequestBody Book book) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.<Book>builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Berhasil! Memperbarui buku")
                        .data(bookService.update(book))
                        .build());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletePatientById(@PathVariable Long id) {
        bookService.deleteById(id);
        Book book = new Book();
        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.<Long>builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Berhasil! Menghapus buku")
                        .data(Long.valueOf(id))
                        .build());
    }
}
