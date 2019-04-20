package com.example.demo.mapper;

import com.example.demo.entity.StudentInfoEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface StudentInfoMapper {

    @Select("SELECT * FROM student_info WHERE student_Id = #{studentId}")
    StudentInfoEntity select (String studentId);

    @Insert("INSERT into student_info(student_id,student_college_name) value( #{student_id}, #{student_college_name} )")
    @Options(useGeneratedKeys = true,keyProperty = "student_info_id",keyColumn = "student_info_id")
    void insert (StudentInfoEntity studentInfoEntity);








}
