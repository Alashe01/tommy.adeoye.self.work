/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg;

/**
 *
 * @author apprentice
 */
public class ElseAndIf {
    public static void main(String[] args) 
    {
        int people = 30;
        int cars =  40;
        int buses = 15;
        
        if ( cars > people)
        {
            System.out.println(" We should take the cars. ");
        }
        else if (cars < people)
        {
            System.out.println(" We should not take the cars. ");
        }    
        
        {
            System.out.println(" We cant decide. ");
        }
        
        if ( buses > cars )
        {
            System.out.println(" That's too many buses. ");
        }
        else if ( buses < cars)
        {
            System.out.println(" Maybe we could take the buses. ");
        }
        else
        {
            System.out.println(" We still can't decide. ");
        }
        
        if (people > buses)
        {
            System.out.println(" All right, let's just take the buses. ");
        }
        else 
        {
            System.out.println(" Fine, let's stay home then. ");
        }
    }
    
}

//else if is for multiple conditions to be met, if one is not met, then the other condition should run.
//removed the else and it still ran because the else if makes it both a statement if the conditions were met.
