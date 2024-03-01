package com.davidticona.ent.controller;

import com.davidticona.ent.domain.dto.AppRequestDto;
import com.davidticona.ent.domain.dto.AppResponseDto;
import com.davidticona.ent.service.AppService;
import com.davidticona.ent.validator.ObjectValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author David Tomas Ticona Saravia
 */
@RestController
@RequestMapping("/applications")
public class AppController {
    @Autowired
    private AppService service;
    
    private final ObjectValidator<AppRequestDto> validator;
    
    public AppController(ObjectValidator<AppRequestDto> validator) {
        this.validator = validator;
    }
    
    @PostMapping
    public ResponseEntity<?> add(
            @RequestBody AppRequestDto app) {
        
        var errors = validator.validate(app);
        if (!errors.isEmpty()) {
            return ResponseEntity.badRequest().body(errors);
        }
        
        return ResponseEntity.ok( service.create(app));
    }
}
