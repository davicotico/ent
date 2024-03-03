package com.davidticona.ent.service.impl;

import com.davidticona.ent.domain.dto.AppRequestDto;
import com.davidticona.ent.domain.dto.AppResponseDto;
import com.davidticona.ent.domain.entity.AppEntity;
import com.davidticona.ent.domain.repository.AppRepository;
import com.davidticona.ent.service.AppService;
import com.davidticona.ent.util.mapper.AppMapper;
import com.davidticona.ent.validator.ObjectValidator;
import jakarta.persistence.EntityNotFoundException;
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
    public AppResponseDto create(AppRequestDto appDto) {
        validator.validate(appDto);
        return mapper.toDto(repository.save(mapper.toEntity(appDto)));
    }

    @Override
    public AppResponseDto update(Integer id, AppRequestDto appDto) {
        validator.validate(appDto);
        AppEntity app = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
        app.setCode(appDto.code());
        app.setName(appDto.name());
        app.setDescription(appDto.description());
        app.setUrl(appDto.url());
        return mapper.toDto(repository.save(app));
    }

    @Override
    public void delete(Integer id) {
        AppEntity app = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
        repository.delete(app);
    }

}
