package org.alalgo.gateway.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @RequestMapping("/test")
    public String test() {
        return "test";
    }  
}
