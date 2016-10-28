    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmaster.dao;

import com.mycompany.flooringmastery.dto.TaxFlooring;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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
public class FlooringTaxDaoImpl implements FlooringTaxDao {
    
     Date d = new Date();
    
    SimpleDateFormat dateFormat = new SimpleDateFormat("MMddYYYY") ;
    
    File  FILENAME=  new File("Taxes.txt");
    private static final String TOKEN = ",";
    private List<TaxFlooring> myTax = null;
    private Integer nextId = 1;
    
    public FlooringTaxDaoImpl() {
        myTax = decode();
        
        for (TaxFlooring t : myTax) {
            if(t.getTaxId() >= nextId){
            nextId = t.getTaxId() + 1;
            }
        }
        
    }

    private List<TaxFlooring> decode() {
        List<TaxFlooring> tempTaxList = new ArrayList();
        
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(FILENAME)));

            while (sc.hasNextLine()) {

                String currentLine = sc.nextLine();

                String[] stringParts = currentLine.split(TOKEN);

                TaxFlooring myTax = new TaxFlooring();

                //                Date today = Calendar.getInstance().getTime();
                //                String reportedDate = dF.format(today);                
                int taxIdNum = Integer.parseInt(stringParts[0]);
                double taxRate = Double.parseDouble(stringParts[2]);
                
                myTax.setTaxId(taxIdNum);
                myTax.setState(stringParts[1]);
                myTax.setTaxRate(taxRate);
                tempTaxList.add(myTax);

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FlooringTaxDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tempTaxList;
    }
        
     @Override
    public TaxFlooring create(TaxFlooring rateTax) {
        rateTax.setTaxId(nextId);
        myTax.add(rateTax);

        nextId++;

        encode();

        return rateTax;

    }

    private void encode() {
        
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter(FILENAME));

            for (TaxFlooring tf : myTax) {

                out.print(tf.getTaxId());
                out.print(TOKEN);

                out.print(tf.getState());
                out.print(TOKEN);
                
                out.print(tf.getTaxRate());
                out.print(TOKEN);
            }
            out.flush();
        } catch (IOException ex) {
        } finally {
            out.close();
        }
    }
    
     @Override
    public void update(TaxFlooring tax) {
        for (TaxFlooring tg : myTax) {
            if (tg.getTaxId()== tax.getTaxId()) {
                tg = tax;
            }
        }
    }
    
     @Override
    public TaxFlooring read(TaxFlooring taxes) {

        for (TaxFlooring a : myTax) {
            if (a.getTaxId()==taxes.getTaxId()) {
                return a;
            }

        }
        return null;
    }
   
    }

