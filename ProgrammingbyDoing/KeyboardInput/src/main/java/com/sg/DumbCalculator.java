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
public class DumbCalculator {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        double num1,num2,num3;
        
        System.out.print("What is your first number? ");
        num1=keyboard.nextDouble();
        
        System.out.print("What is your second number?  ");
        num2=keyboard.nextDouble();
        
        System.out.print("What is your third number?  ");
        num3=keyboard.nextDouble();
        
        double sum = num1 + num2 + num3;
        
        
        System.out.println( (num1 + " + " + num2 + " + " + num3 ) + " /2 is " + 4.4 );
                
        
        
    }
}
