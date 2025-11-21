package com.skillstorm.inventory_management_system.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.inventory_management_system.Models.Warehouse;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long>{
    
    //QUERIES Database for a list of warehouses containing a particular name, case insensitive
    public List<Warehouse> findByNameContainingIgnoreCase(String name);



        //QUERIES Database to update the warehouse name
        @Query("update Warehouse w set w.name=:name where w.warehouseId= :warehouseId")
        @Modifying
        @Transactional
        public Warehouse updateName(@Param("warehouseId") long id, @Param("name") String name);

}

    
