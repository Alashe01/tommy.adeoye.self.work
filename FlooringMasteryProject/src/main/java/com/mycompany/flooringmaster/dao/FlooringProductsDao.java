/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmaster.dao;

import com.mycompany.flooringmastery.dto.ProductsFlooring;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface  FlooringProductsDao {
    
    ProductsFlooring create(ProductsFlooring product);
    
//    ProductsFlooring read ();
    
    void delete(int productId);
    
    void update(ProductsFlooring prroduct); 
    
    List<ProductsFlooring> getInfo();
    
    public ProductsFlooring read(ProductsFlooring pro);
    
}
