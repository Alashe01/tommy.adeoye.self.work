/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.goodfirstprogram;

/**
 *
 * @author apprentice
 */
public class NumbersAndMath {

    public static void main(String[] args) {
        
        //This line displays the message to the console
        System.out.println("I will now count my chickens:");
        
        //This line displays the message "hen" with the addition of all three numbers
        System.out.println("Hens " + (25.0 + 30.0 / 6.0));
        //This line displays the message roosters with the calculation
        System.out.println("Roosters " + (100.0 - 25.0 * 3.0 % 4.0));
        //This line displays the message to the console.
        System.out.println("Now I will count the eggs:");
        //This line gives you calculation of all three numbers
        System.out.println(3.0 + 2.0 + 1.0 - 5.0 + 4.0 % 2.0 - 1.0 / 4.0 + 6.0);
        //This gives you a boolean isTrue or isFalse on the calculation in this line.
        System.out.println("Is it true that 3.0 + 2.0 < 5.0 - 7.0?");
        //This gives you a calculation on the line below
        System.out.println(3.0 + 2.0 < 5.0 - 7.0);
        //this gives you the calculation of what is done below.
        System.out.println("What is 3 + 2? " + (3.0 + 2.0));
        System.out.println("What is 5 - 7? " + (5.0 - 7.0));

        System.out.println("Oh, that's why it's false.");

        System.out.println("How about some more.");

        System.out.println("Is it greater? " + (5.0 > -2.0));
        System.out.println("Is it greater or equal? " + (5.0 >= -2.0));
        System.out.println("Is it less or equal? " + (5.0 <= -2.0));
        // a float is less precise than a double , the conversion cannot be performed implicitly
    }

}
