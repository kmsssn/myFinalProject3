package kz.myfinalproject.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ModeratorController {

    @PreAuthorize("hasAnyRole('ROLE_MODER', 'ROLE_MAIN_ADMIN')")
    @GetMapping(value="/moderator-panel")
    public String moderPanel(Model model){
        return "moderator";
    }

}
