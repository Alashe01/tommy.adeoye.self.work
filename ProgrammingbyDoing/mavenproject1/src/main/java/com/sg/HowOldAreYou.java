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
public class HowOldAreYou {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String name;
        int age;
        
        System.out.print("Hey, What's your name ? ");
        name = sc.nextLine();
        
        System.out.println("");
        
        System.out.print(" Ok, " + name + " how old are you? ");
        age = sc.nextInt();
        
        System.out.println("");
        
        if (age < 16)
        { 
            System.out.println(" You can't drive " + name);
        }
        
        if ( age < 18)
        {
            System.out.println(" You can't vote, " + name);
        }
        
        if ( age < 25 )
        {
            System.out.println(" You can't rent a car, " + name);
        }
        
        if ( age >= 25 )
        {
            System.out.println(" You can't do anything that's legal " + name);
        }
    }
    
}
