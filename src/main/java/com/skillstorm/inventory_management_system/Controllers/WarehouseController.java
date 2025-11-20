package com.skillstorm.inventory_management_system.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.inventory_management_system.InventoryManagementSystemApplication;
import com.skillstorm.inventory_management_system.Models.Product;
import com.skillstorm.inventory_management_system.Models.Warehouse;
import com.skillstorm.inventory_management_system.Services.WarehouseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping ("/warehouses")
@CrossOrigin
public class WarehouseController {

    private final WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService){
        this.warehouseService = warehouseService;
    }



    //REQUESTS all user's current warehouses on the dashboard landing page
    @GetMapping
    public ResponseEntity<List<Warehouse>> findAllWarehouses(){

      try {

          List<Warehouse> warehouses = warehouseService.findAllWarehouses();
          return new ResponseEntity<>(warehouses, HttpStatus.OK);

      } catch (Exception e) {

          return ResponseEntity.internalServerError().header("Error", "There was an internal server error").body(null);

      }
    }



    //REQUESTS current user's warehouses by name
    @GetMapping ("/name/{name}")
    public ResponseEntity<List<Warehouse>> findWarehousesByName(@PathVariable String name){

      try {

          List <Warehouse> warehouses = warehouseService.findWarehousesByName(name);
          return new ResponseEntity<>(warehouses, HttpStatus.OK);

      } catch (IllegalArgumentException e) {

         return ResponseEntity.badRequest().header("Error", "There were no warehouse matches found").body(null);

      }catch (Exception e) {

         return ResponseEntity.internalServerError().header("Error", "There was an internal server error").body(null);

      }
    }
    
    

    //REQUEST to ADD a new Warehouse
    @PostMapping
    public ResponseEntity<Warehouse> createNewWarehouse(@RequestBody Warehouse warehouse) {
        
        try {

          return new ResponseEntity<>(warehouseService.createNewWarehouse(warehouse), HttpStatus.CREATED);

      } catch (IllegalArgumentException e) {

         return ResponseEntity.badRequest().header("Error", "An incorrect value was entered").body(null);

      }catch (Exception e) {

         return ResponseEntity.internalServerError().header("Error", "There was an internal server error").body(null);

      }

    }
    

      //REQUEST to update a warehouse name
      @PutMapping("/warehouse/rename/{oldName}")
      public ResponseEntity<String> updateWarehouseName (@PathVariable String oldName, @RequestParam String newName){
        
          try {

          return new ResponseEntity<>(warehouseService.updateWarehouseName(oldName, newName), HttpStatus.NO_CONTENT);

      } catch (IllegalArgumentException e) {

         return ResponseEntity.badRequest().header("Error", "An incorrect value was entered").body(null);

      }catch (Exception e) {

         return ResponseEntity.internalServerError().header("Error", "There was an internal server error").body(null);

      }

      }
          

      
      
  }