package com.data.req;

import lombok.Data;

@Data
public class CoursesUpdateReq {
    private int id;
    private String courseName;
    private int soGio;
    private int soBuoi;
}
