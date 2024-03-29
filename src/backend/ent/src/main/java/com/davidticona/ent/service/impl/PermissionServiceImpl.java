package com.davidticona.ent.service.impl;

import com.davidticona.ent.domain.entity.EntityFactory;
import com.davidticona.ent.domain.dto.permission.PermissionRequestDto;
import com.davidticona.ent.domain.dto.permission.PermissionResponseDto;
import com.davidticona.ent.domain.dto.permission.PermissionUpdateRequestDto;
import com.davidticona.ent.util.Tree.TreeNode;
import com.davidticona.ent.domain.entity.Permission;
import com.davidticona.ent.domain.repository.PermissionRepository;
import com.davidticona.ent.service.PermissionService;
import com.davidticona.ent.util.Tree.AdjacentItem;
import com.davidticona.ent.util.Tree.Tree;
import com.davidticona.ent.util.mapper.PermissionMapper;
import com.davidticona.ent.validator.ObjectValidator;
import com.davidticona.ent.validator.PermissionValidator;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author David Tomas Ticona Saravia
 */
@Service
public class PermissionServiceImpl implements PermissionService{
    @Autowired
    PermissionRepository repository;
    
    @Autowired
    private PermissionMapper mapper;
    
    @Autowired
    private PermissionValidator permissionValidator;
    
    private final ObjectValidator validator;

    public PermissionServiceImpl(ObjectValidator validator) {
        this.validator = validator;
    }

    @Override
    public PermissionResponseDto create(PermissionRequestDto permission) {
        validator.validate(permission);
        permissionValidator.validateBeforeCreate(permission);
        return mapper.toDto(repository.save(mapper.toEntity(permission)));
    }
    
    @Override
    public PermissionResponseDto createRoot(Integer applicationId) {
        return mapper.toDto(repository.save(EntityFactory.createFirstPermission(applicationId)));
    }
    
    @Override
    public PermissionResponseDto update(Integer id, PermissionUpdateRequestDto permissionDto) {
        validator.<PermissionUpdateRequestDto>validate(permissionDto);
        Permission permission = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
        permissionValidator.validateBeforeUpdate(permission, permissionDto);
        permission.setCode(permissionDto.code());
        permission.setName(permissionDto.name());
        return mapper.toDto(repository.save(permission));
    }
    
    @Override
    public void delete(Integer id) {
        Permission permission = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
        permissionValidator.validateBeforeDelete(id);
        repository.delete(permission);
    }

    @Override
    public List<AdjacentItem>getAll(Integer applicationId) {
        return mapper.entityToAdjacentItem(
                repository.getAllPermissions(applicationId));
    }
    
    @Override
    public List<TreeNode> getAllTreeView(Integer applicationId) {
        return new Tree(this.getAll(applicationId)).getTree();
    }

    @Override
    public boolean permissionExists(Integer id) {
        return repository.existsById(id);
    }

    @Override
    public boolean hasRoles(Integer id) {
        return (repository.countRoles(id) > 0);
    }

    @Override
    public boolean hasChildren(Integer id) {
        return (repository.countChildren(id) > 0);
    }
}
