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
public class LittleQuiz {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
       
        String quiz;
        int ans,ans1,ans2;
        int count=0;
        
        System.out.println("Are you ready for a quiz");
           quiz = sc.nextLine();
          
        System.out.println(" Okay, here it comes! ");
        System.out.println("");
        System.out.println(" Q1) What is the capital of Alaska? ");
           
        System.out.println("	     1) Melbourne               ");
        System.out.println("         2) Anchorage               ");
        System.out.println("         3) Juneau                  ");
        ans = sc.nextInt();
        
        if (ans == 3)
        {
            System.out.println("That's right! ");
            count++;
            
        }
        else
        {
            System.out.println(" Incorrect answer ");
        }
        
        System.out.println("");
        System.out.println(" Q2) Can you store the value \"cat\" in a variable of type int? ");
        System.out.println("         (1) yes"                                                );
        System.out.println("          2) no"                                                 );
        System.out.println("");
        ans1 = sc.nextInt();
        
        if (ans1 == 1)
        {
            System.out.println("Sorry cat is a string. ints  can only store numbers ");
            
        }
        else
        {
            System.out.println(" That's right! ");
            count++;
        }
        
        System.out.println("");
        System.out.println(" What is the result of 9+6/3?");
        System.out.println(" 	 1) 5");
        System.out.println("	 2) 11");
        System.out.println("     3) 15/3");
        System.out.println("");
        ans2 = sc.nextInt();
        
        if ( ans2 == 2)
        {
            System.out.println(" That is correct! ");
        }
        else
        {
            System.out.println(" Incorrect answer ");
        }
        
        System.out.println("");
        System.out.println(" Overall, you got " + count + "out of 3 correct");
        System.out.println(" Thanks for playing! ");
    }
}
