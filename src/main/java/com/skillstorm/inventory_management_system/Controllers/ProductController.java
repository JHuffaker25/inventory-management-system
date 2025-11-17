package com.skillstorm.inventory_management_system.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.inventory_management_system.Models.Product;
import com.skillstorm.inventory_management_system.Models.Warehouse;
import com.skillstorm.inventory_management_system.Services.ProductService;
import com.skillstorm.inventory_management_system.Services.SectionService;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    private final ProductService productService;

     public ProductController(ProductService productService){
        this.productService = productService;
    }


    //Shows all user's current products
    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts(){

      try {

            List<Product> product = productService.findAllProducts();
            return new ResponseEntity<>(product, HttpStatus.OK);

      } catch (Exception e) {

             return ResponseEntity.internalServerError().header("Error", "There was an internal server error").body(null);

      }
    }

}
