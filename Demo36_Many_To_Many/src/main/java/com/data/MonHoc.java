package com.data;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="mon_hoc")
public class MonHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="ten_mon")
    private String name;
    @Column(name = "so_gio")
    private int soGio;
    @Column(name = "so_buoi")
    private int soBuoi;
    @OneToMany(mappedBy = "monHoc")
    private List<MonHocSinhVien>monHocSinhViens;

    public MonHoc() {
    }

    public MonHoc(int id, String name, int soGio, int soBuoi, List<MonHocSinhVien> monHocSinhViens) {
        this.id = id;
        this.name = name;
        this.soGio = soGio;
        this.soBuoi = soBuoi;
        this.monHocSinhViens = monHocSinhViens;
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

    public int getSoGio() {
        return soGio;
    }

    public void setSoGio(int soGio) {
        this.soGio = soGio;
    }

    public int getSoBuoi() {
        return soBuoi;
    }

    public void setSoBuoi(int soBuoi) {
        this.soBuoi = soBuoi;
    }

    public List<MonHocSinhVien> getMonHocSinhViens() {
        return monHocSinhViens;
    }

    public void setMonHocSinhViens(List<MonHocSinhVien> monHocSinhViens) {
        this.monHocSinhViens = monHocSinhViens;
    }

    @Override
    public String toString() {
        return "MonHoc{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", soGio=" + soGio +
                ", soBuoi=" + soBuoi +
                '}';
    }
}
