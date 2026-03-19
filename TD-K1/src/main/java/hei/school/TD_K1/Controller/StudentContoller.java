package hei.school.TD_K1.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hei.school.TD_K1.Entity.StudentEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping
public class StudentContoller {
    List<StudentEntity> studentsList = new ArrayList<>();

    @GetMapping("/welcome")
    public String getWelcomeMessage(@RequestParam String name) {
        return "Welcome " + name;
    }

    @PostMapping("/student")
    public List<StudentEntity> postMethodName(@RequestBody List<StudentEntity> students) {
        studentsList.addAll(students);
        return studentsList;
    }
    
    
}
