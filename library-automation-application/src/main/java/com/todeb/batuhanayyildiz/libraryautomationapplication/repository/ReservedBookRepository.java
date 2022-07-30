package com.todeb.batuhanayyildiz.libraryautomationapplication.repository;

import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Book;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.ReservedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservedBookRepository extends JpaRepository<ReservedBook, Long> {
    Optional<ReservedBook> findReservedBookByName(String reservedBookName);
}
