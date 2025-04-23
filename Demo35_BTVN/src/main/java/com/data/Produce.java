package com.data;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "produce")
public class Produce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    private Integer stock;
    @Column(name = "create_date")
    private LocalDate createDate;
    @OneToOne(mappedBy = "produce")
    private TypeProduce typeProduce;
    public Produce() {
    }

    public Produce(Integer id, String name, Double price, Integer stock, LocalDate createDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public TypeProduce getTypeProduce() {
        return typeProduce;
    }

    public void setTypeProduce(TypeProduce typeProduce) {
        this.typeProduce = typeProduce;
    }

    @Override
    public String toString() {
        return "Produce{" +
                "id= " + id +
                ", name= ' " + name + '\'' +
                ", price= " + price +" vnd "+
                ", stock= " + stock +
                ", createDate= " + createDate +
                '}';
    }
}
