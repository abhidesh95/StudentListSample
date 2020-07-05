package com.example.studentlistsample.servicetest;

import com.example.studentlistsample.entities.StudentEntity;
import com.example.studentlistsample.mappers.StudentEntityMapper;
import com.example.studentlistsample.model.Student;
import com.example.studentlistsample.repository.IStudentRepository;
import com.example.studentlistsample.service.interpreters.StudentServiceInterpreter;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest {

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentServiceInterpreter studentServiceInterpreter;

    @Test
    public void testGetAllStudents()
    {
        List<StudentEntity> expected=getSampleStudentEntityList();
        List<Student> expectedStudentList= StudentEntityMapper.getStudentFromEntity(expected);
        when(studentRepository.findAll()).thenReturn(expected);

        List<Student> actual= studentServiceInterpreter.getAllStudents();


        //tests
        testEquality(actual,expectedStudentList);
        verify(studentRepository, times(1)).findAll();
    }

    public static List<StudentEntity> getSampleStudentEntityList()
    {
        StudentEntity st1=new StudentEntity();
        st1.setFirstName("abc1");
        st1.setLastName("xyz1");

        StudentEntity st2=new StudentEntity();
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
