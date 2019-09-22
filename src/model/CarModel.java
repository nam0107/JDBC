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
public class CarModel {

    public List<Car> getAllCar() {
        Connection con = null;
        CallableStatement callSt = null;
        List<Car> list = new ArrayList<>();
        try {
            con = ConnectionDB.openConnection();
            callSt = con.prepareCall("{call getAllCar()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Car s = new Car();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setSeatNum(rs.getInt("seaNum"));
                s.setRegYear(rs.getInt("regYear"));
                s.setPrice(rs.getFloat("price"));
                s.setStoreId(rs.getInt("storeId"));
                list.add(s);
            }
        } catch (Exception e) {
            return null;
        } finally {
            ConnectionDB.closeConnection(con, callSt);
        }
        return list;
    }

    public boolean insertCar(Car s) {
        Connection con = null;
        CallableStatement callSt = null;
        boolean c = true;
        try {
            con = ConnectionDB.openConnection();
            callSt = con.prepareCall("{call insertCar(?,?,?,?,?,?)}");
            callSt.setString(1, s.getName());
            callSt.setInt(2, s.getSeatNum());
            callSt.setInt(3, s.getRegYear());
            callSt.setInt(4, s.getExaYear());
            callSt.setFloat(5, s.getPrice());
            callSt.setInt(6, s.getStoreId());
            callSt.executeUpdate();
        } catch (Exception e) {
            c = false;
        } finally {
            ConnectionDB.closeConnection(con, callSt);
        }
        return c;
    }

    public boolean updateCar(Car s) {
        Connection con = null;
        CallableStatement callSt = null;
        boolean c = true;
        try {
            con = ConnectionDB.openConnection();
            callSt = con.prepareCall("{call updateCar(?,?,?,?,?,?,?)}");
            callSt.setInt(1, s.getId());
            callSt.setString(2, s.getName());
            callSt.setInt(3, s.getSeatNum());
            callSt.setInt(4, s.getRegYear());
            callSt.setInt(5, s.getExaYear());
            callSt.setFloat(6, s.getPrice());
            callSt.setInt(7, s.getStoreId());
            callSt.executeUpdate();
        } catch (Exception e) {
            c = false;
        } finally {
            ConnectionDB.closeConnection(con, callSt);
        }
        return c;
    }

    public boolean deleteCar(int id) {
        Connection con = null;
        CallableStatement callSt = null;
        boolean c = true;
        try {
            con = ConnectionDB.openConnection();
            callSt = con.prepareCall("{call deleteCar(?)}");
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
