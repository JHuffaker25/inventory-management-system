package com.skillstorm.inventory_management_system.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.inventory_management_system.Models.Product;
import com.skillstorm.inventory_management_system.Models.Warehouse;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    
    //QUERIES Database for a list of products containing a particular name, case insensitive
    public List<Product> findByNameContainingIgnoreCase(String name);


    //QUERIES Database to update the product name
        @Query("update Product p set p.name=:name where p.productId= :productId")
        @Modifying
        @Transactional
        public Void updateName(@Param("productId") long id, @Param("name") String name);

}
