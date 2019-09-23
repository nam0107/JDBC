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
public class Customer {
    private int id;
    private String name;
    private String yearOfBirth;
    private String address;
    private String idCard;

    public Customer() {
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

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer(int id, String name, String yearOfBirth, String address, String idCard) {
        this.id = id;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.address = address;
        this.idCard = idCard;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Object[] toObject() {
        return new Object[]{
            this.id,this.name,this.yearOfBirth,this.address,this.idCard
        };
    }
  
}
