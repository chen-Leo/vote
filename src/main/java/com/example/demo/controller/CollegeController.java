package com.example.demo.controller;

import com.example.demo.entity.json.CollegeJson;
import com.example.demo.service.CollegeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/college")
public class CollegeController {
    @Autowired
    CollegeInfoService collegeInfoService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ArrayList<CollegeJson> select() {
     return collegeInfoService.select();
    }

}
