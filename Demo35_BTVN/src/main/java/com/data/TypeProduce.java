package com.data;

import jakarta.persistence.*;

@Entity
@Table(name="type_produce")
public class TypeProduce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;
    @OneToOne
    @JoinColumn(name = "produce_id", unique = true)
    private Produce produce;

    public TypeProduce() {
    }

    public TypeProduce(Integer id, String type, Produce produce) {
        this.id = id;
        this.type = type;
        this.produce = produce;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Produce getProduce() {
        return produce;
    }

    public void setProduce(Produce produce) {
        this.produce = produce;
    }

    @Override
    public String toString() {
        return "TypeProduce{" +
                "id= " + id +
                ", type= ' " + type +
                '}';
    }
}
