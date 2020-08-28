package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.Stack;

@RestController
@RequestMapping("")
public class MyController {


    @GetMapping("token/{token}")
    public ResponseEntity tokenParser(@PathVariable() String token) {

        System.out.println("token : " + token);

        String[] tokenPayloads = token.split("\\.");
        System.out.println(tokenPayloads.length);
        java.util.Base64.Decoder decoder = java.util.Base64.getUrlDecoder();
//        decoder.decode(tokenPayloads[1]);
        return new ResponseEntity(decoder.decode(tokenPayloads[1]), HttpStatus.OK);
    }

}
