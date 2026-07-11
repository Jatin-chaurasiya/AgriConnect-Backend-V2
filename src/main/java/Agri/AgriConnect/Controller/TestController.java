package Agri.AgriConnect.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/farmer")
    public String farmer() {
        return "Welcome Farmer";
    }

    @GetMapping("/provider")
    public String provider() {
        return "Welcome Provider";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Welcome Admin";
    }
}