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


    @GetMapping("/{braces}")
    public boolean shift(@PathVariable() String braces) {

//        braces.substring()

        return isComplete(braces);
    }

    private boolean isComplete(String braces) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < braces.length(); i++) {

            if (braces.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) return false;
                else stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
