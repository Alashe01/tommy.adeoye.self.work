/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmaster.dao;

import com.mycompany.flooringmastery.dto.TaxFlooring;

/**
 *
 * @author apprentice
 */
public interface  FlooringTaxDao {
    
    TaxFlooring create(TaxFlooring taxRate);
    
    void update(TaxFlooring taxRate);
    
    TaxFlooring read(TaxFlooring taxes);
    
}
