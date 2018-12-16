package com.usman.service.codeverifyservice.controller;

import com.usman.service.codeverifyservice.repository.CodeVerify;
import com.usman.service.codeverifyservice.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/verification-code")
public class CodeVerifyController {

    private final CodeVerify codeVerify;

    @Autowired
    public CodeVerifyController(CodeVerify codeVerify) {
        this.codeVerify = codeVerify;
    }

    @PostMapping(path = "/{userId}")
    public ResponseEntity<Object> add(@PathVariable("userId") String userId) {
        codeVerify.add(userId);
        return new ResponseEntity<>(new ApiResponse("1", "successful", null), HttpStatus.OK);
    }

    @RequestMapping(path = "/{userId}/{code}", method = RequestMethod.GET)
    public ResponseEntity<Object> verify(@PathVariable("userId") String userId, @PathVariable("code") String code) {
        codeVerify.verify(userId, code);
        return new ResponseEntity<>(new ApiResponse("1", null, "true"), HttpStatus.OK);
    }
}
