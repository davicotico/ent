package com.davidticona.ent.service.impl;

import com.davidticona.ent.domain.dto.AdjacentItem;
import com.davidticona.ent.domain.dto.TreeNode;
import com.davidticona.ent.domain.entity.Role;
import com.davidticona.ent.domain.projection.AdjacentPermission;
import com.davidticona.ent.domain.projection.RoleProjection;
import com.davidticona.ent.domain.repository.RoleRepository;
import com.davidticona.ent.service.RoleService;
import com.davidticona.ent.util.Tree;
import com.davidticona.ent.util.mapper.PermissionMapper;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author David Tomas Ticona
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository repository;
    
    @Autowired
    private PermissionMapper permissionMaper;
    
    @Override
    public void create(Role role) {
        this.repository.save(role);
    }

    @Override
    public List<Role> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<RoleProjection> getAll(Integer applicationId) {
        return repository.findAll(applicationId);
    }

    @Override
    public void update(Integer id, Role role) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean roleExists(Integer id) {
        return repository.existsById(id);
    }

    @Override
    public boolean roleExists(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addPermission(Integer permissionId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removePermission(Integer permissionId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<AdjacentItem> getPermissions(Integer roleId, Integer applicationId) {
        List<AdjacentPermission> permissions = repository.getPermissionsByRoleId(roleId, applicationId);
        return permissionMaper.toAdjacentItem(permissions);
    }

    @Override
    public List<TreeNode> getPermissionsTrees(Integer roleId, Integer applicationId) {
        List<TreeNode> trees = new LinkedList<>();
        List<AdjacentPermission> permissions = repository.getPermissionsTreesByRoleId(roleId, applicationId);
        List<AdjacentPermission> rootPermissions = permissions.stream().filter(item -> item.getIsRoot() == true).toList();
        Tree treeBuilder = new Tree(permissionMaper.toAdjacentItem(permissions));
        for (AdjacentPermission item : rootPermissions) {
            TreeNode newTree = new TreeNode(item.getId(), item.getCode(), item.getName());
            newTree.setChildren(treeBuilder.getTree(item.getId()));
            trees.add(newTree);
        }
        return trees;
    }

    
    
}
