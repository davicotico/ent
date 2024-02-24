package com.davidticona.ent.service.impl;

import com.davidticona.ent.domain.entity.Permission;
import com.davidticona.ent.domain.projection.AdjacentPermission;
import com.davidticona.ent.domain.repository.PermissionRepository;
import com.davidticona.ent.service.PermissionService;
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

    @Override
    public void create(Permission permission) {
        repository.save(permission);
    }

    @Override
    public List<Permission> read() {
        return repository.findAll();
    }
    
    @Override
    public List<AdjacentPermission> getAll() {
        return repository.getAllPermissions();
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean permissionExists(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
