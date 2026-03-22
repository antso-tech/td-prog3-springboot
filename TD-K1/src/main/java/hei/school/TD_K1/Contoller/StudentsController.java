package hei.school.TD_K1.Contoller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hei.school.TD_K1.Entity.StudentEntity;

import java.util.ArrayList;
import java.util.List;

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

    List<StudentEntity> studentsList = new ArrayList<>();

    @GetMapping("/welcome")
    public ResponseEntity<String> welcomeUser(@RequestParam String name) {
        if(name != null ){
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).body("Welcome " + name);

        }else{
            return ResponseEntity.status(HttpStatusCode.valueOf(400)).body("Vous devez fournir un nom");
        }
    }
 
}

