package com.vti.entity;

public class Student implements IStudent{
    private int id;
    private String name;
    private int group;
    @Override
    public void diemDanh(){
        System.out.println(this.name + " điểm danh");
    }
    @Override
    public void hocBai(){
        System.out.println(this.name+ " đang học bài");
    }

    @Override
    public void diDonVeSinh() {
        System.out.println(this.name + " đi dọn vệ sinh");
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

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }
}
