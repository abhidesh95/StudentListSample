package com.example.studentlistsample.controller.interpreters;


import com.example.studentlistsample.controller.IStudentContoller;
import com.example.studentlistsample.model.Student;
import com.example.studentlistsample.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(path = "/api/v1")
@RestController
public class StudentControllerInterpreter implements IStudentContoller {

    private IStudentService iStudentService;

    @Autowired
    StudentControllerInterpreter(IStudentService iStudentService)
    {
        this.iStudentService=iStudentService;
    }

    @Override
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return iStudentService.getAllStudents();
    }
}
