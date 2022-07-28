package com.todeb.batuhanayyildiz.libraryautomationapplication.service;

import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Book;


import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book getBook(Long id);

    Book createBook(Book book);

    Book updateBook(Book book);

    boolean deleteBook(Long id);

    Book addCategoryToBook(Long bookId,Long categoryId );

    Book addWriterToBook(Long bookId,Long writerId );


}
