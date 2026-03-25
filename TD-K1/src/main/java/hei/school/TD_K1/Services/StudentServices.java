package hei.school.TD_K1.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import hei.school.TD_K1.Entity.StudentEntity;

public class StudentServices {
    private List<StudentEntity> studentList = new ArrayList<>();

    public List<String> getAllStudentsServices(String reference,String firstName,String lastName,int age) {
        return studentList.stream().map(e -> e.toString()).toList();
    }

    public List<StudentEntity> createStudentServices(List<StudentEntity> student){
        studentList.addAll(student)  ; 
        return studentList;
    }
}
