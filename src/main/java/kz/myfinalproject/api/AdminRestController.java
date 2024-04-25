package kz.myfinalproject.api;

import kz.myfinalproject.dto.UserDTO;
import kz.myfinalproject.models.User;
import kz.myfinalproject.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/users")
@AllArgsConstructor
public class AdminRestController {
        private final UserService userService;

    @PreAuthorize("hasRole('ROLE_MAIN_ADMIN')")
        @GetMapping
        public List<UserDTO> getAllUsers() {
            return userService.getAllUsers();
        }

        @GetMapping("/{id}")
        public UserDTO getUserById(@PathVariable Long id) {
            return userService.getUserById(id);
        }

    @PreAuthorize("hasRole('ROLE_MAIN_ADMIN')")
        @PostMapping
        public User addUser(@RequestBody User user) {
            return userService.addUser(user);
        }

    @PreAuthorize("hasRole('ROLE_MAIN_ADMIN')")
        @DeleteMapping("/{id}")
        public void deleteUser(@PathVariable Long id) {
            userService.deleteUser(id);
        }

}

