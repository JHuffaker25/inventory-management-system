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

    //!!!!!!!!!!!!!!!DELETE THIS!!!!!!!!!!!!!!!!!
    @GetMapping("/gettest")
    public String message(){

        return "THIS IS A GET TEST URL, IT WORKED!!!";

    }

    //
    @GetMapping
    public List <String> findAllWarehouses(){

       return warehouseService.findAllWarehouses();

    }

}
