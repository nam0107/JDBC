/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author hoain
 */
public class Car {
    private int id;
    private String name;
    private int seatNum;
    private int regYear;
    private int exaYear;
    private float price;
    private int storeId;

    public Car() {
    }

    public Car(int id, String name, int seatNum, int regYear, int exaYear, float price, int storeId) {
        this.id = id;
        this.name = name;
        this.seatNum = seatNum;
        this.regYear = regYear;
        this.exaYear = exaYear;
        this.price = price;
        this.storeId = storeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public int getRegYear() {
        return regYear;
    }

    public void setRegYear(int regYear) {
        this.regYear = regYear;
    }

    public int getExaYear() {
        return exaYear;
    }

    public void setExaYear(int exaYear) {
        this.exaYear = exaYear;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
    
}
