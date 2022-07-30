package com.todeb.batuhanayyildiz.libraryautomationapplication.service;

import com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto.UserDataDTO;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {

    List<User> getAll();
    String signin(String username, String password);
    String signup(UserDataDTO userDataDTO, boolean isAdmin);
    void delete(String username);
    User search(String username);
    User whoami(HttpServletRequest req);
    String refresh(String username);
}
