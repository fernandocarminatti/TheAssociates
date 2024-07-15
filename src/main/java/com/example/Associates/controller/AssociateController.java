package com.example.Associates.controller;

import com.example.Associates.dtos.AssociateDto;
import com.example.Associates.service.AssociateService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/associates")
public class AssociateController {
    AssociateService associateService;

    public AssociateController(AssociateService associateService) {
        this.associateService = associateService;
    }

    @PostMapping
    public ResponseEntity<?> createAssociate(@RequestBody @Valid AssociateDto associateDto) {
        boolean created = associateService.createAssociate(associateDto);
        if(created) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
