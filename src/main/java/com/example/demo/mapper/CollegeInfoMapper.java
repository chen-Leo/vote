package com.example.demo.mapper;

import com.example.demo.entity.CollegeInfoEntity;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface CollegeInfoMapper {

    @Insert("INSERT INTO college_info ( college_name, college_vote_num ) value(#{college_name} ,#{college_vote_num})")
    @Options(useGeneratedKeys = true,keyProperty = "college_info_id",keyColumn = "college_info_id")
    void add(CollegeInfoEntity collegeInfoEntity);

    @Select("SELECT * FROM college_info ")
    ArrayList<CollegeInfoEntity> selectAll();

    /**
     * 更新得票分数
     * @param score
     * @param college_name
     */
    @Update("UPDATE college_info SET score = #{score}+ score,college_vote_num =  college_vote_num +1  WHERE college_name  = #{college_name};")
    void updateVote(double score,String college_name);


    @Select("SELECT * FROM college_info WHERE college_name = #{collegeName}")
    CollegeInfoEntity select(String collegeName);








}
