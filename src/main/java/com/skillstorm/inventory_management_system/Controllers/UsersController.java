package com.skillstorm.inventory_management_system.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.inventory_management_system.Services.UsersService;
import com.skillstorm.inventory_management_system.Services.WarehouseService;

@RestController
@CrossOrigin
public class UsersController {
    
    private final UsersService usersService;

     public UsersController(UsersService usersService){
        this.usersService = usersService;
    }



}
