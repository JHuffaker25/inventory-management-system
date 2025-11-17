package com.skillstorm.inventory_management_system.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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


    //REQUESTS all user's current products
    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts(){

      try {

            List<Product> product = productService.findAllProducts();
            return new ResponseEntity<>(product, HttpStatus.OK);

      } catch (Exception e) {

            return ResponseEntity.internalServerError().header("Error", "There was an internal server error").body(null);

      }
    }



    //REQUESTS current user's products by name
    @GetMapping ("/name/{name}")
    public ResponseEntity<List<Product>> findWarehousesByName(@PathVariable String name){

      try {

          List <Product> products = productService.findProductByName(name);
          return new ResponseEntity<>(products, HttpStatus.OK);

      } catch (IllegalArgumentException e) {

         return ResponseEntity.badRequest().header("Error", "There were no product matches found").body(null);

      }catch (Exception e) {

         return ResponseEntity.internalServerError().header("Error", "There was an internal server error").body(null);

      }
    }



      //REQUEST to ADD a new Warehouse
    @PostMapping
    public ResponseEntity<Product> createNewProduct(@RequestBody Product product) {
        
        try {

          return new ResponseEntity<>(productService.createNewProduct(product), HttpStatus.OK);

      } catch (IllegalArgumentException e) {

         return ResponseEntity.badRequest().header("Error", "An incorrect value was entered").body(null);

      }catch (Exception e) {

         return ResponseEntity.internalServerError().header("Error", "There was an internal server error").body(null);

      }

  }

}
    
    

