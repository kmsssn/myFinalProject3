package kz.bitlab.myfinalproject.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @PreAuthorize("hasAnyRole('ROLE_MAIN_ADMIN')")
    @GetMapping(value="/admin-panel")
    public String adminPanel(Model model){
        return "admin";
    }

}
