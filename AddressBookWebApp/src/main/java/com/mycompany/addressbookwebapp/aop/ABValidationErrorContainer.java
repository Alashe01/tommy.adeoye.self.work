/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.addressbookwebapp.aop;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class ABValidationErrorContainer {
    
    private List<ABValidationError> errorData = new ArrayList();
    
    public List<ABValidationError> getErrors(){
        return errorData;
    }
    
    public void addError(ABValidationError error){
        errorData.add(error);
    }
}
