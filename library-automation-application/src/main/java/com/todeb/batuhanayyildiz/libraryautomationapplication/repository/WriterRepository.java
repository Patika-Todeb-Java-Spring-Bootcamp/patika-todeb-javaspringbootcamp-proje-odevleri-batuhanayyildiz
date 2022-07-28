package com.todeb.batuhanayyildiz.libraryautomationapplication.repository;

import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WriterRepository extends JpaRepository<Writer, Long> {
}
