package hei.school.TD_K1.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hei.school.TD_K1.Entity.ErrorQuery;
import hei.school.TD_K1.Entity.StudentEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


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
    
    @GetMapping("/student")
    public List<?> getAllStudents(@RequestHeader(value = "Accept", required = false) String acceptHeader) {
        if(acceptHeader.contains("text/plain")){
            return studentsList;
        }else{
            List<ErrorQuery> studentEntityError = new ArrayList<>();
            ErrorQuery errorQuerie = new ErrorQuery("Format non supporté",500);
            studentEntityError.add(errorQuerie);
            return studentEntityError;
        }
       
        
    }
    
    
}
