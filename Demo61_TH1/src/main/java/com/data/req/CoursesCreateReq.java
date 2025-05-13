package com.data.req;

import lombok.Data;

@Data
public class CoursesCreateReq {
    private int id;
    private String courseName;
    private int soBuoi;
    private int soGio;
}
