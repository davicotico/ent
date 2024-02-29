package com.davidticona.ent.controller;

import com.davidticona.ent.domain.dto.PermissionRequestDto;
import com.davidticona.ent.domain.dto.PermissionResponseDto;
import com.davidticona.ent.service.PermissionService;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @PostMapping
    public ResponseEntity<PermissionResponseDto> add(
            @RequestBody PermissionRequestDto permission) {
        return ResponseEntity.ok(permissionService.create(permission));
    }
}
