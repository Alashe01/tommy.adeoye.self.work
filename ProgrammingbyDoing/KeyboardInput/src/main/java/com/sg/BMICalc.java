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
public class BMICalc {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);
        
        double mHeight, mHeight2, kgWeight, inHeight, lbsWeight, ftHeight, inchesHeight,lb2Weight;
        
        System.out.print(" Your height in m: ");
        mHeight= sc.nextDouble();
        
        System.out.print(" Your weight in kg:  ");
        kgWeight = sc.nextDouble();
        
        mHeight*= mHeight;
        
        System.out.print(" Your BMI is " + ( kgWeight/mHeight));
        
        
        System.out.println("");
        
        System.out.print(" Your height in inches: ");
        inHeight= sc.nextDouble();
        
        System.out.print(" Your weight in pounds: ");
        lbsWeight = sc.nextDouble();
        
        inHeight*=0.0254;
        
        double newinHeight = inHeight*=inHeight;
        double newlbsWeight = lbsWeight * 0.453592;
        
        System.out.println(" Your BMI is " + (newlbsWeight/newinHeight));
        
         
        System.out.print("");
        System.out.print(" Your height (feet only): ");
        ftHeight = sc.nextDouble();
        
        System.out.print(" Your height (inches); ");
        inchesHeight = sc.nextDouble();
        
        System.out.print(" Your weight in pounds:");
        lb2Weight = sc.nextDouble();
        
        double newinchesHeight;
        newinchesHeight = (ftHeight * 12) + inchesHeight;
        newinchesHeight*=0.0254;
        newinchesHeight*=newinchesHeight;
        double newlb2Weight = lb2Weight * 0.453592;
        
        System.out.println(" Your BMI is " + (newlb2Weight/newinchesHeight) );
        
        
        
        
        
        
        
    }
    
}
