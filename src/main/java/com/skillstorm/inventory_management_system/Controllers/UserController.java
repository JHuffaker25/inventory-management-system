package com.skillstorm.inventory_management_system.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.inventory_management_system.Services.UserService;
import com.skillstorm.inventory_management_system.Services.WarehouseService;

@RestController
@RequestMapping ("/index")
public class UserController {
    
    private final UserService userService;

     public UserController(UserService userService){
        this.userService = userService;
    }



    //Shows all user's current warehouses on the dashboard landing page
    @GetMapping
    public List <String> findAllWarehouses(){

       return userService.findAllWarehouses();

    }

}
