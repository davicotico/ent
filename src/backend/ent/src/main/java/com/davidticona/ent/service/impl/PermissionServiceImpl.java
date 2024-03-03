package com.davidticona.ent.service.impl;

import com.davidticona.ent.domain.dto.permission.PermissionRequestDto;
import com.davidticona.ent.domain.dto.permission.PermissionResponseDto;
import com.davidticona.ent.util.Tree.TreeNode;
import com.davidticona.ent.domain.entity.Permission;
import com.davidticona.ent.domain.repository.PermissionRepository;
import com.davidticona.ent.exceptions.ConflictException;
import com.davidticona.ent.service.PermissionService;
import com.davidticona.ent.util.Tree.AdjacentItem;
import com.davidticona.ent.util.Tree.Tree;
import com.davidticona.ent.util.mapper.PermissionMapper;
import com.davidticona.ent.validator.ObjectValidator;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.util.LinkedList;
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
    
    private final ObjectValidator<PermissionRequestDto> validator;

    public PermissionServiceImpl(ObjectValidator<PermissionRequestDto> validator) {
        this.validator = validator;
    }

    @Override
    public PermissionResponseDto create(PermissionRequestDto permission) {
        validator.validate(permission);
        return mapper.toDto(repository.save(mapper.toEntity(permission)));
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
    @Transactional
    public PermissionResponseDto update(Integer id, PermissionRequestDto permissionDto) {
        validator.validate(permissionDto);
        Permission permission = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
        permission.setCode(permissionDto.code());
        permission.setName(permissionDto.name());
        return mapper.toDto(repository.save(permission));
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Permission permission = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
        List<String> errors = new LinkedList<>();
        if (hasRoles(id)) {
            errors.add("Unable to delete record as it has associated roles");
        }
        if (hasChildren(id)) {
            errors.add("Unable to delete record as it has associated permissions");
        }
        if (!errors.isEmpty()) {
            throw new ConflictException(errors);
        }
        repository.delete(permission);
    }

    @Override
    public boolean permissionExists(Integer id) {
        return repository.existsById(id);
    }

    @Override
    public boolean permissionExists(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
