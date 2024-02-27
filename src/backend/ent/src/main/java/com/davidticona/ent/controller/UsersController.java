package com.davidticona.ent.controller;

import com.davidticona.ent.domain.projection.UserProjection;
import com.davidticona.ent.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
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
    
    @GetMapping("/{id}/roles")
    public ResponseEntity<?> getRoles(
            @RequestHeader(name = "Application-Id") Integer applicationId,
            @PathVariable("id") Integer userId) {
        return ResponseEntity.ok(this.userService.getRoles(applicationId, userId));
    }
}
