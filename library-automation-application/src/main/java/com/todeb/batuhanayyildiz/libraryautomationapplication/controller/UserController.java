package com.todeb.batuhanayyildiz.libraryautomationapplication.controller;



import com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto.UserDataDTO;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto.UserLoginDTO;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.User;
import com.todeb.batuhanayyildiz.libraryautomationapplication.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_USER')")
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @PostMapping("/signin")
    public String login(@Valid @RequestBody UserLoginDTO userLoginDTO) {
        return userService.signin(userLoginDTO.getUsername(), userLoginDTO.getPassword());
    }

    @PostMapping("/signup")
    public String signup(@RequestBody @Valid UserDataDTO userDataDTO) {
        return userService.signup(userDataDTO,false);

    }

    //    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RolesAllowed("ROLE_ADMIN")
    @DeleteMapping(value = "/delete/{username}")
    public String delete(@PathVariable String username) {
        userService.delete(username);
        return username;
    }

//    @GetMapping(value = "/me")
//    public UserResponseDTO whoami(HttpServletRequest req) {
//
//        return modelMapper.map(userService.whoami(req), UserResponseDTO.class);
//    }

}
