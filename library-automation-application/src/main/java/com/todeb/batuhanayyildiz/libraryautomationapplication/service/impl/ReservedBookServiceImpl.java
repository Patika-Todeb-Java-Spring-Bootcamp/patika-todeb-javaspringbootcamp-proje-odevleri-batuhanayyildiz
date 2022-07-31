package com.todeb.batuhanayyildiz.libraryautomationapplication.service.impl;

import com.todeb.batuhanayyildiz.libraryautomationapplication.exception.NotFoundException;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto.ReservedBookDTO;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.ReservedBook;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.mapper.ReservedBookMapper;
import com.todeb.batuhanayyildiz.libraryautomationapplication.repository.ReservedBookRepository;
import com.todeb.batuhanayyildiz.libraryautomationapplication.service.ReservedBookService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ReservedBookServiceImpl implements ReservedBookService {
    private final ReservedBookRepository reservedBookRepository;

    private static final ReservedBookMapper RESERVEDBOOK_MAPPER = Mappers.getMapper(ReservedBookMapper.class);

    @Override
    public List<ReservedBook> getAllReservedBooks() {
        return reservedBookRepository.findAll();
    }

    @Override
    public ReservedBook getReservedBookById(Long id){
        Optional<ReservedBook> byId = reservedBookRepository.findById(id);
        return byId.orElseThrow(()-> new NotFoundException("ReservedBook"));
    }

    @Override
    public ReservedBook createReservedBook(ReservedBookDTO reservedBookDTO){
        ReservedBook reservedBook = RESERVEDBOOK_MAPPER.toEntity(reservedBookDTO);
        return reservedBookRepository.save(reservedBook);
    }

    @Override
    public ReservedBook updateReservedBook(String reservedBookName,ReservedBookDTO reservedBookDTO) {
        Optional<ReservedBook> reservedBookByName = reservedBookRepository.findReservedBookByName(reservedBookName);
        if (!reservedBookByName.isPresent()) {
            throw new NotFoundException("ReservedBook");
        }
        ReservedBook updatedReservedBook = reservedBookByName.get();
        if (!ObjectUtils.isEmpty(reservedBookDTO.getReturnDate())){
            updatedReservedBook.setReturnDate(reservedBookDTO.getReturnDate());
        }

        return reservedBookRepository.save(updatedReservedBook);
    }

    @Override
    public boolean deleteReservedBook(Long reservedBookId){
        ReservedBook reservedBook=getReservedBookById(reservedBookId);
        if(!ObjectUtils.isEmpty(reservedBook)){
            reservedBookRepository.delete(getReservedBookById(reservedBookId));
            return true;
        }
        else throw new NotFoundException("id"+""+reservedBookId.toString());

    }
}
