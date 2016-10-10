/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary.dao;

import com.mycompany.dvdlibrary.dto.DvdLibrary;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */
public class DVDLibraryDaoInMemoryImpl implements DvdLibraryDao {

   

    private List<DvdLibrary> myLibrary = new ArrayList();
    private Integer nextId = 1;

    
    public DVDLibraryDaoInMemoryImpl() {

    }

    @Override
    public DvdLibrary add(DvdLibrary library) {
        library.setId(nextId);
        myLibrary.add(library);

        nextId++;

        return library;
    }

    @Override
    public void remove(Integer id) {

        for (DvdLibrary dl : myLibrary) {
            if (dl.getId() == id) {
                myLibrary.remove(dl);
            }
            break;
        }
       
    }

    @Override
    public List<DvdLibrary> listall() {
        return new ArrayList(myLibrary);
    }
    
    @Override
    public DvdLibrary readPlay(Integer id ) {
        
        for (DvdLibrary dl : myLibrary){
            if (dl.getId()== id){
                return dl;
            }
        }
        return null;
    }
    @Override
    public DvdLibrary read(DvdLibrary library ) {
        
        for (DvdLibrary dl : myLibrary){
            if (dl.getTitle().equals(library.getTitle())){
                return dl;
            }
        }
        return null;
    }
    
    @Override
    public void update(DvdLibrary library){
        for (DvdLibrary l : myLibrary){
            if (l.getId()==library.getId()){
                l = library;
            }
        }
    }

    @Override
    public List<DvdLibrary> releaseByNYrs(int n) {
     List<DvdLibrary> entry = new ArrayList();
     
     for (DvdLibrary d : myLibrary){
         if(d.getReleaseDate() >= n){
             entry.add(d);
            
         }
         
     }
     return entry;
    }
    
    public List<DvdLibrary> findByMpaa(String mpaa){
        List<DvdLibrary> myList = new ArrayList();
        
        for (DvdLibrary d : myList)
        {
            if(d.getMpaaRatings().equals(mpaa)){
               return myList;
            }
        }
        return null;
        
    }
   
    

}

