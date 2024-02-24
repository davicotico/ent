package com.davidticona.ent.controller;

import com.davidticona.ent.domain.dto.TreeNode;
import com.davidticona.ent.domain.projection.AdjacentPermission;
import com.davidticona.ent.service.RoleService;
import com.davidticona.ent.util.Tree;
import com.davidticona.ent.util.mapper.PermissionMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.davidticona.ent.util.mapper.RoleMapper;
import java.util.Map;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author David Tomas Ticona Saravia
 */
@RestController
@RequestMapping("/roles")
public class RolesController {
    @Autowired
    private RoleService roleService;
    
    @Autowired
    private RoleMapper mapper;
    
    @Autowired
    private PermissionMapper permissionMaper;
    
    @GetMapping
    public List<TreeNode> read() {
        return new Tree(mapper.entityToAdjacentItem(roleService.read())).getTree();
    }
    
    @GetMapping("/{id}/permissions")
    public List<TreeNode> getPermissionsByRoleId(@PathVariable("id") Integer roleId) {
        List<AdjacentPermission> permissions = roleService.getPermissions(roleId);
        return new Tree(permissionMaper.toAdjacentItem(permissions)).getTree(1);
    }
    
    @GetMapping("/{id}/permissions-tree")
    public Map<String, List<TreeNode>> test(@PathVariable("id") Integer roleId) {
        return roleService.getPermissionsAsTree(roleId, 1);
    }
}

/*List<AdjacentItem> lista = new LinkedList<>();
lista.add(new AdjacentItem(2, 1, "Money", "Money"));
lista.add(new AdjacentItem(5, 2, "Order", "Order"));
lista.add(new AdjacentItem(6, 2, "Transfer", "Transfer"));
lista.add(new AdjacentItem(10, 4, "Financial", "Financial"));*/