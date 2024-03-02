package com.davidticona.ent.service.impl;

import com.davidticona.ent.domain.dto.PermissionRequestDto;
import com.davidticona.ent.domain.dto.PermissionResponseDto;
import com.davidticona.ent.util.Tree.TreeNode;
import com.davidticona.ent.domain.entity.Permission;
import com.davidticona.ent.domain.repository.PermissionRepository;
import com.davidticona.ent.service.PermissionService;
import com.davidticona.ent.util.Tree.AdjacentItem;
import com.davidticona.ent.util.Tree.Tree;
import com.davidticona.ent.util.mapper.PermissionMapper;
import com.davidticona.ent.validator.ObjectValidator;
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
    public void update(Integer id, Permission permission) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean permissionExists(Integer id) {
        return repository.existsById(id);
    }

    @Override
    public boolean permissionExists(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
