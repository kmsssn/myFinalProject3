package kz.bitlab.myfinalproject.api;

import kz.bitlab.myfinalproject.dto.UserDTO;
import kz.bitlab.myfinalproject.models.User;
import kz.bitlab.myfinalproject.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/users")
@AllArgsConstructor
//@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminRestController {
        private final UserService userService;

        @GetMapping
        public List<UserDTO> getAllUsers() {
            return userService.getAllUsers();
        }

        @GetMapping("/{id}")
        public UserDTO getUserById(@PathVariable Long id) {
            return userService.getUserById(id);
        }

        @PostMapping
        public User addUser(@RequestBody User user) {
            return userService.addUser(user);
        }

        @DeleteMapping("/{id}")
        public void deleteUser(@PathVariable Long id) {
            userService.deleteUser(id);
        }

}

