package com.data.dto;

import lombok.Data;

@Data
public class LessonDTO {
    private int id;
    private String lessonName;
    private String moTa;
    private int soGio;

    public LessonDTO() {
    }
}
