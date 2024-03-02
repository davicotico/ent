package com.davidticona.ent.service.impl;

import com.davidticona.ent.domain.dto.RoleRequestDto;
import com.davidticona.ent.domain.dto.RoleResponseDto;
import com.davidticona.ent.util.Tree.AdjacentItem;
import com.davidticona.ent.util.Tree.TreeNode;
import com.davidticona.ent.domain.entity.Role;
import com.davidticona.ent.domain.repository.RoleRepository;
import com.davidticona.ent.service.RoleService;
import com.davidticona.ent.util.Tree.Tree;
import com.davidticona.ent.util.mapper.PermissionMapper;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.davidticona.ent.domain.projection.AdjacentItemProjection;
import com.davidticona.ent.util.mapper.RoleMapper;
import com.davidticona.ent.validator.ObjectValidator;

/**
 *
 * @author David Tomas Ticona
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository repository;
    
    @Autowired
    private PermissionMapper permissionMapper;
    
    @Autowired
    private RoleMapper roleMapper;
    
    private final ObjectValidator<RoleRequestDto> validator;

    public RoleServiceImpl(ObjectValidator<RoleRequestDto> validator) {
        this.validator = validator;
    }
    
    @Override
    public RoleResponseDto create(RoleRequestDto role) {
        validator.validate(role);
        return roleMapper.toDto(this.repository.save(roleMapper.toEntity(role)));
    }

    @Override
    public List<Role> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<AdjacentItem> getAll(Integer applicationId) {
        return roleMapper.entityToAdjacentItem(
                repository.findByApplicationId(applicationId)
        );
    }
    
    @Override
    public List<TreeNode> getAllTreeView(Integer applicationId) {
        return new Tree(this.getAll(applicationId)).getTree();
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
    public List<AdjacentItem> getPermissions(Integer applicationId, Integer roleId) {
        List<AdjacentItemProjection> permissions = repository.getPermissionsByRoleId(roleId, applicationId);
        return permissionMapper.toAdjacentItem(permissions);
    }

    @Override
    public List<TreeNode> getPermissionsTrees(Integer applicationId, Integer roleId) {
        List<TreeNode> trees = new LinkedList<>();
        List<AdjacentItemProjection> permissions = repository.getPermissionsTreesByRoleId(applicationId, roleId);
        List<AdjacentItemProjection> rootPermissions = permissions.stream().filter(item -> item.getIsRoot() == true).toList();
        Tree treeBuilder = new Tree(permissionMapper.toAdjacentItem(permissions));
        for (AdjacentItemProjection item : rootPermissions) {
            TreeNode newTree = new TreeNode(item.getId(), item.getCode(), item.getName());
            newTree.setChildren(treeBuilder.getTree(item.getId()));
            trees.add(newTree);
        }
        return trees;
    }    
}
