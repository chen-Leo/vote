package com.example.demo.entity;

import lombok.Data;

@Data
public class StudentInfoEntity {

    private int student_info_id;
    private String student_id;
    private String student_college_name;

    public StudentInfoEntity() {}

    public StudentInfoEntity(String studentId, String studentCollegeName) {

        this.student_id = studentId;
        this.student_college_name = studentCollegeName;


    }
}
