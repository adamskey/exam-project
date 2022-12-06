package se.exam.project.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import se.exam.project.roles.ERole;
import se.exam.project.roles.Roles;
import se.exam.project.user.User;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/all")
    public String allAccess() {
        return "Public content";
    }

    @PostMapping("/user")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
    public String userAccess(@RequestBody User user) {
        for (Roles role : user.getRole()) {
            if (role.getName().equals(ERole.ROLE_USER)) {
                return "User Content.";
            }
        }
        return null;
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    public String moderatorAccess() {
        return "Moderator Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }
}
