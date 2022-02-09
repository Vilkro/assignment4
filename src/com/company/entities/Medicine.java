package com.company.entities;

import java.util.Date;
public class Medicine {
    private int id;
    private String name;
    private double price;
    private Date date;
    private String manufacturer;

    public Medicine() {

    }

    public Medicine(String name, double price, Date date, String manufacturer) {
        setName(name);
        setPrice(price);
        setDate(date);
        setManufacturer(manufacturer);
    }

    public Medicine(int id, String name, double price, Date date, String manufacturer) {
        setId(id);
        setName(name);
        setPrice(price);
        setDate(date);
        setManufacturer(manufacturer);
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", date='" + date + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}