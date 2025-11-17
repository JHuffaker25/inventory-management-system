package com.skillstorm.inventory_management_system.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.inventory_management_system.Models.Warehouse;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long>{
    
    //QUERIES Database for a list of warehouses containing a particular name, case insensitive
    public List<Warehouse> findByNameContainingIgnoreCase(String name);



    


}
