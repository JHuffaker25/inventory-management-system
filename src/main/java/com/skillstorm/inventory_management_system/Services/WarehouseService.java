package com.skillstorm.inventory_management_system.Services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.skillstorm.inventory_management_system.Models.Warehouse;
import com.skillstorm.inventory_management_system.Repositories.WarehouseRepository;

@Service
public class WarehouseService {
    
    private final WarehouseRepository warehouseRepository;
    public WarehouseService (WarehouseRepository warehouseRepository){
            this.warehouseRepository = warehouseRepository;
        
    }



    //RETURNS all a user's warehouses
    public List<Warehouse> findAllWarehouses(){
        
       return warehouseRepository.findAll();

   }



   //RETURNS list of warehouses of a particular name
    public List<Warehouse> findWarehousesByName(String name){
        
       return warehouseRepository.findByNameContainingIgnoreCase(name);

   }



   //ADDS a new Warehouse to the database
   public Warehouse createNewWarehouse(Warehouse warehouse){

       return warehouseRepository.save(warehouse);

   }



   //UPDATES an existing Warehouse name
   public String updateWarehouseName (String oldName, String newName){

        return warehouseRepository.updateWarehouseName(oldName, newName); 

   }

}
