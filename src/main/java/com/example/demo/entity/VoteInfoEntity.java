package com.example.demo.entity;

import lombok.Data;

@Data
public class VoteInfoEntity {
    private int vote_id;
    private String student_id;
    private String college_name;
    private int vote_time;

    VoteInfoEntity(){}

    public VoteInfoEntity(String studentId, String collegeName, int voteTime){
        this.student_id = studentId;
        this.college_name = collegeName;
        this.vote_time = voteTime;

    }
}
