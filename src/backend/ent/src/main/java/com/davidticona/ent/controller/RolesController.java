package com.davidticona.ent.controller;

import com.davidticona.ent.domain.dto.AdjacentItem;
import com.davidticona.ent.domain.dto.Node;
import com.davidticona.ent.service.RoleService;
import com.davidticona.ent.util.Tree;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.davidticona.ent.util.mapper.RoleMapper;
import java.util.LinkedList;

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
    
    @GetMapping
    public List<Node> read() {
        return new Tree(mapper.entityToAdjacentItem(roleService.read())).getTree();
    }
    
    @GetMapping("/permissions")
    public List<Node> getPermissionsByRoleId() {
        List<AdjacentItem> lista = new LinkedList<>();
        lista.add(new AdjacentItem(2, 1, "Money", "Money"));
        lista.add(new AdjacentItem(5, 2, "Order", "Order"));
        lista.add(new AdjacentItem(6, 2, "Transfer", "Transfer"));
        lista.add(new AdjacentItem(10, 4, "Financial", "Financial"));
        return new Tree(lista).getTree(1);
    }
}