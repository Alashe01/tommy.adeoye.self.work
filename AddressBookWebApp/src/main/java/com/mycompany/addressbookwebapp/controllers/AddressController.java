/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.addressbookwebapp.controllers;

import com.mycompany.addressbookwebapp.dao.AddressBookDao;
import com.mycompany.addressbookwebapp.dto.AddressBook;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author apprentice
 */
@Controller
@RequestMapping(value="/address")
public class AddressController {
    
   
    private AddressBookDao addressBookDao;

    @Inject
    public AddressController(AddressBookDao addressBookDao){
        this.addressBookDao= addressBookDao;
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    @ResponseBody
    public AddressBook view(@PathVariable ("id") Integer addressId ){
        
        AddressBook ad = addressBookDao.read(addressId);
        
        return ad;
        
    }

    
    @RequestMapping(value="", method=RequestMethod.POST)
    @ResponseBody
    public AddressBook add(@Valid @RequestBody AddressBook address ){
        
       AddressBook ab = addressBookDao.add(address);
        
        return ab;   
    }
    
        
    @RequestMapping(value="edit/{id}", method=RequestMethod.GET)
    public String edit(@PathVariable("id") Integer addressId, Map model){
        
        AddressBook ad= addressBookDao.read(addressId);
        
        model.put("address", ad);
        
        return "edit";
    }
    
    
    @RequestMapping(value="/{id}", method= RequestMethod.PUT)
    @ResponseBody
    public AddressBook editPost(@RequestBody AddressBook address){
        
        addressBookDao.update(address);
        
        return address;
    }
    
    
    @RequestMapping(value="delete/{id}", method=RequestMethod.GET)
    public String delete (@PathVariable("id") Integer addressId, Map model){
        
        AddressBook ad = addressBookDao.read(addressId);
        
        model.put("address", ad);
        
        return "delete";
    }
    
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public void deletePost(@PathVariable("id") Integer addressId) {
//
//        AddressBook ab = addressBookDao.read(addressId);
//        addressBookDao.delete(ab);
//
//    }
//    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deletePost(@RequestBody AddressBook address) {

//        AddressBook ab = addressBookDao.read(addressId);
        addressBookDao.delete(address);

    }
}
