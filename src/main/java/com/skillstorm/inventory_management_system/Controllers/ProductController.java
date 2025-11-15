package com.skillstorm.inventory_management_system.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.inventory_management_system.Services.ProductService;
import com.skillstorm.inventory_management_system.Services.SectionService;

@RestController
public class ProductController {
    
    private final ProductService productService;

     public ProductController(ProductService productService){
        this.productService = productService;
    }

}
