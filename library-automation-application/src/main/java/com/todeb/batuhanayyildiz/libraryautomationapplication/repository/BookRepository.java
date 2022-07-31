package com.todeb.batuhanayyildiz.libraryautomationapplication.repository;

import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findBookByName(String bookName);
    boolean existsByName(String username);

}
