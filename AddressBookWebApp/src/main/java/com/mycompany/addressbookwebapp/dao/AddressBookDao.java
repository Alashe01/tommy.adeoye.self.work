/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.addressbookwebapp.dao;

import com.mycompany.addressbookwebapp.dto.AddressBook;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface AddressBookDao{

    AddressBook add(AddressBook address);

    //method to delete address information
    void delete(AddressBook address);
    
    void deletebyID(Integer Id);

    //method to read address by Integer and return AddressBook
    AddressBook read(Integer Id);

    AddressBook readAdd(AddressBook address);

    List<AddressBook> show();

    //method to update addrress information
    void update(AddressBook address);
    
    List<AddressBook> findAddressByLastName(String lastName);
    
    List<AddressBook> findAddressByCity(String cityName);
    
    Map< String, List<AddressBook>> addressByState(String state);
    
    List<AddressBook> addressByZipCode(String zipcode);
    
}
