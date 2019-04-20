package com.example.demo.entity;

import lombok.Data;

@Data
public class CollegeInfoEntity {
    private int    college_info_id;
    private String college_name;
    private int    college_vote_num;
    private double score;
    private int    students_all_num;

    CollegeInfoEntity() {}
    public CollegeInfoEntity(String collegeName, int collegeVoteNum) {
        this.college_name = collegeName;
        this.college_vote_num = collegeVoteNum;
    }
}
