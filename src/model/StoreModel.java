/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.ConnectionDB;
import entities.Store;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoain
 */
public class StoreModel {
    public List<Store> getAllStore() {
        Connection con = null;
        CallableStatement callSt = null;
        List<Store> list = new ArrayList<>();
        try {
            con = ConnectionDB.openConnection();
            callSt = con.prepareCall("{call getAllStore()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Store s = new Store();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setAddress(rs.getString("address"));
                s.setDescription(rs.getString("description"));                
                list.add(s);
            }
        } catch (Exception e) {
            return null;
        } finally {
            ConnectionDB.closeConnection(con, callSt);
        }
        return list;
    }
    
    public boolean insertStore(Store s) {
        Connection con = null;
        CallableStatement callSt = null;
        boolean c = true;
        try {
            con = ConnectionDB.openConnection();
            callSt = con.prepareCall("{call insertStore(?,?,?)}");
            callSt.setString(1, s.getName());
            callSt.setString(2, s.getAddress());
            callSt.setString(3, s.getDescription());      
            callSt.executeUpdate();
        } catch (Exception e) {
            c = false;
        } finally {
            ConnectionDB.closeConnection(con, callSt);
        }
        return c;
    }
    
    public boolean updateStore(Store s) {
        Connection con = null;
        CallableStatement callSt = null;
        boolean c = true;
        try {
            con = ConnectionDB.openConnection();
            callSt = con.prepareCall("{call updateStore(?,?,?,?)}");
            callSt.setInt(1, s.getId());
            callSt.setString(2, s.getName());
            callSt.setString(3, s.getAddress());
            callSt.setString(4, s.getDescription());      
            callSt.executeUpdate();
        } catch (Exception e) {
            c = false;
        } finally {
            ConnectionDB.closeConnection(con, callSt);
        }
        return c;
    }
    
    public boolean deleteStore(int id) {
        Connection con = null;
        CallableStatement callSt = null;
        boolean c = true;
        try {
            con = ConnectionDB.openConnection();
            callSt = con.prepareCall("{call deleteStore(?)}");
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
