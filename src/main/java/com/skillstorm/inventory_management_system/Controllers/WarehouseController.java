package com.skillstorm.inventory_management_system.Controllers;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.inventory_management_system.InventoryManagementSystemApplication;
import com.skillstorm.inventory_management_system.Services.WarehouseService;

@RestController
@RequestMapping("/index")
public class WarehouseController {

    private final WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService){
        this.warehouseService = warehouseService;
    }

    

//Returns all the user's current warehouses on the dashboard landing page
    @GetMapping("/index")
    public List <String> findAllWarehouses(){

       return warehouseService.findAllWarehouses();

    }

}
