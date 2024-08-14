package net.znl.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {
    @GetMapping("list")
    public String hello(String name) {
        return "这是国内的 " + Optional.ofNullable(name).orElse("");
    }
}
