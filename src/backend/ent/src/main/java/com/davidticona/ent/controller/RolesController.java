package com.davidticona.ent.controller;

import com.davidticona.ent.domain.dto.RoleRequestDto;
import com.davidticona.ent.domain.dto.RoleResponseDto;
import com.davidticona.ent.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Objects;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<?> getAll(
            @RequestHeader(name = "Application-Id") Integer applicationId,
            @RequestParam(name = "showTree") Optional<Boolean> showTree) {
        if (showTree.isPresent() && Objects.equals(showTree.get(), Boolean.TRUE)) {
            return ResponseEntity.ok(roleService.getAllTreeView(applicationId));
        }
        return ResponseEntity.ok(roleService.getAll(applicationId));
    }

    @GetMapping("/{id}/permissions")
    public ResponseEntity<?> getPermissionsByRoleId(
            @RequestHeader(name = "Application-Id") Integer applicationId,
            @PathVariable("id") Integer roleId,
            @RequestParam(name = "showTree") Optional<Boolean> showTree) {
        if (showTree.isPresent() && Objects.equals(showTree.get(), Boolean.TRUE)) {
            return ResponseEntity.ok(roleService.getPermissionsTrees(applicationId, roleId));
        }
        return ResponseEntity.ok(roleService.getPermissions(applicationId, roleId));
    }
    
    @PostMapping
    public ResponseEntity<RoleResponseDto> add(@RequestBody RoleRequestDto role) {
        return ResponseEntity.ok(roleService.create(role));
    }
}

/*List<AdjacentItem> lista = new LinkedList<>();
lista.add(new AdjacentItem(2, 1, "Money", "Money"));
lista.add(new AdjacentItem(5, 2, "Order", "Order"));
lista.add(new AdjacentItem(6, 2, "Transfer", "Transfer"));
lista.add(new AdjacentItem(10, 4, "Financial", "Financial"));*/