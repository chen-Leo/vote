package com.example.demo.service;

import com.example.demo.entity.StudentInfoEntity;
import com.example.demo.entity.json.StudentJson;
import com.example.demo.mapper.StudentInfoMapper;
import com.example.demo.util.HtmlRequest;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StudentInfoService {

    @Autowired
    StudentInfoMapper studentInfoMapper;
    @Autowired
    VoteInfoService voteInfoService;


    public StudentJson selectStudent(String studentId) throws Exception {
        Date date  = new Date();
        //判断是否存在该学生
        String studentCollegeName =HtmlRequest.collegeFind(studentId);
        if(studentCollegeName!= null) {
            //判断是否参加过这次活动
           if (studentInfoMapper.select(studentId) != null){
              int[] voteMessage = voteInfoService.voteSelect(studentId,date);
              return new StudentJson(studentId,voteMessage[1],voteMessage[0],studentCollegeName);
           }
           else {
                studentInfoMapper.insert(new StudentInfoEntity (studentId,studentCollegeName));
                return new StudentJson(studentId,5,0,studentCollegeName);
           }
        }
        else {
            return null;
        }
    }



}
