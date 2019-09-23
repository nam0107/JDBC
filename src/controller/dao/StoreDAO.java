/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import controller.ConnectionDB;
import model.Store;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoain
 */
public class StoreDAO implements DAO<Store> {

    @Override
    public boolean insert(Store data) {
        Connection con = null;
        CallableStatement callSt = null;
        boolean c = true;
        try {
            con = ConnectionDB.openConnection();
            callSt = con.prepareCall("{call insertStore(?,?,?)}");
            callSt.setString(1, data.getName());
            callSt.setString(2, data.getAddress());
            callSt.setString(3, data.getDescription());
            callSt.executeUpdate();
        } catch (Exception e) {
            c = false;
        } finally {
            ConnectionDB.closeConnection(con, callSt);
        }
        return c;
    }

    @Override
    public boolean update(Store data) {
        Connection con = null;
        CallableStatement callSt = null;
        boolean c = true;
        try {
            con = ConnectionDB.openConnection();
            callSt = con.prepareCall("{call updateStore(?,?,?,?)}");
            callSt.setInt(1, data.getId());
            callSt.setString(2, data.getName());
            callSt.setString(3, data.getAddress());
            callSt.setString(4, data.getDescription());
            callSt.executeUpdate();
        } catch (Exception e) {
            c = false;
        } finally {
            ConnectionDB.closeConnection(con, callSt);
        }
        return c;
    }

    @Override
    public List<Store> getAll() {
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

    @Override
    public boolean delete(int id) {
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
