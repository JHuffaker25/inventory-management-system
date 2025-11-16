package com.skillstorm.inventory_management_system.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
    
    //Fields///////////////////////////////////////////////

    @Id
    @Column (name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    @ManyToOne
    @JoinColumn (name = "section_id")
    private Section section;

    @Column (name = "name")
    private String name;

    @Column (name = "sku")
    private String sku;

    @Column (name = "quantity")
    private long quantity;

    @Column (name = "description")
    private String description;

    

    //Boilerplate//////////////////////////////////////////////////////////////////////////////////////////////////
    public Product() {
    }

    public Product(long productId, Section section, String name, String sku, long quantity, String description) {
        this.productId = productId;
        this.section = section;
        this.name = name;
        this.sku = sku;
        this.quantity = quantity;
        this.description = description;
    }

    public Product(String name, String sku, long quantity, String description) {
        this.name = name;
        this.sku = sku;
        this.quantity = quantity;
        this.description = description;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", section=" + section + ", name=" + name + ", sku=" + sku
                + ", quantity=" + quantity + ", description=" + description + "]";
    }

    
}
