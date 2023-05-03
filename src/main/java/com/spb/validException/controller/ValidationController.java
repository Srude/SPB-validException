package com.spb.validException.controller;

import com.spb.group.ValidationGroup1;
import com.spb.group.ValidationGroup2;
import com.spb.validException.data.dto.ValidRequestDTO;
import com.spb.validException.data.dto.ValidatedRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

//    {
//        "age": 30,
//        "booleanCheck": true,
//        "count": 1,
//        "description": "데이터1111",
//        "email": "dja@dja.com",
//        "name": "dja",
//        "phoneNumber": "010-1212-1231"
//    }

    @PostMapping("/validated")
    public ResponseEntity<String> checkValidation(@Validated @RequestBody ValidatedRequestDTO validatedRequestDTO){
        LOGGER.info(validatedRequestDTO.toString());
        return ResponseEntity.status(HttpStatus.OK).body(validatedRequestDTO.toString());
    }

    @PostMapping("/validated/group1")
    public ResponseEntity<String> checkValidation1(@Validated(ValidationGroup1.class)
                                                       @RequestBody ValidatedRequestDTO validatedRequestDTO){
        LOGGER.info(validatedRequestDTO.toString());
        return ResponseEntity.status(HttpStatus.OK).body(validatedRequestDTO.toString());
    }

    @PostMapping("/validated/group2")
    public ResponseEntity<String> checkValidation2(@Validated(ValidationGroup2.class)
                                                       @RequestBody ValidatedRequestDTO validatedRequestDTO){
        LOGGER.info(validatedRequestDTO.toString());
        return ResponseEntity.status(HttpStatus.OK).body(validatedRequestDTO.toString());
    }

    @PostMapping("/validated/all-group")
    public ResponseEntity<String> checkValidation3(@Validated({ValidationGroup1.class, ValidationGroup2.class})
                                                       @RequestBody ValidatedRequestDTO validatedRequestDTO){
        LOGGER.info(validatedRequestDTO.toString());
        return ResponseEntity.status(HttpStatus.OK).body(validatedRequestDTO.toString());
    }
}
