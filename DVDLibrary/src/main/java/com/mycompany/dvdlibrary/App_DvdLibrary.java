/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary;

import com.mycompany.dvdlibrary.controller.DvdLibraryController;
import com.mycompany.dvdlibrary.dao.DVDLibraryDaoImpl;
import com.mycompany.dvdlibrary.dao.DvdLibraryDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class App_DvdLibrary {
    public static void main(String[] args) {
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        
//        DvdLibraryDao current = ctx.getBean("dvdLibraryDao", DvdLibraryDao.class);
            
        DvdLibraryController done = (DvdLibraryController)ctx.getBean("dvdLibraryController");
        
        done.run();
    }
    
    
}
