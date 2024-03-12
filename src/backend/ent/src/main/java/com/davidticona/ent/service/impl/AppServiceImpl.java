package com.davidticona.ent.service.impl;

import com.davidticona.ent.domain.dto.app.AppRequestDto;
import com.davidticona.ent.domain.dto.app.AppResponseDto;
import com.davidticona.ent.domain.entity.AppEntity;
import com.davidticona.ent.domain.repository.AppRepository;
import com.davidticona.ent.exceptions.ConflictException;
import com.davidticona.ent.service.AppService;
import com.davidticona.ent.service.PermissionService;
import com.davidticona.ent.service.RoleService;
import com.davidticona.ent.util.mapper.AppMapper;
import com.davidticona.ent.validator.AppValidator;
import com.davidticona.ent.validator.ObjectValidator;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.util.LinkedList;
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
    
    @Autowired
    private RoleService roleService;
    
    @Autowired
    private PermissionService permissionService;
    
    @Autowired
    private AppValidator appValidator;
    
    private final ObjectValidator validator;

    public AppServiceImpl(ObjectValidator validator) {
        this.validator = validator;
    }

    @Override
    public List<AppResponseDto> getAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    @Transactional
    public AppResponseDto create(AppRequestDto appDto) {
        validator.validate(appDto);
        appValidator.validateBeforeCreate(appDto);
        AppEntity newApp = repository.save(mapper.toEntity(appDto));
        roleService.createRoot(newApp.getId());
        permissionService.createRoot(newApp.getId());
        return mapper.toDto(newApp);
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
        appValidator.validateBeforeDelete(id);
        repository.delete(app);
    }

    @Override
    public boolean hasUsers(Integer applicationId) {
        return (repository.countUsers(applicationId) > 0);
    }

    @Override
    public boolean hasRoles(Integer applicationId) {
        return (repository.countRoles(applicationId) > 0);
    }

    @Override
    public boolean hasPermissions(Integer applicationId) {
        return (repository.countPermissions(applicationId) > 0);
    }

}
