package com.data;

import jakarta.persistence.*;

@Entity
@Table(name = "mon_hoc_sinh_vien")
public class MonHocSinhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name= "mon_hoc_id")
    private MonHoc monHoc;
    @ManyToOne
    @JoinColumn(name="sinh_vien_id")
    private SinhVien sinhVien;

    public MonHocSinhVien() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    @Override
    public String toString() {
        return "MonHocSinhVien{" +
                "id=" + id +
                ", monHoc=" + monHoc +
                ", sinhVien=" + sinhVien +
                '}';
    }
}
