/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.addressbookwebapp.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author apprentice
 */
public class AddressBook {
    
    
    private Integer id;
    
    @NotEmpty(message= "First name is required ! ")
    @Length(max=52, message= "First Name can only be 52 Characters or less " )
    private String firstName;
    
    @NotEmpty(message= "Last name is required ! ")
    @Length(max=52, message= "Last Name can only be 52 Characters or less " )
    private String lastName;
    
    @NotEmpty(message= "Street Address is required ! ")
    @Length(max=100, message= "Street Address can only accept 100 Characters or less " )
    private String streetAddress;
    
    @NotEmpty(message= "City is required ! ")
    @Length(max=50, message= "City can only be 50 Characters or less " )
    private String city;
    
    @NotEmpty(message= "State is required ! ")
    @Length(max=20, message= "State can only contain 20 Characters" )
    private String state;
    
    @NotEmpty(message= "Zip Code is required ! ")
    @Length(max=20, message= "Zip code can only contain 20 Characters" )
    private String zipCode;

 

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    
       public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    
}
