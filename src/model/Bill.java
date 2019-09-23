/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hoain
 */
public class Bill {
    private int id;
    private float amount;
    private int hiringId;

    public Bill() {
    }

    public Bill(int id, float amount, int hiringId) {
        this.id = id;
        this.amount = amount;
        this.hiringId = hiringId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getHiringId() {
        return hiringId;
    }

    public void setHiringId(int hiringId) {
        this.hiringId = hiringId;
    }
    
    public Object[] toObject() {
        return new Object[]{
            this.id,this.amount,this.hiringId
        };
    }
}
