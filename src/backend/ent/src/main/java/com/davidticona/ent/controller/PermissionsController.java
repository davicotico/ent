package com.davidticona.ent.controller;

import com.davidticona.ent.domain.dto.permission.PermissionRequestDto;
import com.davidticona.ent.domain.dto.permission.PermissionResponseDto;
import com.davidticona.ent.service.PermissionService;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    PermissionService service;
    
    @GetMapping
    public ResponseEntity<?>getAll(
            @RequestHeader(name = "Application-Id") Integer applicationId,
            @RequestParam(name = "showTree") Optional<Boolean> showTree) {
        if (showTree.isPresent() && Objects.equals(showTree.get(), Boolean.TRUE)) {
            return ResponseEntity.ok(service.getAllTreeView(applicationId));
        }
        return ResponseEntity.ok(service.getAll(applicationId));
    }
    
    @PostMapping
    public ResponseEntity<PermissionResponseDto> create(
            @RequestBody PermissionRequestDto permission) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.create(permission));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity update(
            @PathVariable Integer id, 
            @RequestBody PermissionRequestDto permissionDto) {
        service.update(id, permissionDto);
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
