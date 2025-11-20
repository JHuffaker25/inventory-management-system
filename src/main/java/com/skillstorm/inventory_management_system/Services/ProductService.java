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


    
    //Returns all a user's products
    public List<Product> findAllProducts(){

       return productRepository.findAll();
   }

   

   //Returns list of products of a particular name
    public List<Product> findProductByName(String name){
        
       return productRepository.findByNameContainingIgnoreCase(name);

   }

   

   //Creates new product
   public Product createNewProduct(Product product){

       return productRepository.save(product);

   }


   //Deletes a product
   public void deleteProductById(long id){

       productRepository.deleteById(id);

   }
   
}
