package com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto;

import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Category;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Writer;
import lombok.Data;


import java.util.List;


@Data

public class BookDTO {
    private String name;
    private String overview;
    private List<Writer> writers;
    private List<Category> categories;
}
