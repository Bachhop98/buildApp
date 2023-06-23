package com.tuanhop.buildAppSpringboot.controller;

import com.tuanhop.buildAppSpringboot.dto.UserDTO;
import com.tuanhop.buildAppSpringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(ModelMap modelMap) {
        return "Hello World. How are you ?";
    }
    @RequestMapping(value = "/insert-users", method = RequestMethod.POST)
    public String insertStudent(@RequestParam String userName,
                                @RequestParam String fullName,
                                @RequestParam String email,
                                @RequestParam String status,
                                @RequestParam String createdBy,
                                @RequestParam Date createdDate,
                                @RequestParam String modifyBy,
                                @RequestParam Date modifyDate) {
        try {
            UserDTO userDTO = new UserDTO(userName,fullName, email, status, createdBy, createdDate, modifyBy, modifyDate);
            userService.saveUser(userDTO);
            return "Insert user successfully";
        }catch (Exception e) {
            return "Insert user failed.Error: "+e.toString();
        }
    }
    @RequestMapping(value = "/show-users", method = RequestMethod.GET)
    //http://localhost:8085/students/showAllStudents
    public List<UserDTO> showAllStudents() {
        return userService.findUsers();
    }
}

