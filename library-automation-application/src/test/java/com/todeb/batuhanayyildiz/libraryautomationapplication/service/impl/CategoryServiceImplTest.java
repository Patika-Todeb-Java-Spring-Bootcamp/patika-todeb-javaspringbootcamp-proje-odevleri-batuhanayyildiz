package com.todeb.batuhanayyildiz.libraryautomationapplication.service.impl;

import com.todeb.batuhanayyildiz.libraryautomationapplication.exception.NotFoundException;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto.CategoryDTO;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Category;
import com.todeb.batuhanayyildiz.libraryautomationapplication.repository.CategoryRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Test
    void getAllCategories() {

        // init
        List<Category> expectedCategories= createSampleCategories();
        // stub
        Mockito.when(categoryRepository.findAll()).thenReturn(expectedCategories);
        // then
        List<Category> actualCategories=categoryService.getAllCategories();
        Assert.assertEquals(expectedCategories.size(),actualCategories.size());
        //Sorting
        expectedCategories=expectedCategories.stream().sorted(getCategoryComparator()).collect(Collectors.toList());
        actualCategories=actualCategories.stream().sorted(getCategoryComparator()).collect(Collectors.toList());

        for( int i=0; i<actualCategories.size(); i++){
            Category categoryExp= expectedCategories.get(i);
            Category categoryAct= actualCategories.get(i);

            Assert.assertEquals(categoryAct.getId(),categoryExp.getId());
            Assert.assertEquals(categoryAct.getName(),categoryExp.getName());
        }


    }

    @Test
    void getCategoryById_Successful() {
        //init
        Category expectedCategory = createSampleCategories().get(0);
        Optional<Category> optExpectedCategory = Optional.of(expectedCategory);
        //stub
        Mockito.when(categoryRepository.findById(any())).thenReturn(optExpectedCategory);
        //then
        Category actualCategory = categoryService.getCategoryById(1L);

        Assert.assertEquals(actualCategory.getName(),expectedCategory.getName());
        Assert.assertEquals(actualCategory.getId(),expectedCategory.getId());



    }

    @Test
    void getCategoryById_Fail_NOT_FOUND() {

        //stub
        Mockito.when(categoryRepository.findById(any())).thenReturn(Optional.empty());
        //then
        assertThrows(NotFoundException.class,
                ()->{ Category actCategory=categoryService.getCategoryById(1L);
        }
        );




    }

    @Test
    void createCategory() {
        //init
        Category expectedCategory = createSampleCategories().get(0);
        expectedCategory.setId(null);

        //stub
        Mockito.when(categoryRepository.save((any()))).thenReturn(expectedCategory);

        //then
        CategoryDTO categoryDTO=new CategoryDTO();
        categoryDTO.setName("Fiction");

        Category actualCategory =  categoryService.createCategory(categoryDTO);

        verify(categoryRepository,times(1)).save(expectedCategory);
        Assert.assertEquals(expectedCategory.getName(),actualCategory.getName());

    }

    @Test
    void updateCategory() {
        //init
        Category sampleCategory = createSampleCategories().get(0);
        Optional<Category> optSampleCategory = Optional.of(sampleCategory);

        Category expectedCategory = new Category();
        expectedCategory.setName("Adventure");
        expectedCategory.setId(sampleCategory.getId());
        CategoryDTO categoryDTO= new CategoryDTO("Adventure");

        //stub
        Mockito.when(categoryRepository.findCategoryByName(any())).thenReturn(optSampleCategory);
        Mockito.when(categoryRepository.save((any()))).thenReturn(expectedCategory);
        //then
        Category actualCategory = categoryService.updateCategory(sampleCategory.getName(),categoryDTO);

        verify(categoryRepository,times(1)).save(expectedCategory);
        Assert.assertEquals(expectedCategory.getName(),actualCategory.getName());


    }

    @Test
    void deleteCategory() {

        //init
        Long categoryId = 1L;
        Category category= createSampleCategories().get(0);
        //stub
        Mockito.when(categoryRepository.findById(categoryId)).thenReturn(Optional.of(category));
        doNothing().when(categoryRepository).delete(category);
        //then
        categoryService.deleteCategory(1L);

        verify(categoryRepository,times(1)).delete(category);
    }


    private List<Category> createSampleCategories(){
        List<Category> sampleList= new ArrayList<>();

        Category exampleC1 = new Category();
        exampleC1.setName("Fiction");
        exampleC1.setId(1L);

        Category exampleC2 = new Category();
        exampleC2.setName("Adventure");
        exampleC2.setId(2L);

        Category exampleC3 = new Category();
        exampleC3.setName("Action");
        exampleC3.setId(3L);

        sampleList.add(exampleC1);
        sampleList.add(exampleC2);
        sampleList.add(exampleC3);

        return sampleList;
    }
    private Comparator<Category> getCategoryComparator() {
        return (c1, c2) -> {
            if (c1.getId() - c2.getId() > 0)
                return 1;
            if (c1.getId() - c2.getId() == 0)
                return 0;
            return -1;
        };
    }


}