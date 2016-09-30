/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class MoreUserInputOfData {
    public static void main(String[] args) {
        
        Scanner kb = new Scanner (System.in);
        
        String fName, lName, login;
        int grade, studentID;
        double gpa;
        
        System.out.println(" Please enter the following information so I can sell it for a profit! ");
        
        System.out.println(" ");
        
        System.out.print(" First name: ");
        fName = kb.next();
        
        System.out.print(" Last name: ");
        lName = kb.next();
        
        System.out.print("Grade (9-12):");
        grade = kb.nextInt();
        
        System.out.print("Student ID:");
        studentID = kb.nextInt();
        
        System.out.print("Login: ");
        login=kb.next();
        
        System.out.print(" GPA (0.0-4.0):");
        gpa = kb.nextDouble();
        
        System.out.println("");
        
        System.out.println("Your information: ");
        
        System.out.println("        Login: " + login);
        System.out.println("        ID:     " + studentID);
        System.out.println("        Name:   " + fName +", " + lName );
        System.out.println("        GPA:    " + gpa);
        System.out.println("        Grade:  " + grade);
    }
    
}
