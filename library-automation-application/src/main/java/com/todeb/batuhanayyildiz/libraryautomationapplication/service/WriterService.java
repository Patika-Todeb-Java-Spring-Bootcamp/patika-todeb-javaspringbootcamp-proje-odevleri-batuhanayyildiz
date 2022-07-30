package com.todeb.batuhanayyildiz.libraryautomationapplication.service;



import com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto.WriterDTO;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Writer;

import java.util.List;

public interface WriterService {
    List<Writer> getAllWriters();

    Writer getWriterById(Long id);

    Writer createWriter(WriterDTO writerDTO);

    Writer updateWriter(String writerName, WriterDTO writerDTO);

    boolean deleteWriter(Long id);
}
