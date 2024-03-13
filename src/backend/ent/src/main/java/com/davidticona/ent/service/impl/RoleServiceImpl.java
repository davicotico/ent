package com.davidticona.ent.service.impl;

import com.davidticona.ent.domain.EntityFactory;
import com.davidticona.ent.domain.dto.role.RoleRequestDto;
import com.davidticona.ent.domain.dto.role.RoleResponseDto;
import com.davidticona.ent.domain.dto.role.RoleUpdateRequestDto;
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
import com.davidticona.ent.validator.RoleValidator;
import jakarta.persistence.EntityNotFoundException;

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
    
    @Autowired
    private RoleValidator roleValidator;
    
    private final ObjectValidator validator;

    public RoleServiceImpl(ObjectValidator validator) {
        this.validator = validator;
    }

    @Override
    public RoleResponseDto createRoot(Integer applicationId) {
        roleValidator.validateBeforeCreateRoot(applicationId);
        return roleMapper.toDto(repository.save(EntityFactory.rootRole(applicationId)));
    }

    @Override
    public RoleResponseDto create(RoleRequestDto role) {
        validator.validate(role);
        roleValidator.validateBeforeCreate(role);
        return roleMapper.toDto(this.repository.save(roleMapper.toEntity(role)));
    }
    
    @Override
    public RoleResponseDto update(Integer id, RoleUpdateRequestDto roleDto) {
        validator.<RoleUpdateRequestDto>validate(roleDto);
        Role role = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role does not exists"));
        roleValidator.validateBeforeUpdate(role, roleDto);
        role.setCode(roleDto.code());
        role.setName(roleDto.name());
        return roleMapper.toDto(repository.save(role));
    }
    
    @Override
    public void delete(Integer id) {
        Role role = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
        roleValidator.validateBeforeDelete(id);
        repository.delete(role);
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

    @Override
    public boolean hasUsers(Integer id) {
        return (repository.countUsers(id) > 0);
    }

    @Override
    public boolean hasPermissions(Integer id) {
        return (repository.countPermissions(id) > 0);
    }

    @Override
    public boolean hasChildren(Integer id) {
        return (repository.countChildren(id) > 0);
    }
}
