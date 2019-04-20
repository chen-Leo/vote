package com.example.demo.entity.json;

import com.example.demo.entity.StudentInfoEntity;
import lombok.Data;

@Data
public class StudentJson {
    private String studentId;
    private int voteNumToday;
    private int voteAll;
    private String studentCollegeName;

    public StudentJson() {
    }

    public StudentJson(String studentId,int voteNumToday,int voteAll,String studentCollegeName) {
        this.studentId =studentId;
        this.voteNumToday = voteNumToday;
        this.voteAll = voteAll;
        this.studentCollegeName = studentCollegeName;
    }
}
