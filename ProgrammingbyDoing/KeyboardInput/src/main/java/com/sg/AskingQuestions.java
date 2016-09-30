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
public class AskingQuestions {
    public static void main(String[] args) {
        
        Scanner keyboard  = new Scanner (System.in);
        
        int age;
        String ftHeight;
        String inHeight;
        double weight;
       
        
        System.out.print("How old are you? ");
        age = keyboard.nextInt();
        
        System.out.print("How many feet tall are you? ");
        ftHeight = keyboard.next();
        
        System.out.print(" And how many inches? ");
        inHeight = keyboard.next();
        
        System.out.print("How much do you weigh? ");
        weight = keyboard.nextDouble();
        
        System.out.println("So you're " + age + " old, " + ftHeight + "'" + inHeight + " tall and " + weight + " heavy. ");
        
        
        
    }
}
