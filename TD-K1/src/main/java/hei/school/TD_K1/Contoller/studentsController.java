package hei.school.TD_K1.Contoller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hei.school.TD_K1.Entity.StudentEntity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping
@RestController
public class studentsController {

    List<StudentEntity> studentsList = new ArrayList<>();

    @GetMapping("/welcome")
    public ResponseEntity<String> welcomeUser(@RequestParam String name) {
        if(name != null){
            return ResponseEntity.status(200).body("Welcome " + name);

        }else{
            return ResponseEntity.status(400).body("Vous devez fournir un nom");
        }
    }

     public ResponseEntity<List<StudentEntity>> getAllStudents(@RequestBody List<StudentEntity> studentEntity){
        studentsList.addAll(studentEntity);
        return ResponseEntity.status(201).body(studentsList);

     }

     
    
}

