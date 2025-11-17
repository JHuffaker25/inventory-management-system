package com.skillstorm.inventory_management_system.Controllers;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.inventory_management_system.InventoryManagementSystemApplication;
import com.skillstorm.inventory_management_system.Models.Warehouse;
import com.skillstorm.inventory_management_system.Services.WarehouseService;

@RestController
@RequestMapping ("/index")
public class WarehouseController {

    private final WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService){
        this.warehouseService = warehouseService;
    }



    //Shows all user's current warehouses on the dashboard landing page
    @GetMapping
    public ResponseEntity<List<Warehouse>> findAllWarehouses(){

      try {

        List<Warehouse> warehouses = warehouseService.findAllWarehouses();
        return new ResponseEntity<>(warehouses, HttpStatus.OK);

      } catch (Exception e) {

        return ResponseEntity.internalServerError().header("Error", "There was an internal server error").body(null);

      }
    }

}
