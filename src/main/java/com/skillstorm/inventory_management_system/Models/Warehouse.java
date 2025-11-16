package com.skillstorm.inventory_management_system.Models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Warehouse {
    
    //Fields//////////////////////////////////////////////
    @Id
    @Column (name = "warehouse_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long warehouseId;

    @ManyToOne 
    @JoinColumn (name = "user_id")
    private User user;

    @Column (name = "name")
    private String name;

    @Column (name = "location")
    private String location;

    @Column (name = "max_capacity")
    private long maxCapacity;

    @OneToMany (targetEntity = Section.class, mappedBy = "warehouse")
    private Set<Section> sections;



    //Boilerplate///////////////////////////////////////////////////////////////////////////////////////
     public Warehouse() {
    }



     public Warehouse(long warehouseId, User user, String name, String location, long maxCapacity,
            Set<Section> sections) {
        this.warehouseId = warehouseId;
        this.user = user;
        this.name = name;
        this.location = location;
        this.maxCapacity = maxCapacity;
        this.sections = sections;
     }



     public Warehouse(String name, String location, long maxCapacity, Set<Section> sections) {
        this.name = name;
        this.location = location;
        this.maxCapacity = maxCapacity;
        this.sections = sections;
     }



     public long getWarehouseId() {
         return warehouseId;
     }



     public void setWarehouseId(long warehouseId) {
         this.warehouseId = warehouseId;
     }



     public User getUser() {
         return user;
     }



     public void setUser(User user) {
         this.user = user;
     }



     public String getName() {
         return name;
     }



     public void setName(String name) {
         this.name = name;
     }



     public String getLocation() {
         return location;
     }



     public void setLocation(String location) {
         this.location = location;
     }



     public long getMaxCapacity() {
         return maxCapacity;
     }



     public void setMaxCapacity(long maxCapacity) {
         this.maxCapacity = maxCapacity;
     }



     public Set<Section> getSections() {
         return sections;
     }



     public void setSections(Set<Section> sections) {
         this.sections = sections;
     }



     @Override
     public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (warehouseId ^ (warehouseId >>> 32));
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((location == null) ? 0 : location.hashCode());
        result = prime * result + (int) (maxCapacity ^ (maxCapacity >>> 32));
        result = prime * result + ((sections == null) ? 0 : sections.hashCode());
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
        Warehouse other = (Warehouse) obj;
        if (warehouseId != other.warehouseId)
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (location == null) {
            if (other.location != null)
                return false;
        } else if (!location.equals(other.location))
            return false;
        if (maxCapacity != other.maxCapacity)
            return false;
        if (sections == null) {
            if (other.sections != null)
                return false;
        } else if (!sections.equals(other.sections))
            return false;
        return true;
     }



     @Override
     public String toString() {
        return "Warehouse [warehouseId=" + warehouseId + ", user=" + user + ", name=" + name + ", location=" + location
                + ", maxCapacity=" + maxCapacity + "]";
     }

    
    
}
