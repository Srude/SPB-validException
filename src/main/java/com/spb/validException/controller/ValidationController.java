package com.spb.validException.controller;

import com.spb.validException.data.dto.ValidRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/validation")
public class ValidationController {
    private final Logger LOGGER = LoggerFactory.getLogger(ValidationController.class);

    @PostMapping("/valid")
    public ResponseEntity<String> checkValidationByValid(
        @Valid @RequestBody ValidRequestDTO validRequestDTO){
        LOGGER.info(validRequestDTO.toString());
        return ResponseEntity.status(HttpStatus.OK).body(validRequestDTO.toString());
    }
}
