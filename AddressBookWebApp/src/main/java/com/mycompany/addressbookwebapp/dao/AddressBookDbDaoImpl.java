/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.addressbookwebapp.dao;

import com.mycompany.addressbookwebapp.dto.AddressBook;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class AddressBookDbDaoImpl implements AddressBookDao {

    private static final String SQL_INSERT_ADDRESS = "INSERT INTO addressbook (first_Name,last_Name,streetaddress,city,state,zipcode) VALUES (?,?,?,?,?,?) ";
    private static final String SQL_DELETE_ADDRESS = "DELETE FROM addressbook WHERE id = ? ";
    private static final String SQL_SELECT_ADDRESS = "SELECT * FROM addressbook WHERE id=? ";
    private static final String SQL_UPDATE_ADDRESS = "UPDATE addressbook SET first_Name=?, last_Name=?, streetaddress=?, city=?, state=?, zipcode=? WHERE id=? ";
    private static final String SQL_SELECT_ALL_ADDRESSES = "SELECT * FROM addressbook";

    private JdbcTemplate jdbcTemplate;

    public AddressBookDbDaoImpl(JdbcTemplate j) {
        this.jdbcTemplate = j;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public AddressBook add(AddressBook address) {

        jdbcTemplate.update(SQL_INSERT_ADDRESS,
                address.getFirstName(),
                address.getLastName(),
                address.getStreetAddress(),
                address.getCity(),
                address.getState(),
                address.getZipCode());

        Integer newId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);

        address.setId(newId);

        return address;

    }

    @Override
    public void delete(AddressBook address) {
        jdbcTemplate.update(SQL_DELETE_ADDRESS, address.getId());

    }

    @Override
    public void deletebyID(Integer Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AddressBook read(Integer Id) {
        AddressBook ab = jdbcTemplate.queryForObject(SQL_SELECT_ADDRESS, new AddressBookMapper(), Id);
        return ab;
    }

    @Override
    public AddressBook readAdd(AddressBook address) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AddressBook> show() {
        List<AddressBook> addresses = jdbcTemplate.query(SQL_SELECT_ALL_ADDRESSES, new AddressBookMapper());
        return addresses;
    }

    @Override
    public void update(AddressBook address) {
        jdbcTemplate.update(SQL_UPDATE_ADDRESS,
                address.getFirstName(),
                address.getLastName(),
                address.getStreetAddress(),
                address.getCity(),
                address.getState(),
                address.getZipCode(),
                address.getId()
        );
    }

    @Override
    public List<AddressBook> findAddressByLastName(String lastName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AddressBook> findAddressByCity(String cityName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, List<AddressBook>> addressByState(String state) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AddressBook> addressByZipCode(String zipcode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class AddressBookMapper implements RowMapper<AddressBook> {

        @Override
        public AddressBook mapRow(ResultSet rs, int i) throws SQLException {

            AddressBook address = new AddressBook();
            address.setId(rs.getInt("id"));
            address.setFirstName(rs.getString("first_Name"));
            address.setLastName(rs.getString("last_Name"));
            address.setStreetAddress(rs.getString("streetaddress"));
            address.setCity(rs.getString("city"));
            address.setState(rs.getString("state"));
            address.setZipCode(rs.getString("zipcode"));

            return address;

        }

    }
}
