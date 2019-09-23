/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import model.Car;
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
public class CarDAO implements DAO<Car> {

    @Override
    public List<Car> getAll() {
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

    @Override
    public boolean insert(Car data) {
        Connection con = null;
        CallableStatement callSt = null;
        boolean c = true;
        try {
            con = ConnectionDB.openConnection();
            callSt = con.prepareCall("{call insertCar(?,?,?,?,?,?)}");
            callSt.setString(1, data.getName());
            callSt.setInt(2, data.getSeatNum());
            callSt.setInt(3, data.getRegYear());
            callSt.setInt(4, data.getExaYear());
            callSt.setFloat(5, data.getPrice());
            callSt.setInt(6, data.getStoreId());
            callSt.executeUpdate();
        } catch (Exception e) {
            c = false;
        } finally {
            ConnectionDB.closeConnection(con, callSt);
        }
        return c;
    }

    @Override
    public boolean update(Car data) {
        Connection con = null;
        CallableStatement callSt = null;
        boolean c = true;
        try {
            con = ConnectionDB.openConnection();
            callSt = con.prepareCall("{call updateCar(?,?,?,?,?,?,?)}");
            callSt.setInt(1, data.getId());
            callSt.setString(2, data.getName());
            callSt.setInt(3, data.getSeatNum());
            callSt.setInt(4, data.getRegYear());
            callSt.setInt(5, data.getExaYear());
            callSt.setFloat(6, data.getPrice());
            callSt.setInt(7, data.getStoreId());
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
