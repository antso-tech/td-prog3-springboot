package hei.school.TD_K1.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import hei.school.TD_K1.Entity.StudentEntity;

@Service
public class StudentServices {
    private List<StudentEntity> studentList = new ArrayList<>();

    public List<StudentEntity> getAllStudentsServices(String reference,String firstName,String lastName,int age) {
        return studentList;
    }

    public String createStudentServices(List<StudentEntity> student){
        studentList.addAll(student)  ; 
        return studentList.toString();
    }


}
