package com.davidticona.ent.service.impl;

import com.davidticona.ent.domain.dto.user.UserRequestDto;
import com.davidticona.ent.domain.dto.user.UserResponseDto;
import com.davidticona.ent.domain.entity.User;
import com.davidticona.ent.domain.projection.AdjacentItemProjection;
import com.davidticona.ent.domain.projection.UserProjection;
import com.davidticona.ent.domain.repository.UserRepository;
import com.davidticona.ent.exceptions.ConflictException;
import com.davidticona.ent.service.UserService;
import com.davidticona.ent.util.Tree.AdjacentItem;
import com.davidticona.ent.util.Tree.Tree;
import com.davidticona.ent.util.Tree.TreeNode;
import com.davidticona.ent.util.mapper.RoleMapper;
import com.davidticona.ent.util.mapper.UserMapper;
import com.davidticona.ent.validator.ObjectValidator;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author David Tomas Ticona Saravia
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository repository;
    
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private RoleMapper roleMapper;
    
    private final ObjectValidator<UserRequestDto> validator;
    
    @Override
    @Transactional
    public UserResponseDto create(UserRequestDto userDto) {
        validator.validate(userDto);
        User user = userMapper.toEntity(userDto);
        return userMapper.toDto(this.repository.save(user));
    }

    @Override
    public List<UserProjection> read(Integer applicationId) {
        return this.repository.findAll(applicationId);
    }
    
    @Override
    @Transactional
    public void update(Integer id, UserRequestDto userDto) {
        validator.validate(userDto);
        User user = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
        user.setEmail(userDto.email());
        repository.save(user);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
        List<String> errors = new LinkedList<>();
        if (hasApplications(id)) {
            errors.add("Unable to delete record as it has associated applications");
        }
        if (hasRoles(id)) {
            errors.add("Unable to delete record as it has associated roles");
        }
        if (!errors.isEmpty()) {
            throw new ConflictException(errors);
        }
        repository.delete(user);
    }

    @Override
    public boolean userExists(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean userHasRoles(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void authenticate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<String> getAuthorizationList() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addRole(Integer roleId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addRole(List<Integer> roleIds) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeRole(Integer roleId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeRole(List<Integer> roleIds) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<AdjacentItem> getRoles(Integer applicationId, Integer userId) {
        return roleMapper.toAdjacentItem(repository.getRolesByUserId(applicationId, userId));
    }

    @Override
    public List<TreeNode> getRolesTrees(Integer applicationId, Integer roleId) {
        List<TreeNode> trees = new LinkedList<>();
        List<AdjacentItemProjection> roles = repository.getRolesTreesByRoleId(applicationId, roleId);
        List<AdjacentItemProjection> rootRoles = roles.stream().filter(item -> item.getIsRoot() == true).toList();
        Tree treeBuilder = new Tree(roleMapper.toAdjacentItem(roles));
        for (AdjacentItemProjection item : rootRoles) {
            TreeNode newTree = new TreeNode(item.getId(), item.getCode(), item.getName());
            newTree.setChildren(treeBuilder.getTree(item.getId()));
            trees.add(newTree);
        }
        return trees;
    }

    @Override
    public boolean hasApplications(Integer userId) {
        return (repository.hasApplications(userId) > 0);
    }

    @Override
    public boolean hasRoles(Integer userId) {
        return (repository.hasRoles(userId) > 0);
    }
    
}
