package com.vti.entity;

public class Position {
    private int id;
    private positionName name;
public enum positionName{
    DEV, TEST, SCRUM_MASTER, PM
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setName(positionName name){
        this.name = name;

    }
    public positionName getName(){
        return name;
    }

}
