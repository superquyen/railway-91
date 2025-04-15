package com.data;


import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    @Column(name= "`name`")
    private String name;
    @Column(name="price", columnDefinition = "bigint")
    private int price;
    private String country;
    @Column(name= "create_date")
    private LocalDate createDate;
    private int quantity;
    public Product(){

    }

    public Product(int id, String name, int price, String country, LocalDate createDate, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.country = country;
        this.createDate = createDate;
        this.quantity = quantity;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", country='" + country + '\'' +
                ", createDate=" + createDate +
                ", quantity=" + quantity +
                '}';
    }
}
