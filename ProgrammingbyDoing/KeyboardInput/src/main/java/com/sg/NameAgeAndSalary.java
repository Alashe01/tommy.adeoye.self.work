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
public class NameAgeAndSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        
        String name;
        int age;
        double income;
        
        System.out.println(" Hello. What is your name? ");
         name= sc.next();
         
        System.out.println("Hi, " + name + "!  How old are you? " );
         age= sc.nextInt();
         
        System.out.println("So you're " + age + ", eh? That's not old at all!");
        System.out.println("How much do you make," + name + "?");
        income = sc.nextDouble();
        
        System.out.println( income + "!  I hope that's per hour and not per year! LOL!");
    }
  
}
