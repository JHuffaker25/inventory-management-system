package com.skillstorm.inventory_management_system.Models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class User {
    
    //Fields////////////////////////////////////////////////
    @Id
    @Column (name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column (name = "first_name")
    private String firstName;

    @Column (name= "last_name")
    private String lastName;

    @OneToMany (targetEntity = Warehouse.class, mappedBy = "user")
    private Set<Warehouse> warehouses;

    
    //Boilerplate///////////////////////////////////////////////////
    public User() {
    }


    public User(long userId, String firstName, String lastName, Set<Warehouse> warehouses) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.warehouses = warehouses;
    }


    public User(String firstName, String lastName, Set<Warehouse> warehouses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.warehouses = warehouses;
    }


    public long getUserId() {
        return userId;
    }


    public void setUserId(long userId) {
        this.userId = userId;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public Set<Warehouse> getWarehouses() {
        return warehouses;
    }


    public void setWarehouses(Set<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (userId ^ (userId >>> 32));
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((warehouses == null) ? 0 : warehouses.hashCode());
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
        User other = (User) obj;
        if (userId != other.userId)
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (warehouses == null) {
            if (other.warehouses != null)
                return false;
        } else if (!warehouses.equals(other.warehouses))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }

    

}
