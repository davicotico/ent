package com.davidticona.ent.controller;

import com.davidticona.ent.domain.dto.AppRequestDto;
import com.davidticona.ent.domain.dto.AppResponseDto;
import com.davidticona.ent.service.AppService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping
    public ResponseEntity<List<AppResponseDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
    
    @PostMapping
    public ResponseEntity<AppResponseDto> create(
            @RequestBody AppRequestDto app) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.create(app));
    }
}
