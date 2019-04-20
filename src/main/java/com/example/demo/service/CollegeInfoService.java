package com.example.demo.service;

import com.example.demo.entity.CollegeInfoEntity;
import com.example.demo.entity.json.CollegeJson;
import com.example.demo.mapper.CollegeInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CollegeInfoService {
    @Autowired
    CollegeInfoMapper collegeInfoMapper;

    public ArrayList<CollegeJson> select() {

        ArrayList<CollegeInfoEntity> collegeInfoEntities = collegeInfoMapper.selectAll();
        ArrayList<CollegeJson> result = new ArrayList<CollegeJson>();

        for (CollegeInfoEntity collegeInfoEntity :
                collegeInfoEntities) {
            CollegeJson collegeJson = new CollegeJson(collegeInfoEntity.getCollege_name(), collegeInfoEntity.getCollege_vote_num(), collegeInfoEntity.getScore());
            result.add(collegeJson);
        }
        return  result;
    }
}
