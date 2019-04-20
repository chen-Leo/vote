package com.example.demo.controller;

import com.example.demo.entity.xml.WeChat;
import com.example.demo.service.StudentInfoService;
import com.example.demo.service.VoteInfoService;
import com.example.demo.util.ContentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/vote")
public class VoteController {
@Autowired
    VoteInfoService voteInfoService;
@Autowired
    StudentInfoService studentInfoService;



    @PostMapping(value = "/xml",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public String addNewVote(@RequestBody WeChat weChat) throws Exception {

        String content =  weChat.getContent();
        String[] result = ContentUtils.contentFind(content);
        if(result!= null){
          String  studentId =  result[0];
          String  collegeName = result[1];
            Date date = new Date();
            String studentCollegeName =  studentInfoService.selectStudent(studentId).getStudentCollegeName();
            if (studentCollegeName ==null){
                return "Illegal operation";
            }
            else  {return voteInfoService.vote(studentId,collegeName,studentCollegeName,date);}
        }
        else { return "XML ERROR";
        }
    }
}
