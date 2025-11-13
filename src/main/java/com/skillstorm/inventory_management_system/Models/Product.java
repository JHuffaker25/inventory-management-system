package com.skillstorm.inventory_management_system.Models;

public class Product {
    
    //Fields///////////////////
    private long productId;
    private long sectionId;
    private String name;
    private String sku;
    private long quantity;
    private String description;

    //Boilerplate//////////////////////////////////////////////////////////////////////////////////////////////////
    public Product() {
    }

    public Product(long productId, long sectionId, String name, String sku, long quantity, String description) {
        this.productId = productId;
        this.sectionId = sectionId;
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

    public long getSectionId() {
        return sectionId;
    }

    public void setSectionId(long sectionId) {
        this.sectionId = sectionId;
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (productId ^ (productId >>> 32));
        result = prime * result + (int) (sectionId ^ (sectionId >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((sku == null) ? 0 : sku.hashCode());
        result = prime * result + (int) (quantity ^ (quantity >>> 32));
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (productId != other.productId)
            return false;
        if (sectionId != other.sectionId)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (sku == null) {
            if (other.sku != null)
                return false;
        } else if (!sku.equals(other.sku))
            return false;
        if (quantity != other.quantity)
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", sectionId=" + sectionId + ", name=" + name + ", sku=" + sku
                + ", quantity=" + quantity + ", description=" + description + "]";
    }

    

}
