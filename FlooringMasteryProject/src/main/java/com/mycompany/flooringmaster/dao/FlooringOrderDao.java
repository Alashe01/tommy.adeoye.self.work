/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmaster.dao;

import com.mycompany.flooringmastery.dto.OrderFlooring;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface FlooringOrderDao {
    
    OrderFlooring create(OrderFlooring order);
    
    OrderFlooring read(LocalDate date, int orderNum);
    
    void update(OrderFlooring order);
    
    void delete(LocalDate date, int orderNum);
    
    List<OrderFlooring> listall(); 
    
    List<OrderFlooring> list(LocalDate orderDate);
}
