/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary.controller;

import com.mycompany.consoleio.ConsoleIO;
import com.mycompany.dvdlibrary.dao.DvdLibraryDao;
import com.mycompany.dvdlibrary.dao.DVDLibraryDaoImpl;
import com.mycompany.dvdlibrary.dto.DvdLibrary;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class DvdLibraryController {
    
    private ConsoleIO io = new ConsoleIO();
    private DvdLibraryDao libraryDao ;
    
    public DvdLibraryController(DvdLibraryDao dao, ConsoleIO consoleio){
        this.libraryDao = dao;
    
}
    
    public void run() {
        
        boolean tryAgain = true;
        
        while(tryAgain) {
            
            io.displayString("***** WELCOME TO MR. NO GOOD DVD LIBRARY **** ");
            io.displayString("_____________________________________________");
            io.displayString("|Please choose from the following options:   |");
            io.displayString("|********************************************|");
            io.displayString("|     1. Add a DVD to Collection             |");
            io.displayString("|     2. Remove a DVD from Collection        |");
            io.displayString("|     3. Search for a DVD by Title           |");
            io.displayString("|     4. List All DVDs in the Collection     |");
            io.displayString("|     5. Display info for particular DVD     |");
            io.displayString("|     6. Edit DVD                            |");
            io.displayString("|     7. Find DVD released in the last n yrs |");
            io.displayString("|     8. Exit                                |");
            io.displayString("**********************************************");
            
            int select = io.getIntRange("", 8, 1);
          
            switch(select) {
                case 1:
                    addDvd();
                    break;
                case 2:
                    removeDvd();
                    break;
                case 3:
                    searchDvd();
                    break;
                case 4:
                    listDVD();
                    break;
                case 5: 
                    displayinfo();
                    break;
                case 6:
                    editAddress();
                    break;
                case 7:
                    dvdbyNyrs();
                    break;
                case 8:
                    //exit
                    io.displayString(" Enjoy life. See you later!");
                    tryAgain = false;
            
            }
        }
        
        
    }

    private void addDvd() {
        String title = io.getString("Please enter your DVD Title : ");
        Integer release = io.getInt("Please enter your DVD release date : ");
        String mpaaRatings =  io.getString("Please enter DVD MPAA Ratings here : ");
        String directorsName =  io.getString("Please enter Director's Name here : ");
        String studio = io.getString("Enter DVD Studio: ");
        String userRating=io.getString("Enter User Ratings/Notes here: ");
//        String addinfo = io.getString("Enter any Additional Information: ");
        
        DvdLibrary myLibrary = new DvdLibrary();
       
        myLibrary.setTitle(title);
        myLibrary.setReleaseDate(release);
        myLibrary.setMpaaRatings(mpaaRatings);
        myLibrary.setDirectorName(directorsName);
        myLibrary.setStudio(studio);
        myLibrary.setUserRating(userRating);
        
                
        DvdLibrary addedDvd =  libraryDao.add(myLibrary);
        io.displayString(" ");
        io.displayString( addedDvd.getTitle() + " has been been added to NO Good's DVD Library SlotId# " + addedDvd.getId());
        io.displayString("");
    }

    private void removeDvd() {
        
        Integer dvdId = io.getInt("Please enter Dvd Slot ID# to remove from Library: ");
        String deleteTitle = io.getString("Confirm Title of DVD you want to remove: ");
        
        DvdLibrary myLibrary = new DvdLibrary();
        myLibrary.setTitle(deleteTitle);
        myLibrary.setId(dvdId);
       
       String confirmDelete=io.getString("Do you really want to delete ? (Y/N): ");
       if (confirmDelete.equalsIgnoreCase("Y"))
       libraryDao.remove(dvdId);
       else
           run(); 
       
       io.displayString("");
       io.displayString(myLibrary.getTitle() +" has been deleted from your library");
       io.displayString("");
    }

    private void searchDvd() {
        String titleSearch = io.getString("What is the title of the DVD you are looking for: ");
        
        DvdLibrary myLibrary = new DvdLibrary();
        myLibrary.setTitle(titleSearch);
        
        DvdLibrary searchedId = libraryDao.read(myLibrary);
        
        io.displayString("Your search result is: " );
        io.displayString(" ");
        io.displayString("Title: "+ searchedId.getTitle());
        io.displayString("Release Date: "+ searchedId.getReleaseDate());
        io.displayString("MPAA Ratings: " + searchedId.getMpaaRatings());
        io.displayString("Director Name: " + searchedId.getDirectorName());
        io.displayString("Studio: " + searchedId.getStudio());
        io.displayString("User Ratings: " + searchedId.getUserRating());
        io.displayString(" ");
        
    }

    private void listDVD() {
        List<DvdLibrary> myLibrary = libraryDao.listall();
        DvdLibrary dl = new DvdLibrary();
        
        
        
        for (DvdLibrary d : myLibrary)
        {
        io.displayString("DVD Slot No."+ d.getId());
        io.displayString("Title:" + d.getTitle());
        io.displayString("Release Date: " + d.getReleaseDate());
        io.displayString("MPAA Ratings: " + d.getMpaaRatings());
        io.displayString("Director Name: " + d.getDirectorName());
        io.displayString("Studio Name: " + d.getStudio());
        io.displayString("User Ratins: " + d.getUserRating());
        io.displayString(" ");
        }
    }

    private void displayinfo() {
        Integer exactId= io.getInt("Enter Id# Number of DVD info to display:");
        
        DvdLibrary myLibrary = new DvdLibrary();
        myLibrary.setId(exactId);
        
        DvdLibrary displayId = libraryDao.readPlay(exactId);
        
        
        io.displayString("Your display result  is: " );
        io.displayString("Title: " + displayId.getTitle());
        io.displayString("Release Date: " + displayId.getReleaseDate());
        io.displayString("MPAA Ratings: " +displayId.getMpaaRatings());
        io.displayString("Director Name: " +displayId.getDirectorName());
        io.displayString("Studio: " +displayId.getStudio());
        io.displayString("USer Rating: " +displayId.getUserRating());
        io.displayString(" ");
        
    }

    private void editAddress() {
      List <DvdLibrary> myLibrary = libraryDao.listall();
      DvdLibrary editLibrary = new DvdLibrary();
      
      for (DvdLibrary d : myLibrary)
        {
        io.displayString("Title: " + d.getTitle());
        io.displayString("Release Date: " + d.getReleaseDate());
        io.displayString("MPAA Ratings: " + d.getMpaaRatings());
        io.displayString("Director Name: " + d.getDirectorName());
        io.displayString("Studio: " + d.getStudio());
        io.displayString("User Rating: " + d.getUserRating());
        io.displayString(" ");
        }
      
      Integer editId = io.getInt("Select Slot Id# of DVD you will like to edit");
      editLibrary.setId(editId);

       DvdLibrary selectedId = libraryDao.readPlay(editId);
            
        
        io.displayString("Your display result  is: " );
        io.displayString("Title: " + selectedId.getTitle());
        io.displayString("Release Date: " +  selectedId.getReleaseDate());
        io.displayString("MPAA Ratings: " + selectedId.getMpaaRatings());
        io.displayString("Director Name: " + selectedId.getDirectorName());
        io.displayString("Studio: " + selectedId.getStudio());
        io.displayString("User Rating: " +selectedId.getUserRating());
        io.displayString(" ");
        
     String choice=io.getString(" Select information you will like to edit: ");
     if (choice.equalsIgnoreCase("Title")){
         String updateTitle = io.getString("Enter new Title here: ");
         DvdLibrary newTitle = selectedId;
         newTitle.setTitle(updateTitle);
        
         libraryDao.update(newTitle);
         io.displayString("Your Title has been updated");
        }
     if (choice.equalsIgnoreCase("Release Date")){
         String updateReleaseDate = io.getString("Enter new Release date here: ");
         DvdLibrary editDate = selectedId;
         editDate.setTitle(updateReleaseDate);
         libraryDao.update(editDate);
        } 
     if (choice.equalsIgnoreCase("MPAA Ratings")){
         String updateMpaaRatings = io.getString("Enter new MPAA Ratings: ");
         DvdLibrary ratings = selectedId;
         ratings.setTitle(updateMpaaRatings);
         libraryDao.update(ratings);
        } 
     if (choice.equalsIgnoreCase("Director Name")){
         String updateDirectorName = io.getString("Enter new Director Name: ");
         DvdLibrary director = selectedId;
         director.setTitle(updateDirectorName);
         libraryDao.update(director);
        } 
    if (choice.equalsIgnoreCase("Studio")){
         String updateStudio = io.getString("Enter new Studio");
         DvdLibrary studio = selectedId;
         studio.setTitle(updateStudio);
         libraryDao.update(studio);
        } 
    if (choice.equalsIgnoreCase("User Rating")){
         DvdLibrary userRate = selectedId;
         String updateUserRating = io.getString("Enter new Studio");
         userRate.setTitle(updateUserRating);
         libraryDao.update(userRate);
        } 
    }

    private void dvdbyNyrs() {
        Integer searchByYr = io.getInt(" Search for movies in the last number of years: ");
        
        DvdLibrary yr = new DvdLibrary();
       yr.setReleaseDate(searchByYr);
       
       List<DvdLibrary> view= libraryDao.releaseByNYrs(searchByYr);
       
        System.out.println(" Results ");
        
        for (DvdLibrary dl : view){
            io.displayString(" Result # "+ dl.getId() );
            io.displayString("Title: " + dl.getTitle());
            io.displayString("Release Date: " +  dl.getReleaseDate());
            io.displayString("MPAA Ratings: " + dl.getMpaaRatings());
            io.displayString("Director Name: " + dl.getDirectorName());
            io.displayString("Studio: " + dl.getStudio());
            io.displayString("User Rating: " +dl.getUserRating());
             io.displayString(" ");
        
        }
        
           
       }
    }
    

