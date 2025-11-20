package com.skillstorm.inventory_management_system.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.inventory_management_system.Services.SectionService;
import com.skillstorm.inventory_management_system.Services.UsersService;

@RestController
@CrossOrigin
public class SectionController {
    
     private final SectionService sectionService;

     public SectionController(SectionService sectionService){
        this.sectionService = sectionService;
    }

}
