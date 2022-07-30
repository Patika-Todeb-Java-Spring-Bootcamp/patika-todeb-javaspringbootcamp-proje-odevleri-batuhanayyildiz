package com.todeb.batuhanayyildiz.libraryautomationapplication;

import com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto.UserDataDTO;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.User;
import com.todeb.batuhanayyildiz.libraryautomationapplication.repository.UserRepository;
import com.todeb.batuhanayyildiz.libraryautomationapplication.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SampleDataInitiliazer implements ApplicationRunner {
    private final UserRepository userRepository;

    private final UserServiceImpl userService;


    @Override
    public void run(ApplicationArguments args) throws Exception{
        // Creating a sample Admin USER
        UserDataDTO adminUser = new UserDataDTO("admin-user", "adminuser@mail.com", "pass1234");
        if (!userRepository.existsByUsername(adminUser.getUsername())) {
            userService.signup(adminUser, true);
        }

        // Creating a sample USER
        UserDataDTO sampleUser = new UserDataDTO("sample-user", "sampleuser@mail.com", "pass1234");
        if (!userRepository.existsByUsername(sampleUser.getUsername())) {
            userService.signup(sampleUser, false);
        }

    }

}
