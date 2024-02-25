package com.davidticona.ent.controller;

import com.davidticona.ent.domain.dto.TreeNode;
import com.davidticona.ent.service.PermissionService;
import com.davidticona.ent.util.Tree;
import com.davidticona.ent.util.mapper.PermissionMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author David Tomas Ticona Saravia
 */
@RestController
@RequestMapping("/permissions")
public class PermissionsController {
    
    @Autowired
    PermissionService permissionService;
    
    @Autowired
    private PermissionMapper mapper;
    
    @GetMapping
    public ResponseEntity<List<TreeNode>>read(
            @RequestHeader(name = "Application-Id") Integer applicationId) {
        return ResponseEntity.ok(
                new Tree(mapper.toAdjacentItem(permissionService.getAll(applicationId))).getTree());
    }
}
