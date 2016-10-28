/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.addressbookwebapp.dao;

import com.mycompany.addressbookwebapp.dto.AddressBook;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class AddressBookDaoImpl implements AddressBookDao {

    private static final String FILENAME = "addressbooklog.txt";
    private static final String TOKEN = "::";

    private List<AddressBook> myAddress = null; //creates a list for address book for access with private encapuslation
    private Integer nextId = 1;                            //declare an integer to identify each address by ID.

    public AddressBookDaoImpl() {

        this.myAddress = decode();

        for (AddressBook a : myAddress) {
            if (a.getId() >= nextId) {
                nextId = a.getId() + 1;
            }
        }
    }

    @Override
    public AddressBook add(AddressBook address) {           //Adopt the CreateReadUpdateDelete Method .
        address.setId(nextId);
        myAddress.add(address);

        nextId++;

        encode();

        return address;

    }

    //method to read address by Integer and return AddressBook
    @Override
    public AddressBook read(Integer id) {

        for (AddressBook a : myAddress) {
            if (a.getId() == id) {
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
        for (int i = 0; i < myAddress.size(); i++) {
            if (myAddress.get(i).getId().equals(address.getId())) {
                myAddress.set(i, address);
            }
        }
        encode();
    }

    //method to delete address information
    @Override
    public void delete(AddressBook address) {

        for (AddressBook a : myAddress) {
            if (a.getId() == address.getId()) {
                myAddress.remove(a);
                break;
            }

        }
        encode();
    }

    @Override
    public void deletebyID(Integer Id) {

        for (AddressBook ad : myAddress) {
            if (ad.getId() == Id) {
                myAddress.remove(ad);
            }
            break;
        }
        encode();
    }

    @Override
    public List<AddressBook> show() {
        return new ArrayList(myAddress);
    }

    private List<AddressBook> decode() {

        List<AddressBook> tempAddressList = new ArrayList();

        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(FILENAME)));

            while (sc.hasNextLine()) {

                String currentLine = sc.nextLine();

                String[] stringParts = currentLine.split(TOKEN);

                AddressBook myAddress = new AddressBook();

                int addressId = Integer.parseInt(stringParts[0]);

                myAddress.setId(addressId);
                myAddress.setFirstName(stringParts[1]);
                myAddress.setLastName(stringParts[2]);
                myAddress.setStreetAddress(stringParts[3]);
                myAddress.setCity(stringParts[4]);
                myAddress.setState(stringParts[5]);
                myAddress.setZipCode(stringParts[6]);

                tempAddressList.add(myAddress);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddressBookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tempAddressList;
    }

    private void encode() {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter(FILENAME));

            for (AddressBook a : myAddress) {

                out.print(a.getId());
                out.print(TOKEN);

                out.print(a.getFirstName());
                out.print(TOKEN);

                out.print(a.getLastName());
                out.print(TOKEN);

                out.print(a.getStreetAddress());
                out.print(TOKEN);

                out.print(a.getCity());
                out.print(TOKEN);

                out.print(a.getState());
                out.print(TOKEN);

                out.println(a.getZipCode());

            }
            out.flush();
        } catch (IOException ex) {
        } finally {
            out.close();
        }
    }

    @Override
    public List<AddressBook> findAddressByLastName(String lastName) {
        {

            Predicate<AddressBook> lastNamePredicate = (AddressBook ad) -> {
                return ad.getLastName().equalsIgnoreCase(lastName);

            };

            return myAddress
                    .stream()
                    .filter(lastNamePredicate)
                    .collect(Collectors.toList());
        }

    }

    @Override
    public List<AddressBook> findAddressByCity(String cityName) {
        {

            Predicate<AddressBook> cityNamePredicate;
            cityNamePredicate = (AddressBook ad) -> ad.getCity().equalsIgnoreCase(cityName);

            return myAddress
                    .stream()
                    .filter(cityNamePredicate)
                    .collect(Collectors.toList());
        }

    }

    @Override
    public Map< String, List<AddressBook>> addressByState(String state) {

        Predicate<AddressBook> statePredicate = (AddressBook ad) -> {
            return ad.getState().equalsIgnoreCase(state);

        };

        return myAddress
                .stream()
                .filter(statePredicate)
                .collect(Collectors.groupingBy(AddressBook::getCity));

    }

    @Override
    public List<AddressBook> addressByZipCode(String zip) {

        Predicate<AddressBook> zipPredicate = (AddressBook a) -> {
            return (zip).equals(a.getZipCode().trim());
        };

        List<AddressBook> results = myAddress
                .stream()
                .filter(zipPredicate)
                .collect(Collectors.toList());
        return results;
    }

}
