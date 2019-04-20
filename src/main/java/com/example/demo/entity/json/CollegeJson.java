package com.example.demo.entity.json;

import lombok.Data;

@Data
public class CollegeJson {

    private String collegeName;
    private int    collegeVoteNum;
    private double score;

    public  CollegeJson(){}

    public  CollegeJson(String collegeName,int collegeVoteNum,double score){
        this.collegeName = collegeName;
        this.collegeVoteNum = collegeVoteNum;
        this.score = score;
    }

}
