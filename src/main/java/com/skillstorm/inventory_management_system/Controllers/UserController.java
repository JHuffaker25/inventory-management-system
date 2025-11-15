package com.skillstorm.inventory_management_system.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.inventory_management_system.Services.UserService;
import com.skillstorm.inventory_management_system.Services.WarehouseService;

@RestController
public class UserController {
    
    private final UserService userService;

     public UserController(UserService userService){
        this.userService = userService;
    }

}
