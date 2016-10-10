/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary.dao;

import com.mycompany.dvdlibrary.dto.DvdLibrary;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface DvdLibraryDao {

    

    DvdLibrary add(DvdLibrary library);

    List<DvdLibrary> listall();

    DvdLibrary read(DvdLibrary library);

    DvdLibrary readPlay(Integer id);

    void remove(Integer id);

    void update(DvdLibrary library);
    
    List releaseByNYrs(int n);
    
}
