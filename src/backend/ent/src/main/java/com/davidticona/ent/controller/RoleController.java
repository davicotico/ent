package com.davidticona.ent.controller;

import com.davidticona.ent.domain.entity.Role;
import com.davidticona.ent.service.RoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author David Tomas Ticona
 */
@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;
    
    @GetMapping
    public List<Role> read() {
        return roleService.read();
    }
}
