package com.skillstorm.inventory_management_system.Models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="section")
public class Section {
    
//Fields/////////////////////////////////////////////////
@Id
@Column (name = "section_id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long sectionId;

@ManyToOne
@JoinColumn (name = "warehouse_id")
private Warehouse warehouse;

@Column (name = "name")
private String name;

@Column (name = "description")
private String description;

@OneToMany (targetEntity = Product.class, mappedBy = "section")
@JsonIgnore
private Set<Product> products;



//Boilerplate//////////////////////////////////////////////////////////////////////////
public Section() {
}

public Section(long sectionId, Warehouse warehouse, String name, String description, Set<Product> products) {
    this.sectionId = sectionId;
    this.warehouse = warehouse;
    this.name = name;
    this.description = description;
    this.products = products;
}

public Section(String name, String description, Set<Product> products) {
    this.name = name;
    this.description = description;
    this.products = products;
}

public long getSectionId() {
    return sectionId;
}

public void setSectionId(long sectionId) {
    this.sectionId = sectionId;
}

public Warehouse getWarehouse() {
    return warehouse;
}

public void setWarehouse(Warehouse warehouse) {
    this.warehouse = warehouse;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}

public Set<Product> getProducts() {
    return products;
}

public void setProducts(Set<Product> products) {
    this.products = products;
}

@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (sectionId ^ (sectionId >>> 32));
    result = prime * result + ((warehouse == null) ? 0 : warehouse.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((description == null) ? 0 : description.hashCode());
    result = prime * result + ((products == null) ? 0 : products.hashCode());
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
    Section other = (Section) obj;
    if (sectionId != other.sectionId)
        return false;
    if (warehouse == null) {
        if (other.warehouse != null)
            return false;
    } else if (!warehouse.equals(other.warehouse))
        return false;
    if (name == null) {
        if (other.name != null)
            return false;
    } else if (!name.equals(other.name))
        return false;
    if (description == null) {
        if (other.description != null)
            return false;
    } else if (!description.equals(other.description))
        return false;
    if (products == null) {
        if (other.products != null)
            return false;
    } else if (!products.equals(other.products))
        return false;
    return true;
}

@Override
public String toString() {
    return "Section [sectionId=" + sectionId + ", warehouse=" + warehouse + ", name=" + name + ", description="
            + description + "]";
}


}
