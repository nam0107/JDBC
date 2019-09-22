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
public class BillModel {

    public List<Bill> getAllBill() {
        Connection con = null;
        CallableStatement callSt = null;
        List<Bill> list = new ArrayList<>();
        try {
            con = ConnectionDB.openConnection();
            callSt = con.prepareCall("{call getAllBill()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Bill s = new Bill();
                s.setId(rs.getInt("id"));
                s.setAmount(rs.getFloat("amount"));
                s.setHiringId(rs.getInt("hiringId"));
                list.add(s);
            }
        } catch (Exception e) {
            return null;
        } finally {
            ConnectionDB.closeConnection(con, callSt);
        }
        return list;
    }

    public boolean insertBill(Bill s) {
        Connection con = null;
        CallableStatement callSt = null;
        boolean c = true;
        try {
            con = ConnectionDB.openConnection();
            callSt = con.prepareCall("{call insertBill(?,?)}");
            callSt.setFloat(1, s.getAmount());
            callSt.setInt(2, s.getHiringId());
            callSt.executeUpdate();
        } catch (Exception e) {
            c = false;
        } finally {
            ConnectionDB.closeConnection(con, callSt);
        }
        return c;
    }

    public boolean updateBill(Bill s) {
        Connection con = null;
        CallableStatement callSt = null;
        boolean c = true;
        try {
            con = ConnectionDB.openConnection();
            callSt = con.prepareCall("{call updateBill(?,?,?)}");
            callSt.setInt(1, s.getId());
            callSt.setFloat(2, s.getAmount());
            callSt.setInt(3, s.getHiringId());
            callSt.executeUpdate();
        } catch (Exception e) {
            c = false;
        } finally {
            ConnectionDB.closeConnection(con, callSt);
        }
        return c;
    }

    public boolean deleteBill(int id) {
        Connection con = null;
        CallableStatement callSt = null;
        boolean c = true;
        try {
            con = ConnectionDB.openConnection();
            callSt = con.prepareCall("{call deleteBill(?)}");
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
