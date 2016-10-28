/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmasteryproject;

import com.mycompany.flooringmastery.controller.FlooringMasterController;
import com.mycompany.flooringmaster.dao.FlooringOrderDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class App_FlooringMastery {
    
    public static void main(String[] args) {
        
    ApplicationContext fmp = new ClassPathXmlApplicationContext("applicationContext.xml");
    
    FlooringMasterController master = (FlooringMasterController)fmp.getBean("flooringController");
    master.run();
        
    }
    
    
                
    
}
    
//Flooring Matery UML
//Data
//================
//Orders_MMDDYYYY.txt (many of these)
//Taxes.txt
//Products.txt
//DTO's
//================
//Order
//------------
//-private Date date
//-private int order number
//-private String customerName
//-private String state
//-private double taxRate
//-private String pType
//-private double area
//-private double costPerSqFt
//-private double materialCost
//-private double laborCost
//-private double taxTotal
//-private double total
//+Getter/Setters
//Tax
//--------------
//private int taxId
//-private String state
//-private double taxRate
//+Getters/Setters
//Products
//--------------
//-private int prodId
//-private String ProductType
//-private double CostPerSquareFoot
//-private double LaborCostPerSquareFoot
//+Getters/Setters
//DAO's
//=================
//OrderDao
//-------------
//-private Map<Date date, List<Order> ordersOnDate> orderList
//-private int nextId
//+public Order create(Order)
//+public Order read(orderId) 
//+public void update(Order)
//+public void delete(Order)
//+public void encode(Date date, List<Order>)
//+public Map<int date,List<Order>> decode
//+public List<Order> searchByDate
//+public List<Order> OTHERSEARCHES
//TaxDao
//--------------
//-private ArrayList<Tax> taxList
//+public Tax create(Tax)
//+public Tax read(state) 
//+public void update(Tax)
//+public void delete(Tax)
//+public void encode
//+public List<Tax> decode
//Products
//-------------
//-private ArrayList<Product> productList
//+public Product create(Product)
//+public Product read(productType) 
//+public void update(Product)
//+public void delete(Product)
//+public void encode
//+public List<Product> decode
//Controller
//=========================
//FlooringMasterController
//------------------------
//-private date
//+public void run
//+private void displayOrders
//+private void addOrder
//+private void editOrder
//+private void removeOrder
//+private void saveWork
//+private void searchAll
//+private void OTHERSEARCHES