package hei.school.TD_K1.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hei.school.TD_K1.Entity.StudentEntity;
import hei.school.TD_K1.Services.StudentServices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;



@RequestMapping
@RestController
public class StudentsController {


    @Autowired
    private StudentServices studentServices;

    @GetMapping("/welcome")
    public ResponseEntity<String> welcomeUser(@RequestParam String name) {
        if(name != null && !name.trim().isEmpty()){
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).body("Welcome " + name);

        }else{
            return ResponseEntity.status(HttpStatusCode.valueOf(400)).body("Vous devez fournir un nom");
        }
    }

    @PostMapping("/student")
    public ResponseEntity<List<StudentEntity>> createNewStudents(@RequestBody List<StudentEntity> student) throws Exception {
        try {

            List<StudentEntity> studentList = studentServices.createStudentServices(student);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(studentList);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @GetMapping("/student")
    public ResponseEntity<?> getAllStudents(@RequestHeader(value = "Accept", required = false) String acceptHeader) {
        try{
       if (acceptHeader == null) {
            return ResponseEntity.status(HttpStatusCode.valueOf(400)).body("Accept doit être requis");
            
        }

        if (acceptHeader.contains("application/json")) {
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(studentList);
        }else if (acceptHeader.contains("text/plain")){
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(studentList.toString());

        }
        else{
            return ResponseEntity.status(HttpStatusCode.valueOf(501)).body("Format non supporté");
        }
        }catch(Exception e){
            return ResponseEntity.status(500).body(e);
        }        
    }
    
}

