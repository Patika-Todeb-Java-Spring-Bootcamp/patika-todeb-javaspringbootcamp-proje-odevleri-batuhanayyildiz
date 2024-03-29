package com.todeb.batuhanayyildiz.libraryautomationapplication.repository;


import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WriterRepository extends JpaRepository<Writer, Long> {
    Optional<Writer> findWriterByName(String writerName);
}
