package com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto;

import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Category;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Writer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;


@Getter
@Setter

public class BookDTO {
    String name;
    String overview;

    @Autowired
    Writer writer;
    @Autowired
    Category category;
}
