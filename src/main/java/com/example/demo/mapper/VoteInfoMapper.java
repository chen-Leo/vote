package com.example.demo.mapper;

import com.example.demo.entity.VoteInfoEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface VoteInfoMapper {

    @Insert("INSERT INTO vote_info(student_id,college_name,vote_time) value(#{student_id},#{college_name},#{vote_time})")
    @Options(useGeneratedKeys = true,keyProperty = "vote_id",keyColumn = "vote_id")
    void add(VoteInfoEntity voteInfoEntity);

    @Select("SELECT * FROM vote_info WHERE student_id = #{studentId}")
    ArrayList<VoteInfoEntity> selectByStudentId(String studentId);

    @Select("SELECT * FROM vote_info WHERE student_id = #{studentId} AND college_name  = #{collegeName}")
    ArrayList<VoteInfoEntity> selectIfVote(String studentId,String collegeName);

    @Select("SELECT MAX(vote_time) FROM  vote_info WHERE student_id = #{studentId}")
    Integer selectMaxTime(String studentId);

    @Select("SELECT * FROM vote_info  ")
    ArrayList<VoteInfoEntity> selectAll();

}
