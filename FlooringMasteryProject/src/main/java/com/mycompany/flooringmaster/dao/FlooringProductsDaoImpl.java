/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmaster.dao;

import com.mycompany.flooringmastery.dto.OrderFlooring;
import com.mycompany.flooringmastery.dto.ProductsFlooring;
import com.mycompany.flooringmastery.dto.TaxFlooring;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */
public class FlooringProductsDaoImpl implements FlooringProductsDao {
    
     
    
//    SimpleDateFormat dateFormat = new SimpleDateFormat("MMddYYYY") ;
    
    private static final String FILENAME= "Products.txt";
    private static final String TOKEN = ",";
    private List<ProductsFlooring> myProduct = null;
    private Integer nextId = 1;
    
    public FlooringProductsDaoImpl(){
        myProduct = decode();
        
        for (ProductsFlooring fp : myProduct){
            if (fp.getProdId() >= nextId) {
                nextId = fp.getProdId() + 1;
            }
        }
    }
    
    
    private List<ProductsFlooring> decode() {
        
        List<ProductsFlooring> tempProductList = new ArrayList();
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(FILENAME)));

            while (sc.hasNextLine()) {

                String currentLine = sc.nextLine();

                String[] stringParts = currentLine.split(TOKEN);

                ProductsFlooring myProduct = new ProductsFlooring();

//                Date today = Calendar.getInstance().getTime();
//                String reportedDate = dF.format(today);                
                
                int id = Integer.parseInt(stringParts[0]);
                double costPerSqft= Double.parseDouble(stringParts[2]);
                double costLperSqft= Double.parseDouble(stringParts[3]);
                
                
                myProduct.setProdId(id);
                myProduct.setProductType(stringParts[1]);
                myProduct.setCostPerSquareFoot(costPerSqft);
                myProduct.setLaborCostPerSquareFoot(costLperSqft);
                     tempProductList.add(myProduct);

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FlooringProductsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tempProductList;
    }
    
     @Override
    public ProductsFlooring create(ProductsFlooring product){
           product.setProdId(nextId);
           myProduct.add(product);
           
           nextId++;
           
           encode();
           
           return product;
    }

    private void encode() {
        
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter(FILENAME));

            for (ProductsFlooring pfg : myProduct) {

                out.print(pfg.getProdId());
                out.print(TOKEN);

                 out.print(pfg.getProductType());
                out.print(TOKEN);
                
                out.print(pfg.getCostPerSquareFoot());
                out.print(TOKEN);
                
                out.print(pfg.getLaborCostPerSquareFoot());
                out.print(TOKEN);
                
                
            }
            out.flush();
        } catch (IOException ex) {
        } finally {
            out.close();
        }
    }
    
     @Override
     public void delete(int productNum) {
        for (ProductsFlooring pf : myProduct) {
            if (pf.getProdId() == productNum) {
                myProduct.remove(pf);
            }
            break;
        }
        encode();
    }
     
     @Override
     public void update(ProductsFlooring floor) {
        for (ProductsFlooring pfg : myProduct) {
            if (pfg.getProdId() == floor.getProdId()) {
                pfg = floor;
            }
        }
    }
     
     public List<ProductsFlooring> show( int idNum){
            
          return new ArrayList(myProduct);
        
     }

     
    @Override
     public ProductsFlooring read(ProductsFlooring pro) {

        for (ProductsFlooring a : myProduct) {
            if (a.getProdId()==pro.getProdId()) {
                return a;
            }

        }
        return null;
    }
//    @Override
//    public List<ProductsFlooring> getInfo(int IdNum) {
//        
//        List<ProductsFlooring> loc = 
//    }

    @Override
    public List<ProductsFlooring> getInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
     
    }
    
    



