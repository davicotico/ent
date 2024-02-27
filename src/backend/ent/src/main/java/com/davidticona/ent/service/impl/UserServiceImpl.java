package com.davidticona.ent.service.impl;

import com.davidticona.ent.domain.entity.User;
import com.davidticona.ent.domain.projection.AdjacentItemProjection;
import com.davidticona.ent.domain.projection.UserProjection;
import com.davidticona.ent.domain.repository.UserRepository;
import com.davidticona.ent.service.UserService;
import com.davidticona.ent.util.Tree.AdjacentItem;
import com.davidticona.ent.util.Tree.Tree;
import com.davidticona.ent.util.Tree.TreeNode;
import com.davidticona.ent.util.mapper.RoleMapper;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author David Tomas Ticona Saravia
 */
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository repository;
    
    @Autowired
    private RoleMapper roleMapper;
    
    @Override
    public void create(User user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<UserProjection> read(Integer applicationId) {
        return this.repository.findAll(applicationId);
    }

    @Override
    public void update(Integer id, User user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    
}
