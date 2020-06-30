package com.example.studentlistsample.mappers;



import com.example.studentlistsample.entities.StudentEntity;
import com.example.studentlistsample.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class StudentEntityMapper {


    public static List<Student> getStudentFromEntity(List<StudentEntity> studentEntities)
    {

        return studentEntities.stream().map(StudentEntityMapper::convert).collect(Collectors.toList());
    }

    public static  Student convert(StudentEntity entity)
    {
        Student student = new Student();
        student.setFirstName(entity.getFirstName());
        student.setLastName(entity.getLastName());
        student.setCity(entity.getCity());

        return student;
    }

}
