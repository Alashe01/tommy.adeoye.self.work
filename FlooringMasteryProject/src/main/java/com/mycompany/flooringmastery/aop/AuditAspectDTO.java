/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.aop;

import java.time.LocalDate;

/**
 *
 * @author apprentice
 */
public class AuditAspectDTO {
    
    private Integer orderId;
    private String operation;
    private LocalDate Date;

    
    public Integer  getOrderId() {
        return orderId;
    }


    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

   
    public String getOperation() {
        return operation;
    }

  
    public void setOperation(String operation) {
        this.operation = operation;
    }

    
    public LocalDate getDate() {
        return Date;
    }

   
    public void setDate(LocalDate Date) {
        this.Date = Date;
    }
}
