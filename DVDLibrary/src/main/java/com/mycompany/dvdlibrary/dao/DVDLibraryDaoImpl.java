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
public class DVDLibraryDaoImpl implements DvdLibraryDao {

    private static final String FILENAME  = "dvdlibrary.txt";
    private static final String TOKEN  = "::";

    private List<DvdLibrary> myLibrary = null;
    private Integer nextId = 1;

    
    public DVDLibraryDaoImpl() {

    myLibrary = decode();

        for (DvdLibrary d : myLibrary) {
            if (d.getId() >= nextId) {
                nextId = d.getId() + 1;
            }

        }
    }

    @Override
    public DvdLibrary add(DvdLibrary library) {
        library.setId(nextId);
        myLibrary.add(library);

        nextId++;

        encode();
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
        encode();
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
    encode();
    }
    
    
    private List<DvdLibrary> decode() {
      List<DvdLibrary> tempAddressList = new ArrayList();
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(FILENAME)));

            while (sc.hasNextLine()) {

                String currentLine = sc.nextLine();

                String[] stringParts = currentLine.split(TOKEN);

                DvdLibrary myLibrary = new DvdLibrary();

                int dvdId = Integer.parseInt(stringParts[0]);
                int releaseDate=Integer.parseInt(stringParts[2]);

                myLibrary.setId(dvdId);
                myLibrary.setTitle(stringParts[1]);
                myLibrary.setReleaseDate(releaseDate);
                myLibrary.setMpaaRatings(stringParts[3]);
                myLibrary.setDirectorName(stringParts[4]);
                myLibrary.setStudio(stringParts[5]);
                myLibrary.setUserRating(stringParts[6]);
                tempAddressList.add(myLibrary);

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DVDLibraryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tempAddressList;   
    }
    
private void encode(){
    PrintWriter out = null;
    try {
        out = new PrintWriter(new FileWriter(FILENAME));
        
        for (DvdLibrary d : myLibrary) {
            
            out.print(d.getId());
            out.print(TOKEN);
            
            out.print(d.getTitle());
            out.print(TOKEN);
            
            out.print(d.getReleaseDate());
            out.print(TOKEN);
            
            out.print(d.getMpaaRatings());
            out.print(TOKEN);
            
            out.print(d.getDirectorName());
            out.print(TOKEN);
            
            out.print(d.getStudio());
            out.print(TOKEN);
            
            out.print(d.getUserRating());
            out.println(" ");
    }
        out.flush();
    } catch (IOException ex){
    }finally{
        out.close();
} 
}  

@Override
public List releaseByNYrs(int n){
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

