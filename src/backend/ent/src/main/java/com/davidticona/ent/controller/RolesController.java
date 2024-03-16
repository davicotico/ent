package com.davidticona.ent.controller;

import com.davidticona.ent.domain.dto.role.RoleRequestDto;
import com.davidticona.ent.domain.dto.role.RoleResponseDto;
import com.davidticona.ent.domain.dto.role.RoleUpdateRequestDto;
import com.davidticona.ent.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Objects;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author David Tomas Ticona Saravia
 */
@RestController
@RequestMapping("/roles")
public class RolesController {
    @Autowired
    private RoleService service;

    @GetMapping
    public ResponseEntity<?> getAll(
            @RequestHeader(name = "Application-Id") Integer applicationId,
            @RequestParam(name = "showTree") Optional<Boolean> showTree) {
        if (showTree.isPresent() && Objects.equals(showTree.get(), Boolean.TRUE)) {
            return ResponseEntity.ok(service.getAllTreeView(applicationId));
        }
        return ResponseEntity.ok(service.getAll(applicationId));
    }

    @GetMapping("/{id}/permissions")
    public ResponseEntity<?> getPermissionsByRoleId(
            @RequestHeader(name = "Application-Id") Integer applicationId,
            @PathVariable("id") Integer roleId,
            @RequestParam(name = "showTree") Optional<Boolean> showTree) {
        if (showTree.isPresent() && Objects.equals(showTree.get(), Boolean.TRUE)) {
            return ResponseEntity.ok(service.getPermissionsTrees(applicationId, roleId));
        }
        return ResponseEntity.ok(service.getPermissions(applicationId, roleId));
    }
    
    @PostMapping
    public ResponseEntity<RoleResponseDto> create(@RequestBody RoleRequestDto role) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.create(role));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity update(
            @PathVariable Integer id, 
            @RequestBody RoleUpdateRequestDto roleDto) {
        service.update(id, roleDto);
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}/permission/{permissionId}")
    public ResponseEntity addPermission(
            @RequestHeader(name = "Application-Id") Integer applicationId,
            @PathVariable Integer id, 
            @PathVariable Integer permissionId) {
        service.addPermission(applicationId, id, permissionId);
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/{id}/permission/{permissionId}")
    public ResponseEntity removePermission(
            @RequestHeader(name = "Application-Id") Integer applicationId,
            @PathVariable Integer id,
            @PathVariable Integer permissionId) {
        service.removePermission(applicationId, id, permissionId);
        return ResponseEntity.noContent().build();
    }
}

/*List<AdjacentItem> lista = new LinkedList<>();
lista.add(new AdjacentItem(2, 1, "Money", "Money"));
lista.add(new AdjacentItem(5, 2, "Order", "Order"));
lista.add(new AdjacentItem(6, 2, "Transfer", "Transfer"));
lista.add(new AdjacentItem(10, 4, "Financial", "Financial"));*/