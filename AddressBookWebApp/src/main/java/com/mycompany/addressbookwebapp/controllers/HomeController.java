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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class HomeController {
    
    private AddressBookDao addressBookDao;
    
    @Inject
    public HomeController (AddressBookDao addressBookDao){
        
        this.addressBookDao = addressBookDao;
        
    }
    
//    @RequestMapping (value="/", method=RequestMethod.GET)
//    public String home (Map model) {
//        
//        List<AddressBook> myAddress = addressBookDao.show();
//        
//        model.put("addressBook", myAddress);
//        return "home";
//    }
    
    @RequestMapping (value="/", method=RequestMethod.GET)
    public String home (Map model) {
        
        List<AddressBook> myAddress = addressBookDao.show();
        
        model.put("address", new AddressBook());
        model.put("addressBook", myAddress);
        return "home";
        
    }
}

