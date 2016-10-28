/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmaster.dao;

import com.mycompany.flooringmastery.dto.OrderFlooring;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.text.DateFormatter;

/**
 *
 * @author apprentice
 */
public class FlooringOrderDaoImpl implements FlooringOrderDao{

   
  
    
    private static final String TOKEN = ",";
    
    //Declare an ArrayList of OrderFlooring datatype called MyOrders and assign it a "null" value;
    private List<OrderFlooring> myOrders = null;
    private Integer nextId = 1;

    public FlooringOrderDaoImpl() {
        myOrders = decode(LocalDate.now());

        for (OrderFlooring of : myOrders) {
            if (of.getOrderId() >= nextId) {
                nextId = of.getOrderId() + 1;
            }
        }
    }
// goes into the decode method
    private List<OrderFlooring> decode(LocalDate d){
        
        List<OrderFlooring> tempOrderList = new ArrayList();
         
        DateTimeFormatter formatter;
        formatter = DateTimeFormatter.ofPattern("MMddyyyy");
//        File NAMEFILE = new File("Order_" + formatter.format(d) + ".txt");
        File NAMEFILE = new File("Order_".concat( formatter.format(d).concat(".txt")));
         
        if (!NAMEFILE.exists()) {
         
             createNewFile(NAMEFILE);
            return tempOrderList;
         }
      String FILENAME = NAMEFILE.toString();
        nextId = 1;
       

        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(FILENAME)));

            while (sc.hasNextLine()) {

                String currentLine = sc.nextLine();

                String[] stringParts = currentLine.split(TOKEN);

                OrderFlooring myOrder = new OrderFlooring();

                //                Date today = Calendar.getInstance().getTime();
                //                String reportedDate = dF.format(today);                
                int orderId = Integer.parseInt(stringParts[0]);
                double taxRate = Double.parseDouble(stringParts[3]);
                double area = Double.parseDouble(stringParts[6]);
                double SqFtCost = Double.parseDouble(stringParts[7]);
                double SqFtcostLabor = Double.parseDouble(stringParts[8]);
                double mCost = Double.parseDouble(stringParts[9]);
                double lCost = Double.parseDouble(stringParts[10]);

                myOrder.setOrderId(orderId);
                myOrder.setCustomerName(stringParts[1]);
                myOrder.setState(stringParts[2]);
                myOrder.setTaxRate(taxRate);
                myOrder.setProdType(stringParts[4]);
                myOrder.setState(stringParts[5]);
                myOrder.setArea(area);
                myOrder.setCostPerSqFt(SqFtCost);
                myOrder.setLaborCostPerSqFt(SqFtcostLabor);
                myOrder.setMaterialCost(mCost);
                myOrder.setLaborCost(lCost);
                myOrder.setProdType(stringParts[11]);
                tempOrderList.add(myOrder);

                    if (myOrder.getOrderId() >= nextId) {
                    nextId = myOrder.getOrderId() + 1;
            }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FlooringOrderDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tempOrderList;
    }

    @Override
    public OrderFlooring create(OrderFlooring order) {

        myOrders = decode(order.getDate());
        order.setOrderId(nextId);
        myOrders.add(order);

        nextId++;
        
       DateTimeFormatter formatter;
        formatter = DateTimeFormatter.ofPattern("MMddyyyy");
        File NAMEFILE = new File("Order_" + formatter.format(order.getDate()) + ".txt");
//        String NAMEFILE = "Order_" + formatter.format(order.getDate()) + ".txt";
        String FILENAME = NAMEFILE.toString();
        encode(myOrders,FILENAME);

        return order;

    }

//    public File todaysFile() {
//        
//        LocalDate date = LocalDate.now();
//        DateTimeFormatter formatter;
//        formatter = DateTimeFormatter.ofPattern("MMddyyyy");
//        String currentDateString = "Orders_".concat(date.format(formatter).toString()).concat(".txt");
//        File currentDateFileName = new File(currentDateString);
//        if (!currentDateFileName.exists()) {
//            try {
//                currentDateFileName.createNewFile();
//            } catch (IOException ex) {
//                Logger.getLogger(FlooringOrderDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return currentDateFileName;
//    }

    private void encode(List<OrderFlooring> orders, String fileName) {

        
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter(fileName));

            for (OrderFlooring ofl : orders) {

                out.print(ofl.getOrderId());
                out.print(TOKEN);

                out.print(ofl.getCustomerName());
                out.print(TOKEN);

                out.print(ofl.getState());
                out.print(TOKEN);

                out.print(ofl.getTaxRate());
                out.print(TOKEN);

                out.print(ofl.getProdType());
                out.print(TOKEN);

                out.print(ofl.getArea());
                out.print(TOKEN);

                out.print(ofl.getCostPerSqFt());
                out.print(TOKEN);

                out.print(ofl.getLaborCostPerSqFt());
                out.print(TOKEN);

                out.print(ofl.getMaterialCost());
                out.print(TOKEN);

                out.print(ofl.getLaborCost());
                out.print(TOKEN);

                out.print(ofl.getTaxTotal());
                out.print(TOKEN);

                out.print(ofl.getTotal());
                out.print(TOKEN);

                out.print(ofl.getDate());
                out.println("");
            }
            out.flush();
        } catch (IOException ex) {
        } finally {
            out.close();
        }
    }

    @Override
    public OrderFlooring read(LocalDate date, int orderNum) {
                    myOrders = decode(date);
        for (OrderFlooring ofg : myOrders) {
            if (ofg.getOrderId() == orderNum) {
                return ofg;
            }
        }
        return null;

    }

    @Override
    public void update(OrderFlooring order) {
        myOrders=decode(order.getDate());
        for (OrderFlooring ord : myOrders) {
            if (ord.getOrderId() == order.getOrderId()) {
                ord = order;
            }
        }  
        DateTimeFormatter formatter;
        formatter = DateTimeFormatter.ofPattern("MMddyyyy");
//        File NAMEFILE = new File("Order_" + formatter.format(order.getDate()) + ".txt");
        String NAMEFILE = "Order_" + formatter.format(order.getDate()) + ".txt";
        encode(myOrders,NAMEFILE);
    }

    @Override
    public void delete(LocalDate date, int orderNum) {
        myOrders=decode(date);
//        for (OrderFlooring oNum : myOrders) {
        for (int i =0; i<myOrders.size(); i++){
            OrderFlooring oNum= myOrders.get(i);
            
           if (oNum.getOrderId() == orderNum) {
                myOrders.remove(oNum);
            break;
            }
            
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
        String NAMEFILE = "Order_" + formatter.format(date) + ".txt";
        encode(myOrders, NAMEFILE);
    }

    @Override
    public List<OrderFlooring> listall() {
       return decode(LocalDate.now());

//        return new ArrayList(myOrders);
    }

    @Override
    public List<OrderFlooring> list(LocalDate orderDate) {
        
        
//        Predicate<OrderFlooring> dateNamePredicate;
//            dateNamePredicate = (OrderFlooring og) -> {
//            return og.getDate()==orderDate;
//        };
            myOrders=decode(orderDate);
            return myOrders;
//                    .stream()
//                    .filter(dateNamePredicate)
//                    .collect(Collectors.toList());
    }
    
    public void createNewFile(File filename){
       
        //I added this and it rid the null poinrtet ecghpueuuytuon.

        List<OrderFlooring> orders = new ArrayList<>();


        PrintWriter out = null;
        //String input = io.getString("What date are you looking for? Please format: mmddyyyy ");
        //String orderSearch = "ORDERS_" + input + ".txt";
        // String input = io.getString("Filename: ");

        try{
            out = new PrintWriter(new FileWriter(filename));

            for(OrderFlooring s : orders)
            {

                out.print(s.getOrderId());
                out.print(TOKEN);

                out.print(s.getCustomerName());
                out.print(TOKEN);

                out.print(s.getState());
                out.print(TOKEN);

                out.print(s.getTaxRate());
                out.print(TOKEN);

                out.print(s.getProdType());
                out.print(TOKEN);

                out.print(s.getArea());
                out.print(TOKEN);

                out.print(s.getCostPerSqFt());
                out.print(TOKEN);

                out.print(s.getLaborCostPerSqFt());
                out.print(TOKEN);

                out.print(s.getMaterialCost());
                out.print(TOKEN);

                out.print(s.getLaborCost());
                out.print(TOKEN);

                out.print(s.getTaxTotal());
                out.print(TOKEN);

                out.print(s.getTotal());
                out.print(TOKEN);

                out.print(s.getDate());
                out.print("\n");

            }


        } catch (IOException ex) {


        } finally {

            out.close();
        }

    }
        
    }



