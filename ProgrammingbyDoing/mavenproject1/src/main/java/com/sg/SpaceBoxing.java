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
public class SpaceBoxing {
    
    public static void main(String[] args) {
            Scanner keyboard = new Scanner (System.in);
         
         int currentEarthWeight;
         int planet=0;
         
        System.out.print(" Please enter your current earth weight ");
            currentEarthWeight= keyboard.nextInt();
        
        System.out.println("");
        System.out.println(" I have information for the following planets: ");
        System.out.println("    1. Venus   2. Mars    3. Jupiter           ");
        System.out.println("    4. Saturn  5. Uranus  6. Neptune           ");
        System.out.println("");
        
        System.out.println("Which planet are you visting? ");
            planet= keyboard.nextInt();
            
         
        switch (planet) {
            case 1:
//                planet = "venus";
                System.out.println("Your weight would be " + (128*0.78)+ " pounds on that planet ");
                break;
            case 2:
//                planet = " mars";
                System.out.println("Your weight would be " + ( 128*0.39) + " pounds on that planet " );
                break;
            case 3:
//                planet = "jupiter";
                System.out.println("Your weight would be " + ( 128*2.65) + " pounds on that planet ");
                break;
            case 4:
//                planet = " saturn ";
                System.out.println("Your weight would be " + ( 128*1.17) + " pounds on that planet ");
                break;
            case 5:
//                planet = " uranus ";
                System.out.println("Your weight would be " + ( 128*1.05 ) + " pounds on that planet ");
                break;
            case 6:
//                planet = " neptune ";
                System.out.println("Your weight would be " + ( 128*1.23 ) + " pounds on that planet ");
                break;
            default:
                break;
        }
    }
}
