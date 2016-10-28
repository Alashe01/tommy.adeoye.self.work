/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.addressbookwebapp.dao;

import com.mycompany.addressbookwebapp.dto.AddressBook;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public class AddressBookDaoInMemoryImpl implements AddressBookDao {

    private List<AddressBook> myAddress = new ArrayList(); //creates a list for address book for access with private encapuslation
    private Integer nextId = 1;                            //declare an integer to identify each address by ID.

    public AddressBookDaoInMemoryImpl() {
    }

    @Override
    public AddressBook add(AddressBook address) {           //Adopt the CreateReadUpdateDelete Method to access the DAO.
        address.setId(nextId);
        myAddress.add(address);

        nextId++;

        return address;

    }

    //method to read address by Integer and return AddressBook
    @Override
    public AddressBook read(Integer Id) {

        for (AddressBook a : myAddress) {
            if (a.getId().equals(Id)) {
                return a;
            }

        }
        return null;
    }

    @Override
    public AddressBook readAdd(AddressBook address) {

        for (AddressBook a : myAddress) {
            if (a.getLastName().equals(address.getLastName())) {
                return a;
            }

        }
        return null;
    }

    //method to update addrress information
    @Override
    public void update(AddressBook address) {
//        delete(address);
//        myAddress.add(address);
        for (AddressBook s : myAddress) {
            if (s.getId() == address.getId()) {
                s = address;
            }
        }
    }

    //method to delete address information
    @Override
    public void delete(AddressBook address) {

        for (AddressBook a : myAddress) {
            if (a.getLastName().equals(address.getLastName())) {
                myAddress.remove(a);
            }
            break;
        }
    }

    @Override
    public void deletebyID(Integer Id) {

        for (AddressBook ad : myAddress) {
            if (ad.getId() == Id) {
                myAddress.remove(ad);
            }
            break;
        }

    }

    @Override
    public List<AddressBook> show() {
        return new ArrayList(myAddress);
    }

//    @Override
//    public List<AddressBook> findAddressByLastName(String lastName) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    @Override
    public List<AddressBook> findAddressByLastName(String lastName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AddressBook> findAddressByCity(String cityName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, List<AddressBook>> addressByState(String state) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AddressBook> addressByZipCode(String zipcode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
