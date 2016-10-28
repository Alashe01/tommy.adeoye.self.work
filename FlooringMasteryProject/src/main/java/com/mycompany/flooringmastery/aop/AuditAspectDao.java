/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | TemplatesA
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.aop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */
public class AuditAspectDao {
    
    private static final String FILENAME = "logs.txt";  
    private static final String TOKEN = ",";
    
   
    private List<AuditAspectDTO> orderLog = null;
    private Integer nextId = 1;

    public AuditAspectDao() {
        orderLog   = decode();
        
        for (AuditAspectDTO ad : orderLog){
            if(ad.getOrderId() >= nextId){
             nextId = ad.getOrderId() + 1;
    }
        }
    }

    private List<AuditAspectDTO> decode() {
        
        
        List<AuditAspectDTO> logOrder = new ArrayList();
        
          try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(FILENAME)));
            
            while (sc.hasNextLine()) {
                
                String currentLine = sc.nextLine();
                
                String[] stringParts = currentLine.split(TOKEN);
                
                AuditAspectDTO myAudit = new AuditAspectDTO();
                
                String IdNum = Integer.parseInt(stringParts[0]);
                LocalDate date= LocalDate.parseDate(stringParts[3]);
                
                myAudit.setOrderId(IdNum);
                myAudit.setOperation(stringParts[1]);
                myAudit.setLastName(stringParts[2]);
                
                tempStudentList.add(myStudent);
                
            }
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tempStudentList;
        
    }
        
    }
    
    
    
}
