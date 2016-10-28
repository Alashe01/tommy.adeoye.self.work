/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmaster.dao;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author apprentice
 */
public class FlooringOrderDaoInMemoryImpl {
    
    Date d = new Date();
    
    SimpleDateFormat dateFormat = new SimpleDateFormat("MMddYYYY") ;
    
    File  FILENAME=  new File("orders_" + dateFormat.format(d) + ".txt");
    private static final String TOKEN = ",";
    
}
