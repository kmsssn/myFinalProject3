package kz.bitlab.myfinalproject.api;

import kz.bitlab.myfinalproject.dto.UserDTO;
import kz.bitlab.myfinalproject.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-profile")
@AllArgsConstructor
public class UserRestController {

    private final UserService userService;

    //@PreAuthorize("isAuthenticated()")
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }


}
