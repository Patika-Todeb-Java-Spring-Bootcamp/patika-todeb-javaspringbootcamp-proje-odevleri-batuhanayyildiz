package com.todeb.batuhanayyildiz.libraryautomationapplication.service;

import com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto.BookDTO;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Book;


import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book getBookById(Long id);

    Book createBook(BookDTO bookDTO);

    Book updateBook(String bookName,BookDTO bookDTO);

    boolean deleteBook(Long id);

    /*

    Book addCategoryToBook(Long bookId,Long categoryId );

    Book addWriterToBook(Long bookId,Long writerId );
*/

}
