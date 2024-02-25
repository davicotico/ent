package com.davidticona.ent.service.impl;

import com.davidticona.ent.util.Tree.TreeNode;
import com.davidticona.ent.domain.entity.Permission;
import com.davidticona.ent.domain.repository.PermissionRepository;
import com.davidticona.ent.service.PermissionService;
import com.davidticona.ent.util.Tree.AdjacentItem;
import com.davidticona.ent.util.Tree.Tree;
import com.davidticona.ent.util.mapper.PermissionMapper;
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

    @Override
    public void create(Permission permission) {
        repository.save(permission);
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
