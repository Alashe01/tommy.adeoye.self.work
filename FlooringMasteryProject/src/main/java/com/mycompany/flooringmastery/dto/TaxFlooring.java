/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dto;

/**
 *
 * @author apprentice
 */
public class TaxFlooring {
    
    private int taxId;
    private double taxRate;
    private String state;
   

   

    public int getTaxId() {
        return taxId;
    }

    public void setTaxId(int taxId) {
        this.taxId = taxId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
     public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }
   


}
