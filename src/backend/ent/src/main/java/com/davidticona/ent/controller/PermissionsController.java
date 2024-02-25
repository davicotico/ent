package com.davidticona.ent.controller;

import com.davidticona.ent.util.Tree.TreeNode;
import com.davidticona.ent.service.PermissionService;
import com.davidticona.ent.util.Tree.Tree;
import com.davidticona.ent.util.mapper.PermissionMapper;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @GetMapping
    public ResponseEntity<?>getAll(
            @RequestHeader(name = "Application-Id") Integer applicationId,
            @RequestParam(name = "showTree") Optional<Boolean> showTree) {
        if (showTree.isPresent() && Objects.equals(showTree.get(), Boolean.TRUE)) {
            return ResponseEntity.ok(permissionService.getAllTreeView(applicationId));
        }
        return ResponseEntity.ok(permissionService.getAll(applicationId));
    }
}
