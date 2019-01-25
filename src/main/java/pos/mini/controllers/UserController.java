package pos.mini.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

    @RequestMapping("/login")
    public String loginUser(@RequestBody Map<String, String> object) {
        return "Greetings from Spring Boot!";
    }
}
