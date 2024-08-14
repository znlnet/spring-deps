package net.znl.demo.plugin.kr.web.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Profile("kr")//代表在只要启用韩国的时候才托管
@RestController("userPluginController")//如果有名字命名冲突，则需要重命名bean的名称
@RequestMapping("user")
public class UserController {
    @GetMapping("list")
    public String hello(String name) {
        return "=====> 这个是韩国的" + Optional.ofNullable(name).orElse("");
    }
}
