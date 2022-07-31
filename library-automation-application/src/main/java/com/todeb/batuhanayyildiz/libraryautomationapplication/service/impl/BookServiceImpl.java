package com.todeb.batuhanayyildiz.libraryautomationapplication.service.impl;



import com.todeb.batuhanayyildiz.libraryautomationapplication.exception.CustomJwtException;
import com.todeb.batuhanayyildiz.libraryautomationapplication.exception.NotFoundException;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto.BookDTO;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Book;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.mapper.BookMapper;
import com.todeb.batuhanayyildiz.libraryautomationapplication.repository.BookRepository;
import com.todeb.batuhanayyildiz.libraryautomationapplication.service.BookService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private static final BookMapper BOOK_MAPPER = Mappers.getMapper(BookMapper.class);

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id){
        Optional<Book> byId = bookRepository.findById(id);
        return byId.orElseThrow(()-> new NotFoundException("Book"));
    }

    @Override
    public Book createBook(BookDTO bookDTO){
        if (!bookRepository.existsByName(bookDTO.getName())){
            Book book = BOOK_MAPPER.toEntity(bookDTO);
            return bookRepository.save(book);
        }
        else {
            throw new CustomJwtException("There is a book with same name.", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Book updateBook(String bookName,BookDTO bookDTO) {
        Optional<Book> bookByName = bookRepository.findBookByName(bookName);
        if (!bookByName.isPresent()) {
            throw new NotFoundException("Book");
        }
        Book updatedBook = bookByName.get();
        if (!ObjectUtils.isEmpty(bookDTO.getName())){
            updatedBook.setName(bookDTO.getName());
        }
        if (!ObjectUtils.isEmpty(bookDTO.getOverview())){
            updatedBook.setOverview(bookDTO.getOverview());
        }
        if (!ObjectUtils.isEmpty(bookDTO.getWriters())){
            updatedBook.setWriters(bookDTO.getWriters());
        }
        return bookRepository.save(updatedBook);
    }

    @Override
    public boolean deleteBook(Long bookId){
        Book book=getBookById(bookId);
        if(!ObjectUtils.isEmpty(book)){
            bookRepository.delete(getBookById(bookId));
            return true;
        }
        else throw new NotFoundException("id"+""+bookId.toString());

    }



}
