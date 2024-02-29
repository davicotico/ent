package com.davidticona.ent.controller;

import com.davidticona.ent.domain.dto.AppRequestDto;
import com.davidticona.ent.domain.dto.AppResponseDto;
import com.davidticona.ent.service.AppService;
import com.davidticona.ent.util.mapper.AppMapper;
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
    
    @PostMapping
    public ResponseEntity<AppResponseDto> add(@RequestBody AppRequestDto app) {
        return ResponseEntity.ok( service.create(app));
    }
}
