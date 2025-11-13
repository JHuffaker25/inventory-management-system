package com.skillstorm.inventory_management_system.Models;

public class Warehouse {
    
    //Fields////////////////////
    private long warehouseId;
    private long userId;
    private String name;
    private String location;
    private long maxCapacity;

    //Boilerplate///////////////////////////////////////////////////////////////////////////////////////
    public Warehouse() {
    }

    public Warehouse(long warehouseId, long userId, String name, String location, long maxCapacity) {
        this.warehouseId = warehouseId;
        this.userId = userId;
        this.name = name;
        this.location = location;
        this.maxCapacity = maxCapacity;
    }

    public long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (warehouseId ^ (warehouseId >>> 32));
        result = prime * result + (int) (userId ^ (userId >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((location == null) ? 0 : location.hashCode());
        result = prime * result + (int) (maxCapacity ^ (maxCapacity >>> 32));
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
        if (userId != other.userId)
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
        return true;
    }

    @Override
    public String toString() {
        return "Warehouse [warehouseId=" + warehouseId + ", userId=" + userId + ", name=" + name + ", location="
                + location + ", maxCapacity=" + maxCapacity + "]";
    }

    
    
    
}
