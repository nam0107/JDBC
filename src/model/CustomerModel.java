/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.ConnectionDB;
import entities.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoain
 */
public class CustomerModel {
    public List<Customer> getAllCustomer() {
        Connection con = null;
        CallableStatement callSt = null;
        List<Customer> list = new ArrayList<>();
        try {
            con = ConnectionDB.openConnection();
            callSt = con.prepareCall("{call getAllCustomer()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Customer s = new Customer();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setYearOfBirth(rs.getString("yearOfBirth"));
                s.setAddress(rs.getString("address"));
                s.setIdCard(rs.getString("idCard"));                
                list.add(s);
            }
        } catch (Exception e) {
            return null;
        } finally {
            ConnectionDB.closeConnection(con, callSt);
        }
        return list;
    }

    public boolean insertCustomer(Customer s) {
        Connection con = null;
        CallableStatement callSt = null;
        boolean c = true;
        try {
            con = ConnectionDB.openConnection();
            callSt = con.prepareCall("{call insertCustomer(?,?,?,?)}");
            callSt.setString(1, s.getName());
            callSt.setString(2, s.getYearOfBirth());
            callSt.setString(3, s.getAddress());
            callSt.setString(4, s.getIdCard());            
            callSt.executeUpdate();
        } catch (Exception e) {
            c = false;
        } finally {
            ConnectionDB.closeConnection(con, callSt);
        }
        return c;
    }

    public boolean updateCustomer(Customer s) {
        Connection con = null;
        CallableStatement callSt = null;
        boolean c = true;
        try {
            con = ConnectionDB.openConnection();
            callSt = con.prepareCall("{call updateCustomer(?,?,?,?,?)}");
            callSt.setInt(1, s.getId());
            callSt.setString(2, s.getName());
            callSt.setString(3, s.getYearOfBirth());
            callSt.setString(4, s.getAddress());
            callSt.setString(5, s.getIdCard());     
            callSt.executeUpdate();
        } catch (Exception e) {
            c = false;
        } finally {
            ConnectionDB.closeConnection(con, callSt);
        }
        return c;
    }

    public boolean deleteCustomer(int id) {
        Connection con = null;
        CallableStatement callSt = null;
        boolean c = true;
        try {
            con = ConnectionDB.openConnection();
            callSt = con.prepareCall("{call deleteCustomer(?)}");
            callSt.setInt(1, id);
            callSt.executeUpdate();
        } catch (Exception e) {
            c = false;
        } finally {
            ConnectionDB.closeConnection(con, callSt);
        }
        return c;
    }
}
