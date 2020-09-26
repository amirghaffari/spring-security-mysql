package com.amirghaffari.SpringSecurity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping
    public String getHomePage(){
        return "home";
    }

    @GetMapping("/secured")
    public String getSecuredPage(){
        return "secured";
    }

    @GetMapping("/admin")
    public String getAdminPage(){
        return "admin";
    }

    @GetMapping("/logoutSuccess")
    public String getLogoutPage(){
        return "logoutSuccess";
    }

    @GetMapping("/accessDenied")
    public String getAccessDenied(){
        return "accessDenied";
    }

}
