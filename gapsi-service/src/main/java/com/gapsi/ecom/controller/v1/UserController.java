package com.gapsi.ecom.controller.v1;


import com.gapsi.ecom.dto.User;
import com.gapsi.ecom.exception.ApplicationException;
import com.gapsi.ecom.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public User fetchUser(@PathVariable Long userId) throws ApplicationException {
        return userService.getUserById(userId);
    }
}
