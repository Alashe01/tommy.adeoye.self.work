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
public class AgeIn5 {
    
    public static void main(String[] args) {
        Scanner kb = new Scanner (System.in);
        
        String fullName;
        int age;
        
        System.out.print(" Hello.  What is your name? ");
        fullName = kb.next();
        
        System.out.println("");
        
        
        System.out.print("Hi, "+ fullName + "! How old are you? ");
        age= kb.nextInt();
        
        System.out.println("");
        
        System.out.println("Did you know that in five years you will be " + (age + 5) + " years old? " );
        System.out.println("And five years ago you were " + (age - 5) + "! Imagine that! ");
    }
    
}
