package com.davidticona.ent.controller;

import com.davidticona.ent.domain.dto.user.UserRequestDto;
import com.davidticona.ent.domain.dto.user.UserResponseDto;
import com.davidticona.ent.domain.dto.user.UserUpdateRequestDto;
import com.davidticona.ent.domain.projection.UserProjection;
import com.davidticona.ent.service.UserService;
import java.util.List;
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
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserProjection>> read(
            @RequestHeader(name = "Application-Id") Integer applicationId) {
        return ResponseEntity.ok(this.userService.read(applicationId));
    }
    
    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDto user) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.userService.create(user));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity update(
            @PathVariable Integer id, 
            @RequestBody UserUpdateRequestDto user) {
        userService.update(id, user);
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    
    @GetMapping("/{id}/roles")
    public ResponseEntity<?> getRoles(
            @RequestHeader(name = "Application-Id") Integer applicationId,
            @PathVariable("id") Integer userId,
            @RequestParam(name = "showTree") Optional<Boolean> showTree) {
        if (showTree.isPresent() && Objects.equals(showTree.get(), Boolean.TRUE)) {
            return ResponseEntity.ok(this.userService.getRolesTrees(applicationId, userId));
        }
        return ResponseEntity.ok(this.userService.getRoles(applicationId, userId));
    }
}
