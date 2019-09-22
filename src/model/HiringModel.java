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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hoain
 */
public class HiringModel {

    public List<Hiring> getAllHiring() {
        Connection con = null;
        CallableStatement callSt = null;
        List<Hiring> list = new ArrayList<>();
        try {
            con = ConnectionDB.openConnection();
            callSt = con.prepareCall("{call getAllHiring()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Hiring s = new Hiring();
                s.setId(rs.getInt("id"));
                SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                Date d1 = rs.getDate("startDate");
                s.setStartDate(f.format(d1));
                Date d2 = rs.getDate("endDate");
                s.setEndDate(f.format(d2));
                s.setCustomerId(rs.getInt("customerId"));
                s.setCarId(rs.getInt("carId"));
                list.add(s);
            }
        } catch (Exception e) {
            return null;
        } finally {
            ConnectionDB.closeConnection(con, callSt);
        }
        return list;
    }

    public boolean insertHiring(Hiring s) {
        Connection con = null;
        CallableStatement callSt = null;
        boolean c = true;
        try {
            con = ConnectionDB.openConnection();
            callSt = con.prepareCall("{call insertHiring(?,?,?,?)}");
            callSt.setString(1, s.getStartDate());
            callSt.setString(2, s.getEndDate());
            callSt.setInt(3, s.getCustomerId());
            callSt.setInt(4, s.getCarId());
            callSt.executeUpdate();
        } catch (Exception e) {
            c = false;
        } finally {
            ConnectionDB.closeConnection(con, callSt);
        }
        return c;
    }

    public boolean updateHiring(Hiring s) {
        Connection con = null;
        CallableStatement callSt = null;
        boolean c = true;
        try {
            con = ConnectionDB.openConnection();
            callSt = con.prepareCall("{call updateHiring(?,?,?,?,?)}");
            callSt.setInt(1, s.getId());
            callSt.setString(2, s.getStartDate());
            callSt.setString(3, s.getEndDate());
            callSt.setInt(4, s.getCustomerId());
            callSt.setInt(5, s.getCarId());
            callSt.executeUpdate();
        } catch (Exception e) {
            c = false;
        } finally {
            ConnectionDB.closeConnection(con, callSt);
        }
        return c;
    }

    public boolean deleteHiring(int id) {
        Connection con = null;
        CallableStatement callSt = null;
        boolean c = true;
        try {
            con = ConnectionDB.openConnection();
            callSt = con.prepareCall("{call deleteHiring(?)}");
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
