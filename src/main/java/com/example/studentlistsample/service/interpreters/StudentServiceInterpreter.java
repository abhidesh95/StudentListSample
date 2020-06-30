package com.example.studentlistsample.service.interpreters;

import com.example.studentlistsample.mappers.StudentEntityMapper;
import com.example.studentlistsample.model.Student;
import com.example.studentlistsample.repository.IStudentRepository;
import com.example.studentlistsample.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceInterpreter implements IStudentService {

    private IStudentRepository iStudentRepository;

    @Autowired
    StudentServiceInterpreter(IStudentRepository iStudentRepository)
    {
        this.iStudentRepository=iStudentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return StudentEntityMapper.getStudentFromEntity(iStudentRepository.findAll());
    }
}
