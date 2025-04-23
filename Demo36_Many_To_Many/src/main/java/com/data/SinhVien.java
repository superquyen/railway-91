package com.data;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="sinh_vien")
public class SinhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String maSv;
    private String fullName;
    private GioiTinh gioiTinh;
    @OneToMany(mappedBy = "sinhVien")
    private List<MonHocSinhVien> monHocSinhVienList;

    public SinhVien() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getFullName(String tran_duc_bo) {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public GioiTinh getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(GioiTinh gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public List<MonHocSinhVien> getMonHocSinhVienList() {
        return monHocSinhVienList;
    }

    public void setMonHocSinhVienList(List<MonHocSinhVien> monHocSinhVienList) {
        this.monHocSinhVienList = monHocSinhVienList;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "id=" + id +
                ", maSv='" + maSv + '\'' +
                ", fullName='" + fullName + '\'' +
                ", gioiTinh=" + gioiTinh +
                '}';
    }
}
