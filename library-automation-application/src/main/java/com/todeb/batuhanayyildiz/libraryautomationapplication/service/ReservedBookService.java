package com.todeb.batuhanayyildiz.libraryautomationapplication.service;

import com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto.ReservedBookDTO;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.ReservedBook;

import java.util.List;

public interface ReservedBookService {
    List<ReservedBook> getAllReservedBooks();

    ReservedBook getReservedBookById(Long id);

    ReservedBook createReservedBook(ReservedBookDTO reservedBookDTO);

    ReservedBook updateReservedBook(String reservedBookName,ReservedBookDTO reservedBookDTO);

    boolean deleteReservedBook(Long id);
}
