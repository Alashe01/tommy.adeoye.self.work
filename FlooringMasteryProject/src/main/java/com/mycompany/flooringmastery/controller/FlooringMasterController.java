/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.controller;

import com.mycompany.consoleio.ConsoleIO;
import com.mycompany.flooringmaster.dao.FlooringOrderDao;
import com.mycompany.flooringmaster.dao.FlooringProductsDao;
import com.mycompany.flooringmaster.dao.FlooringTaxDao;
import com.mycompany.flooringmastery.dto.OrderFlooring;
import com.mycompany.flooringmastery.dto.ProductsFlooring;
import com.mycompany.flooringmastery.dto.TaxFlooring;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class FlooringMasterController {
    
      private ConsoleIO io = new ConsoleIO();
      private FlooringProductsDao productDao;
      private FlooringOrderDao orderDao;
      private FlooringTaxDao taxDao;
    
    public FlooringMasterController ( FlooringProductsDao myPDao, 
            FlooringOrderDao myODao, FlooringTaxDao myTDao, ConsoleIO consoleio)
    {
        this.productDao=myPDao;
        this.orderDao=myODao;
        this.taxDao=myTDao;
        this.io=consoleio;
    }
    
    public void run() {
        
        boolean runAgain = true;
        
        while(runAgain) {
            
            io.displayString("");
            io.displayString("*********************************************************");
            io.displayString("| PIMP-YA-CRIB Special FLOORING Services. AUG_COHORT_16 |");
            io.displayString("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            io.displayString("**                                                     **");
            io.displayString("**      What would you like to do?                     **");
            io.displayString("**                                                     **");
            io.displayString("**            1. Display Orders                        **");
            io.displayString("**            2. Add an Order                          **");
            io.displayString("**            3. Edit an Order                         **");
            io.displayString("**            4. Remove an Order                       **");
            io.displayString("**            5. Save Currrent Work                    **");
            io.displayString("**            6. Quit                                  **");
            io.displayString("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            int choice = io.getIntRange("", 6, 1);
                
            
            switch(choice) {
                case 1:
                    displayOrder();
                    break;
                case 2:
                    addOrder();
                    break;
                case 3:
                    editOrder();
                    break;
                case 4:
                    removeOrder();
                    break;
                case 5: 
                    save();
                    break;
                case 6:
                    //exit
                    io.displayString(" Thank you for patronizing TSG FLOORING"
                                   + "-Tommy's Branch. Come visit us again!");
                   runAgain = false;
            
            }
    }

}
     private void mainMenuRun() {
         
        int mainMenu = io.getIntRange("Press 1 to go to the Main Menu",1,1);
        if (mainMenu==1)
            run();
        else
            io.displayString("not a valid entry, enter 1 to go to Main Menu");
    }
    private void displayOrder() {
        LocalDate orderDate = io.getDate("To display a particular order, Please enter date(MMDDYYYY): ");
        
     
        List<OrderFlooring> myOrders = orderDao.list(orderDate);
//           if(myOrders.contains(orderDate)) {
                for (OrderFlooring os: myOrders){
                      io.displayString(" ____________________________________  ");
                    io.displayString("    ***** Your Order Information *****   ");
                    io.displayString("   ====================================  ");
                    io.displayString("");
                    io.displayString("Your order Id Number: " + os.getOrderId());
                    io.displayString("Customer Name: " + os.getCustomerName());
                    io.displayString("State: "+ os.getState());
                    io.displayString("Tax Rate: " + os.getTaxRate());
                    io.displayString("Product Type: " + os.getProdType());
                    io.displayString("Area: " + os.getArea());
                    io.displayString("Cost per Sq Ft: " + os.getCostPerSqFt());
                    io.displayString("Labor cost per Sqft: " + os.getLaborCostPerSqFt());
                    io.displayString("Material Cost: " + os.getMaterialCost());
                    io.displayString("Labor Cost: " + os.getLaborCost());
                    io.displayString("Tax Total: " + os.getTaxTotal());
                    io.displayString("Total: " + os.getTotal());
//                } 
            } if(myOrders==null)
               
            {
               io.displayString("");
               io.displayString("No Orders exists for that date");            }

        
    }

    private void addOrder() {

//       List<ProductsFlooring> pf = productDao.getInfo();
        LocalDate date = io.getDate("Please enter date of order: ");
        String custName = io.getString("Please enter customer's full name: ");
        int stateId = io.getInt("Select State 1.) OH , 2.) PA , 3.) MI , 4.) IN :  ");
        TaxFlooring myTax = new TaxFlooring();
        myTax.setTaxId(stateId);
        TaxFlooring seen = taxDao.read(myTax);
        String stateType = seen.getState();
        double rateTax = seen.getTaxRate();
        io.displayString("State: " + stateType);
        io.displayString("Tax Rate: " + rateTax);
//        double rateTax= io.getDouble("Enter Tax Rate: ");
        //make sure it reqds from DAO..
        int typeProductId = io.getInt("Select product number: 1.) Carpet , 2.) Laminate, 3.) Tile , 4.) Wood . ");
        ProductsFlooring myProduct = new ProductsFlooring();
        myProduct.setProdId(typeProductId);
        ProductsFlooring found = productDao.read(myProduct);
        String prodType = found.getProductType();
        double pSqftCost = found.getCostPerSquareFoot();
        double lPSqftCost = found.getLaborCostPerSquareFoot();

        io.displayString("Product Name: " + prodType);
        double area = io.getDouble("Enter Area: ");
//        double perSqftCost= io.getDouble("Enter cost per square foot: ");
        io.displayString("Cost per Square Foot:" + pSqftCost);
        io.displayString("Labor Cost per Square Foot:" + lPSqftCost);
//        double perSqftLaborC= io.getDouble("Enter Labor cost per square foot: ");
        double costMaterial = calculateCost(pSqftCost, area);
        io.displayString("Material Cost: " + costMaterial);
        double costLabor = calculateCost(lPSqftCost, area);
        io.displayString("Labor Cost: " + costLabor);
        double totalTax = (costMaterial + costLabor) * (rateTax / 100);
        io.displayString("Tax Total: " + totalTax);
        double oneTotal = (pSqftCost + lPSqftCost + area + costMaterial + costLabor + totalTax);
        io.displayString("Grand Total: " + oneTotal );

         
        DecimalFormat df = new DecimalFormat("#.##");
      
       io.displayString("   ____________________________________  ");
       io.displayString("   ******* Your Order Summary *******    ");
       io.displayString("++ ==================================== ++");
       io.displayString("++        Customers Name: "+ custName+   " ");
       io.displayString("++                 State: "+ stateType + "  ");
       io.displayString("++             State Tax: "+ rateTax +"  ");
       io.displayString("++          Product Type: "+ prodType +"  ");
       io.displayString("++                  Area: "+ df.format(area)    + "  ");
       io.displayString("++        Cost (PerSqFt): "+ df.format(pSqftCost) +"  ");
       io.displayString("++   Labor Cost(PerSqFt): "+ df.format(lPSqftCost) +"  ");
       io.displayString("++         Material cost:  "+ df.format(costMaterial) + "  ");
       io.displayString("++            Labor Cost: "+ df.format(costLabor) +"  ");;
       io.displayString("++             Tax total: "+ df.format(totalTax)  +"  ");;
       io.displayString("++                 Total: "+ df.format(oneTotal)  + "  ");;
       io.displayString("++ ==================================== ++");
       io.displayString("");
       io.displayString("");
       
        String options= io.getString("Would you like to proceed with this order? Y/N ");
        
        if (options.equalsIgnoreCase("Y")){
            
        OrderFlooring orderInfo = new OrderFlooring();
        orderInfo.setDate(date);
        orderInfo.setCustomerName(custName);
        orderInfo.setState(stateType);
        orderInfo.setTaxRate(rateTax);
        orderInfo.setProdType(prodType);
        orderInfo.setArea(area);
        orderInfo.setCostPerSqFt(pSqftCost);
        orderInfo.setLaborCostPerSqFt(lPSqftCost);
        orderInfo.setMaterialCost(costMaterial);
        orderInfo.setLaborCost(costLabor);
        orderInfo.setTaxTotal(totalTax);
        orderInfo.setTotal(oneTotal);
        
        OrderFlooring freshOrder = orderDao.create(orderInfo);
        io.displayString("Your order information has been successfully added  to your list");
        io.displayString(" Your order confirmation number is  "+ freshOrder.getOrderId());
        
        }
        else if (options.equalsIgnoreCase("N")){
            io.displayString("Your order has been discarded");
            mainMenuRun();
        }
        
        
        
    }

    private void editOrder() {
    io.displayString("Enter the following information to edit an order: ");
    LocalDate searchDate= io.getDate("Enter Order Date(MMDDYYY) to search: ");
    Integer idNum = io.getInt("Enter Order confirmation number here to search order: ");
    
    List<OrderFlooring> dblcheck= orderDao.list(searchDate);
    
    OrderFlooring order = new OrderFlooring();
    order.setOrderId(idNum);
    
    OrderFlooring look = orderDao.read(searchDate, idNum);
    
    if(dblcheck.contains(look)){
    String foundname = look.getCustomerName();
    String customerName= io.getString(" Enter Customer's name: (" + foundname+")");
    if (customerName.isEmpty()){
        
    }
    else {
        order.setCustomerName(customerName);
        orderDao.update(order);
        io.displayString("Customer name has been successfully changed");
    }
    
    String stateN = look.getState();
    io.displayString(" Edit Customer's state: (" + stateN+")");
    Integer editState= io.getInt("Select new State 1.) OH , 2.) PA , 3.) MI , 4.) IN :"  );
    String stateAsString= Integer.toString(editState);
    if (stateAsString.isEmpty()){
        
    }
    else {
        TaxFlooring nuTax = new TaxFlooring();
        nuTax.setTaxId(editState);
        TaxFlooring seenTwo = taxDao.read(nuTax);
        String stateType = seenTwo.getState();
        order.setState(stateType);
        orderDao.update(order);
        io.displayString("Customer state and Taxes has been successfully updated");
    }
    
    String product = look.getProdType();
    io.displayString(" Enter Customer's name: (" + product+")");
    int tProductId = io.getInt("Select product number: 1.) Carpet , 2.) Laminate, 3.) Tile , 4.) Wood . ");
    String tProductIdAsString= Integer.toString(tProductId);
    if (tProductIdAsString.isEmpty()){
        
    }
    else {
        ProductsFlooring myProduct = new ProductsFlooring();
        myProduct.setProdId(tProductId);
        ProductsFlooring pound = productDao.read(myProduct);
        String prodType1 = pound.getProductType();
        double pSqftCost1 = pound.getCostPerSquareFoot();
        double lPSqftCost1 = pound.getLaborCostPerSquareFoot();
        pound.setProductType(prodType1);
        pound.setCostPerSquareFoot(pSqftCost1);
        pound.setLaborCostPerSquareFoot(lPSqftCost1);
        orderDao.update(order);
        io.displayString("Your product type and costs have been succesfully updated.");
    }
    
    
//    if(dblcheck.contains(idNum)){
//        
//        for ( OrderFlooring of : dblcheck)
//        {
//            io.displayString(of.getCustomerName());
//            io.displayString(of.getProdType());
//            io.displayString(of.getState());
//            io.displayString("Enter" + of.getCostPerSqFt());
//        }
    }
    
    else {
        io.displayString("Order does not exist");
    }
    }

    private void removeOrder() {
    
     LocalDate searchdate = io.getDate("Enter Date to remove Order: ");     
     int deleteId = io.getInt("Enter ID to remove Order: ");
     
     OrderFlooring myFloor = new OrderFlooring();
     myFloor.setDate(searchdate);
     myFloor.setOrderId(deleteId);
     
     OrderFlooring findInfo = orderDao.read(searchdate, deleteId);
     
     io.displayString("Date :" + myFloor.getDate() );
     io.displayInt(findInfo.getOrderId());
     io.displayString(findInfo.getCustomerName());
     io.displayString(findInfo.getState());
     io.displayString(findInfo.getProdType());
     
     String confirmDelete = io.getString("Do you really want to delete this order? Y/N: ");
     if (confirmDelete.equalsIgnoreCase("Y")){
         orderDao.delete(searchdate, deleteId);
         io.displayString("Order Information has been successfully deleted.");
         mainMenuRun();
     }
    else{
        mainMenuRun();
            }
    }
    private void save() {
        io.displayString("we save your work automatically, if you wish to disable"
                       + " this feature, Please contact support.");
    }
    
    public double calculateCost(double a, double area){
        
        double c = a * area;
        
        return c;
    }

}