package com.davidticona.ent.controller;

import com.davidticona.ent.domain.dto.Node;
import com.davidticona.ent.service.RoleService;
import com.davidticona.ent.util.Tree;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.davidticona.ent.util.mapper.RoleMapper;

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
}
