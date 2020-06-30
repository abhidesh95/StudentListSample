package com.example.studentlistsample.repository;
import com.example.studentlistsample.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<StudentEntity,Long> {
}



