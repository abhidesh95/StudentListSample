package com.example.studentlistsample.controllertest;

import com.example.studentlistsample.controller.interpreters.StudentControllerInterpreter;
import com.example.studentlistsample.model.Student;
import com.example.studentlistsample.service.IStudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.samePropertyValuesAs;
import org.hamcrest.MatcherAssert;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StudentControllerTest {

    @Mock
    IStudentService iStudentService;

    @InjectMocks
    StudentControllerInterpreter studentControllerInterpreter;

    @Test
    public void testGetAllStudents()
    {
        List<Student> expected=getSampleStudentList();
        when(iStudentService.getAllStudents()).thenReturn(expected);

        List<Student> actual= studentControllerInterpreter.getAllStudents();

        //tests
        testEquality(actual,expected);
        verify(iStudentService, times(1)).getAllStudents();
    }

    public static List<Student> getSampleStudentList()
    {
        Student st1=new Student();
        st1.setFirstName("abc1");
        st1.setLastName("xyz1");

        Student st2=new Student();
        st2.setFirstName("abc2");
        st2.setLastName("xyz2");


        return Arrays.asList(st1,st2);
    }

    public static void testEquality(List<Student> actual, List<Student> expected)
    {
        assertEquals(expected.size(),actual.size());
        IntStream.range(0, expected.size())
                .forEach(idx -> MatcherAssert.assertThat(actual.get(idx), samePropertyValuesAs(expected.get(idx))));

    }

}
