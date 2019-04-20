package com.example.demo.service;

import com.example.demo.entity.CollegeInfoEntity;
import com.example.demo.entity.VoteInfoEntity;
import com.example.demo.entity.json.LevelJson;
import com.example.demo.mapper.CollegeInfoMapper;
import com.example.demo.mapper.VoteInfoMapper;
import com.example.demo.util.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

@Service
public class VoteInfoService {

    @Autowired
    VoteInfoMapper voteInfoMapper;
    @Autowired
    CollegeInfoMapper collegeInfoMapper;

    public String vote(String studentId,String collegeName,String studentCollege, Date date) throws Exception {

        //判断时间是否合法
        Integer  time  = voteInfoMapper.selectMaxTime(studentId);
        if( time!=null && time >= TimeUtils.getTimestamp(date)){
             return "Illegal operation";
        }

        //判断是否有余票
        int[] voteNum = voteSelect(studentId,date);
        if (voteNum[1] == 0){
            return "you do not have the ticket now";
        }

        //在投票表中加入投票纪录
        voteInfoMapper.add( new VoteInfoEntity(studentId,collegeName,TimeUtils.getTimestamp(date)));
        //是否是本院的学生，并修改学院得分
        if (!studentCollege.equals(collegeName)){
            int score = 10;
            collegeInfoMapper.updateVote(score,collegeName);
        }
        else {
            double score = 0;
            CollegeInfoEntity collegeInfoEntity =  collegeInfoMapper.select(studentCollege);
            if (voteInfoMapper.selectIfVote(studentId, studentCollege) == null) {
                score = 1000.0 / collegeInfoEntity.getStudents_all_num();
            }
            collegeInfoMapper.updateVote(score,collegeName);
        }
      return "ok";

    }

    /**
     * 返回学生的余票result[1] 及学生总投票数result[0]
     * @param studentId
     * @param date
     * @return result[2]
     * @throws ParseException
     */
    public  int[] voteSelect(String studentId, Date date) throws ParseException {
        int voteNum = 5;
        String today = TimeUtils.getDateString(date).substring(0, TimeUtils.getDateString(date).indexOf(" "));
        ArrayList<VoteInfoEntity> voteInfoEntities = voteInfoMapper.selectByStudentId(studentId);
        int[] result = new int[2];
        result[0] = voteInfoEntities.size();
        if (result[0] > 0) {
            for (VoteInfoEntity voteInfoEntity :
                    voteInfoEntities) {
                Date voteDate = TimeUtils.getStringDate(voteInfoEntity.getVote_time());
                String modelDate = TimeUtils.getDateString(voteDate).substring(0, TimeUtils.getDateString(date).indexOf(" "));
                if (today.equals(modelDate)) {
                    voteNum--;
                }
            }
        }
        result[1] = voteNum;
        return result;
    }


    public LevelJson levelSelect(){
      int voteNumTotal = voteInfoMapper.selectAll().size();
      int level = voteNumTotal/500;
      int levelUpNeed = 500 - voteNumTotal%500;
      return new LevelJson(voteNumTotal,level,levelUpNeed);
    }

}
