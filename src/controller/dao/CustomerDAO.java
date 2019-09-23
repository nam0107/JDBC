/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import model.Customer;
import controller.ConnectionDB;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoain
 */
public class CustomerDAO implements DAO<Customer> {

    @Override
    public List<Customer> getAll() {
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

    @Override
    public boolean insert(Customer data) {
        Connection con = null;
        CallableStatement callSt = null;
        boolean c = true;
        try {
            con = ConnectionDB.openConnection();
            callSt = con.prepareCall("{call insertCustomer(?,?,?,?)}");
            callSt.setString(1, data.getName());
            callSt.setString(2, data.getYearOfBirth());
            callSt.setString(3, data.getAddress());
            callSt.setString(4, data.getIdCard());
            callSt.executeUpdate();
        } catch (Exception e) {
            c = false;
        } finally {
            ConnectionDB.closeConnection(con, callSt);
        }
        return c;
    }

    @Override
    public boolean update(Customer data) {
        Connection con = null;
        CallableStatement callSt = null;
        boolean c = true;
        try {
            con = ConnectionDB.openConnection();
            callSt = con.prepareCall("{call updateCustomer(?,?,?,?,?)}");
            callSt.setInt(1, data.getId());
            callSt.setString(2, data.getName());
            callSt.setString(3, data.getYearOfBirth());
            callSt.setString(4, data.getAddress());
            callSt.setString(5, data.getIdCard());
            callSt.executeUpdate();
        } catch (Exception e) {
            c = false;
        } finally {
            ConnectionDB.closeConnection(con, callSt);
        }
        return c;
    }

    @Override
    public boolean delete(int id) {
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
