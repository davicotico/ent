package com.davidticona.ent.service.impl;

import com.davidticona.ent.domain.dto.AppRequestDto;
import com.davidticona.ent.domain.dto.AppResponseDto;
import com.davidticona.ent.domain.repository.AppRepository;
import com.davidticona.ent.service.AppService;
import com.davidticona.ent.util.mapper.AppMapper;
import com.davidticona.ent.validator.ObjectValidator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author David Tomas Ticona
 */
@Service
public class AppServiceImpl implements AppService{

    @Autowired
    AppRepository repository;
    
    @Autowired
    AppMapper mapper;
    
    private final ObjectValidator<AppRequestDto> validator;

    public AppServiceImpl(ObjectValidator<AppRequestDto> validator) {
        this.validator = validator;
    }

    @Override
    public List<AppResponseDto> getAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public AppResponseDto create(AppRequestDto app) {
        validator.validate(app);
        return mapper.toDto(repository.save(mapper.toEntity(app)));
    }

}
