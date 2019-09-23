/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import model.Bill;
import controller.ConnectionDB;
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
public class BillDAO implements DAO<Bill> {

    @Override
    public List<Bill> getAll() {
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

    @Override
    public boolean insert(Bill data) {
        Connection con = null;
        CallableStatement callSt = null;
        boolean c = true;
        try {
            con = ConnectionDB.openConnection();
            callSt = con.prepareCall("{call insertBill(?,?)}");
            callSt.setFloat(1, data.getAmount());
            callSt.setInt(2, data.getHiringId());
            callSt.executeUpdate();
        } catch (Exception e) {
            c = false;
        } finally {
            ConnectionDB.closeConnection(con, callSt);
        }
        return c;
    }

    @Override
    public boolean update(Bill data) {
        Connection con = null;
        CallableStatement callSt = null;
        boolean c = true;
        try {
            con = ConnectionDB.openConnection();
            callSt = con.prepareCall("{call updateBill(?,?,?)}");
            callSt.setInt(1, data.getId());
            callSt.setFloat(2, data.getAmount());
            callSt.setInt(3, data.getHiringId());
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
