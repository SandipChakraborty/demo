package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.Stack;

@RestController
@RequestMapping("/another")
public class AnotherController {

    @GetMapping("/{braces}")
    public boolean shift(@PathVariable() String braces) {
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
