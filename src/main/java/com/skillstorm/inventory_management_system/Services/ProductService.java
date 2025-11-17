package com.skillstorm.inventory_management_system.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skillstorm.inventory_management_system.Models.Product;
import com.skillstorm.inventory_management_system.Models.Warehouse;
import com.skillstorm.inventory_management_system.Repositories.ProductRepository;
import com.skillstorm.inventory_management_system.Repositories.WarehouseRepository;

@Service
public class ProductService {
        
    private final ProductRepository productRepository;

    public ProductService (ProductRepository productRepository){
            this.productRepository = productRepository;
    }


    
    //Returns all a user's warehouses
    public List<Product> findAllProducts(){

       return productRepository.findAll();
   }

   
}
