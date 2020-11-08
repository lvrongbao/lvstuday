package com.imooc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
@GetMapping("/hello")
    public Object hello() {
        return "hellow";
    }
}
