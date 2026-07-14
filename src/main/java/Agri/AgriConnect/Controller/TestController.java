package Agri.AgriConnect.Controller;

import Agri.AgriConnect.Service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final EmailService emailService;

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

    @PostMapping("/send-email")
    public String sendEmail() {

        emailService.sendTestEmail(
                "jatinchaurasiya301@gmail.com"   // ya apni email
        );

        return "Email Sent Successfully";
    }
}