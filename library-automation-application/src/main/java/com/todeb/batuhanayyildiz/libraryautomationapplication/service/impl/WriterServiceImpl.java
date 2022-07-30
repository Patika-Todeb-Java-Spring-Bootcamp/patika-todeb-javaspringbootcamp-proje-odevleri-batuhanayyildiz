package com.todeb.batuhanayyildiz.libraryautomationapplication.service.impl;


import com.todeb.batuhanayyildiz.libraryautomationapplication.exception.NotFoundException;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto.WriterDTO;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Writer;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.mapper.WriterMapper;
import com.todeb.batuhanayyildiz.libraryautomationapplication.repository.WriterRepository;
import com.todeb.batuhanayyildiz.libraryautomationapplication.service.WriterService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class WriterServiceImpl implements WriterService {
    private final WriterRepository writerRepository;

    private static final WriterMapper WRITER_MAPPER = Mappers.getMapper(WriterMapper.class);

    @Override
    public List<Writer> getAllWriters() {
        return writerRepository.findAll();
    }

    @Override
    public Writer getWriterById(Long id){
        Optional<Writer> byId = writerRepository.findById(id);
        return byId.orElseThrow(()-> new NotFoundException("Writer"));
    }

    @Override
    public Writer createWriter(WriterDTO writerDTO){
        Writer writer = WRITER_MAPPER.toEntity(writerDTO);
        return writerRepository.save(writer);
    }

    @Override
    public Writer updateWriter(String writerName,WriterDTO writerDTO) {
        Optional<Writer> writerByName = writerRepository.findWriterByName(writerName);
        if (!writerByName.isPresent()) {
            throw new NotFoundException("Writer");
        }
        Writer updatedWriter = writerByName.get();
        if (!ObjectUtils.isEmpty(writerDTO.getName())){
            updatedWriter.setName(writerDTO.getName());
        }
        if (!ObjectUtils.isEmpty(writerDTO.getSurname())){
            updatedWriter.setSurname(writerDTO.getSurname());
        }

        if (!ObjectUtils.isEmpty(writerDTO.getAbout())){
            updatedWriter.setAbout(writerDTO.getAbout());
        }

        if (!ObjectUtils.isEmpty(writerDTO.getBooks())){
            updatedWriter.setBooks(writerDTO.getBooks());
        }

        return writerRepository.save(updatedWriter);
    }

    @Override
    public boolean deleteWriter(Long writerId){
        Writer writer=getWriterById(writerId);
        if(!ObjectUtils.isEmpty(writer)){
            writerRepository.delete(getWriterById(writerId));
            return true;
        }
        else throw new NotFoundException("id"+""+writerId.toString());

    }

}
